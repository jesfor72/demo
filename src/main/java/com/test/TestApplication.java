package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(ManageRequest.class);
	
	private static String SALDO = "SALDO";
	private static String LISTA_TRANSAZIONI = "LISTA";
	private static String BONIFICO = "BONIFICO";
	
	@Autowired
	private ManageRequest req;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	
	@Override
    public void run(String... args) {
		String tipoOp = args[0];
		if(tipoOp.equals(SALDO) ) {
			if(args.length != 2) {
				log.error("Richiesto 1  parametro: accountId");
				System.exit(-1);
			}
			req.leggiSaldo(args);
			
		}
		else if (tipoOp.equals(LISTA_TRANSAZIONI)) {
			if(args.length != 4) {
				log.error("Richiesti 3 parametri: accountId, data da, data a");
				System.exit(-1);
			}
			req.leggiTransazioni(args);
		}
		else if (tipoOp.equals(BONIFICO)) {
			if(args.length != 7) {
				log.error("Richiesti 6 parametri: accountId, receiver, description, currency, amount, executiondate");
				System.exit(-1);
			}
			req.inserisciBonifico(args);
		}
    }	
}
