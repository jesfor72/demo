package com.test.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
public class TestConfigurationProperties {
	private String baseUrl;
	private String letturaSaldo;
	private String bonifico;
	private String transazioni;
	
	private String key;
	private String authSchema;
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getLetturaSaldo() {
		return letturaSaldo;
	}
	public void setLetturaSaldo(String letturaSaldo) {
		this.letturaSaldo = letturaSaldo;
	}
	public String getBonifico() {
		return bonifico;
	}
	public void setBonifico(String bonifico) {
		this.bonifico = bonifico;
	}
	public String getTransazioni() {
		return transazioni;
	}
	public void setTransazioni(String transazioni) {
		this.transazioni = transazioni;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getAuthSchema() {
		return authSchema;
	}
	public void setAuthSchema(String authSchema) {
		this.authSchema = authSchema;
	}


}
