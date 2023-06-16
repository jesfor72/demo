package com.test;

import java.text.MessageFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.bean.BonificoBean;

import com.test.bean.ListaSaldoBean;
import com.test.bean.ListaTransazioniBean;
import com.test.bean.SaldoBean;
import com.test.bean.TransazioneBean;
import com.test.properties.TestConfigurationProperties;

@Component
public class ManageRequest {
private static final Logger log = LoggerFactory.getLogger(ManageRequest.class);

	@Autowired
	private TestConfigurationProperties testConfigurationProperties;

	public void leggiTransazioni(String[] args) {
		String transazioneUrl = testConfigurationProperties.getBaseUrl() + testConfigurationProperties.getTransazioni();
		
		String accountId = args[1];
		
		transazioneUrl = MessageFormat.format(transazioneUrl, accountId);

		String dataIni = "fromAccountingDate=" +  args[2] ; // 2019-01-01
		String dataFin = "toAccountingDate=" + args[3] ; //2019-12-01
		
		transazioneUrl +=  "?"+ dataIni+ "&" + dataFin;
		log.info("transazioneUrl: "+ transazioneUrl);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", testConfigurationProperties.getAuthSchema());
		headers.set("Api-Key", testConfigurationProperties.getKey());
		
		

		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		try {
			ResponseEntity<ListaTransazioniBean> response = restTemplate.exchange(transazioneUrl, HttpMethod.GET, entity, ListaTransazioniBean.class);
			
			if(response.getStatusCode().equals(HttpStatus.OK)) {
				TransazioneBean[] transazioneArray = response.getBody().getPayload().getList();
				log.info("Lista transazioni trovate: ");
				for(TransazioneBean transazione:transazioneArray) {
					log.info(transazione.toString());
				}
			}
			else {
				log.error("Nessuna transazione trovata per il conto "+ accountId);
			}
		}
		catch(Exception e) {
			log.error("Errore nella chiamata al servizio transazioni per il conto "+ accountId);
		}
		
	}
	
	public void leggiSaldo(String[] args) {
		String saldoUrl = testConfigurationProperties.getBaseUrl() + testConfigurationProperties.getLetturaSaldo();
		
		String accountId = args[1];
		
		saldoUrl = MessageFormat.format(saldoUrl, accountId);
		
		log.info("saldoUrl: "+ saldoUrl);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", testConfigurationProperties.getAuthSchema());
		headers.set("Api-Key", testConfigurationProperties.getKey());
		
		

		HttpEntity<String> entity = new HttpEntity<>("body", headers);

		try {
			ResponseEntity<ListaSaldoBean> response = restTemplate.exchange(saldoUrl, HttpMethod.GET, entity, ListaSaldoBean.class);
			
			if(response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("In data " + response.getBody().getPayload().getDate() +" il saldo per il conto " + response.getBody().getPayload().getDate()+
						" e': " + response.getBody().getPayload().getAvailableBalance() + " "+ response.getBody().getPayload().getCurrency());
			}
			else {
				log.error("Nessun Saldo trovato per il conto "+ accountId);
			}
		}
		catch(Exception e) {
			log.error("Errore nella chiamata al servizio saldo per il conto "+ accountId);
		}
		
	}
	
	public void inserisciBonifico(String[] args) {
		String bonificoUrl = testConfigurationProperties.getBaseUrl() + testConfigurationProperties.getBonifico();
		
		String accountId = args[1];		
		bonificoUrl = MessageFormat.format(bonificoUrl, accountId);
		
		String receiver =  args[2];
		String description =  args[3];
		String currency =  args[4];
		String amount =  args[5];
		String executionDate =  args[6];
		
		log.info("bonificoUrl: "+ bonificoUrl);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", testConfigurationProperties.getAuthSchema());
		headers.set("Api-Key", testConfigurationProperties.getKey());
		headers.set("X-Time-Zone", "Europe/Rome");
		
		

		
		BonificoBean bonifico = new BonificoBean();
		bonifico.getCreditor().getAccount().setAccountCode("IT23A0336844430152923804660");
		bonifico.getCreditor().setName(receiver);
		bonifico.setExecutionDate(executionDate);
		
		
		bonifico.setAmount(amount);
		bonifico.setCurrency(currency);
		bonifico.setDescription(description);
		bonifico.setFeeAccountId(accountId);//"45685475"
		
		HttpEntity<BonificoBean> entity = new HttpEntity<>(bonifico, headers);
		
		log.info("bonificoBean " + bonifico.toString());

		try {
	    	ResponseEntity<String> response = restTemplate.postForEntity(bonificoUrl, entity, String.class);
			if(response.getStatusCode().equals(HttpStatus.OK)) {
				log.info(response.toString());
			}
		}
		catch(Exception e) {
			log.error("Errore in chiamata ");
			e.printStackTrace();
		}
		
	}

}
