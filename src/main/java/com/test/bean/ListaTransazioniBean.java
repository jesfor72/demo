package com.test.bean;

import java.io.Serializable;

public class ListaTransazioniBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] error;
	private String status;
	private Payload payload;
	
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
	public Payload getPayload() {
		return payload;
	}
	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	@Override
	public String toString() {
		return "ListaTransazioniBean [error=" + error + ", status=" + status + ", payload=" + payload + "]";
	}
	
	public class Payload implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private TransazioneBean[] list;

		public TransazioneBean[] getList() {
			return list;
		}

		public void setList(TransazioneBean[] list) {
			this.list = list;
		}
		
		@Override
		public String toString() {
			return "Payload [error=" + error + ", status=" + status + ", payload=" + payload + "]";
		}
		
	}

}
