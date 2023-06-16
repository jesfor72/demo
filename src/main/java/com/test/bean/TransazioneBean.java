package com.test.bean;

import java.io.Serializable;

public class TransazioneBean  implements Serializable{
	
/*    "transactionId": "282831",
    "operationId": "00000000282831",
    "accountingDate": "2019-11-29",
    "valueDate": "2019-12-01",
    "type": {
        "enumeration": "GBS_TRANSACTION_TYPE",
        "value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
    },
    "amount": -343.77,
    "currency": "EUR",
    "description": "PD VISA CORPORATE 10"
*/
	
	private String transactionId;
	private String operationId;
	private String accountingDate;
	private String valueDate;
	private String amount;
	private String currency;
	private String description;
	private Type type;
	
	
	public class Type{
		private String enumeration;
		private String value;
		
		public String getEnumeration() {
			return enumeration;
		}
		public void setEnumeration(String enumeration) {
			this.enumeration = enumeration;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return "Type [enumeration=" + enumeration + ", value=" + value + "]";
		}
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getOperationId() {
		return operationId;
	}


	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}


	public String getAccountingDate() {
		return accountingDate;
	}


	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}


	public String getValueDate() {
		return valueDate;
	}


	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type alias) {
		this.type = alias;
	}


	@Override
	public String toString() {
		return "TransazioneBean [transactionId=" + transactionId + ", operationId=" + operationId + ", accountingDate="
				+ accountingDate + ", valueDate=" + valueDate + ", amount=" + amount + ", currency=" + currency
				+ ", description=" + description + ", type=" + type + "]";
	}
}
