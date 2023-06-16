package com.test.bean;

import java.io.Serializable;

public class ListaSaldoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] error;
	private String status;
	private SaldoBean payload;
	
	public String[] getError() {
		return error;
	}
	public void setError(String[] error) {
		this.error = error;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SaldoBean getPayload() {
		return payload;
	}
	public void setPayload(SaldoBean payload) {
		this.payload = payload;
	}
	@Override
	public String toString() {
		return "ListaSaldoBean [error=" + error + ", status=" + status + ", payload=" + payload + "]";
	}


}
