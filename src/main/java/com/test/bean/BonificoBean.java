package com.test.bean;

import java.io.Serializable;

public class BonificoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7668103334292231267L;
	private Creditor creditor;
	private String executionDate;
	private String uri;
	private String description;
	private String amount;
	private String currency;
	private Boolean isUrgent;
	private Boolean isInstant;
	private String feeType;
	private String feeAccountId;

	private TaxRelief taxRelief;
	

	public BonificoBean() {
		creditor = new Creditor();
		creditor.setName("Creditor name");
		
		Account accCred = new Account();
		accCred.setBicCode("SELBIT2BXXX");
		accCred.setAccountCode("IT23A0336844430152923804660");
		
		creditor.setAccount(accCred);
		
		Address addressCred = new Address();
		addressCred.setAddress("Via Roma 42");
		addressCred.setCity("Milano");
		addressCred.setCountryCode("IT");
		creditor.setAddress(addressCred);
		uri="REMITTANCE_INFORMATION";
		
		isUrgent = Boolean.FALSE;
		isInstant = Boolean.FALSE;
		feeType = "SHA";
		
		taxRelief = new TaxRelief();
		taxRelief.setTaxReliefId("L449");
		taxRelief.setBeneficiaryType("NATURAL_PERSON");
		taxRelief.setIsCondoUpgrade(false);
		taxRelief.setCreditorFiscalCode("56258745832");
		
		NaturalPersonBeneficiary nat = new NaturalPersonBeneficiary();
		nat.setFiscalCode1("MRLFNC81L04A859L");
		
		taxRelief.setNaturalPersonBeneficiary(nat);
		LegalPersonBeneficiary leg = new LegalPersonBeneficiary();
		taxRelief.setLegalPersonBeneficiary(leg);
	}
	
	/*
	 * {
  "moneyTransferId": "452516859427",
  "status": "EXECUTED",
  "direction": "OUTGOING",
  "creditor": {
    "name": "John Doe",
    "account": {
      "accountCode": "IT23A0336844430152923804660",
      "bicCode": "SELBIT2BXXX"
    },
    "address": {
      "address": null,
      "city": null,
      "countryCode": null
    }
  },
  "debtor": {
    "name": "",
    "account": {
      "accountCode": "IT61F0326802230280596327270",
      "bicCode": null
    }
  },
  "cro": "1234566788907",
  "uri": "REMITTANCE_INFORMATION",
  "trn": "AJFSAD1234566788907CCSFDGTGVGV",
  "description": "Description",
  "createdDatetime": "2019-04-10T10:38:55.949+0200",
  "accountedDatetime": "2019-04-10T10:38:56.000+0200",
  "debtorValueDate": "2019-04-10",
  "creditorValueDate": "2019-04-10",
  "amount": {
    "debtorAmount": 800,
    "debtorCurrency": "EUR",
    "creditorAmount": 800,
    "creditorCurrency": "EUR",
    "creditorCurrencyDate": "2019-04-10",
    "exchangeRate": 1
  },
  "isUrgent": false,
  "isInstant": false,
  "feeType": "SHA",
  "feeAccountId": "12345678",
  "fees": [
    {
      "feeCode": "MK001",
      "description": "Money transfer execution fee",
      "amount": 0.25,
      "currency": "EUR"
    },
    {
      "feeCode": "MK003",
      "description": "Currency exchange fee",
      "amount": 3.5,
      "currency": "EUR"
    }
  ],
  "hasTaxRelief": true
}
	 */

	public class Creditor{
		private String name;
		private Account account;
		private Address address;
		
		public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "Creditor [name=" + name + ", account=" + account + ", address=" + address + "]";
		}
		
	}

	public class Account{
		private String accountCode;
		private String bicCode;
		
		public String getBicCode() {
			return bicCode;
		}
		public void setBicCode(String bicCode) {
			this.bicCode = bicCode;
		}
		public String getAccountCode() {
			return accountCode;
		}
		public void setAccountCode(String accountCode) {
			this.accountCode = accountCode;
		}
		@Override
		public String toString() {
			return "Account [accountCode=" + accountCode + ", bicCode=" + bicCode + "]";
		}
	}

	public class Address {
		private String address;
		private String city;
		private String countryCode;
		
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountryCode() {
			return countryCode;
		}
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}
		@Override
		public String toString() {
			return "Address [address=" + address + ", city=" + city + ", countryCode=" + countryCode + "]";
		}
		
	}
	
	public class TaxRelief{
		private String taxReliefId;
		private Boolean isCondoUpgrade;
		private String creditorFiscalCode;
		private String beneficiaryType;
		private NaturalPersonBeneficiary naturalPersonBeneficiary;
		private LegalPersonBeneficiary legalPersonBeneficiary;
		
		public String getTaxReliefId() {
			return taxReliefId;
		}
		public void setTaxReliefId(String taxReliefId) {
			this.taxReliefId = taxReliefId;
		}
		public Boolean getIsCondoUpgrade() {
			return isCondoUpgrade;
		}
		public void setIsCondoUpgrade(Boolean isCondoUpgrade) {
			this.isCondoUpgrade = isCondoUpgrade;
		}
		public String getCreditorFiscalCode() {
			return creditorFiscalCode;
		}
		public void setCreditorFiscalCode(String creditorFiscalCode) {
			this.creditorFiscalCode = creditorFiscalCode;
		}
		public String getBeneficiaryType() {
			return beneficiaryType;
		}
		public void setBeneficiaryType(String beneficiaryType) {
			this.beneficiaryType = beneficiaryType;
		}
		public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
			return naturalPersonBeneficiary;
		}
		public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
			this.naturalPersonBeneficiary = naturalPersonBeneficiary;
		}
		public LegalPersonBeneficiary getLegalPersonBeneficiary() {
			return legalPersonBeneficiary;
		}
		public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
			this.legalPersonBeneficiary = legalPersonBeneficiary;
		}
		@Override
		public String toString() {
			return "TaxRelief [taxReliefId=" + taxReliefId + ", isCondoUpgrade=" + isCondoUpgrade
					+ ", creditorFiscalCode=" + creditorFiscalCode + ", beneficiaryType=" + beneficiaryType
					+ ", naturalPersonBeneficiary=" + naturalPersonBeneficiary + ", legalPersonBeneficiary="
					+ legalPersonBeneficiary + "]";
		}
		
		
	}
	
	private class NaturalPersonBeneficiary{
		private String fiscalCode1;
		private String fiscalCode2;
		private String fiscalCode3;
		private String fiscalCode4;
		private String fiscalCode5;
		
		public String getFiscalCode1() {
			return fiscalCode1;
		}
		public void setFiscalCode1(String fiscalCode1) {
			this.fiscalCode1 = fiscalCode1;
		}
		public String getFiscalCode2() {
			return fiscalCode2;
		}
		public void setFiscalCode2(String fiscalCode2) {
			this.fiscalCode2 = fiscalCode2;
		}
		public String getFiscalCode3() {
			return fiscalCode3;
		}
		public void setFiscalCode3(String fiscalCode3) {
			this.fiscalCode3 = fiscalCode3;
		}
		public String getFiscalCode4() {
			return fiscalCode4;
		}
		public void setFiscalCode4(String fiscalCode4) {
			this.fiscalCode4 = fiscalCode4;
		}
		public String getFiscalCode5() {
			return fiscalCode5;
		}
		public void setFiscalCode5(String fiscalCode5) {
			this.fiscalCode5 = fiscalCode5;
		}
		@Override
		public String toString() {
			return "NaturalPersonBeneficiary [fiscalCode1=" + fiscalCode1 + ", fiscalCode2=" + fiscalCode2
					+ ", fiscalCode3=" + fiscalCode3 + ", fiscalCode4=" + fiscalCode4 + ", fiscalCode5=" + fiscalCode5
					+ "]";
		}
		
	}
	
	public class LegalPersonBeneficiary{
		private String fiscalCode;
		private String legalRepresentativeFiscalCode;
		
		public String getFiscalCode() {
			return fiscalCode;
		}
		public void setFiscalCode(String fiscalCode) {
			this.fiscalCode = fiscalCode;
		}
		public String getLegalRepresentativeFiscalCode() {
			return legalRepresentativeFiscalCode;
		}
		public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
			this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
		}
		@Override
		public String toString() {
			return "LegalPersonBeneficiary [fiscalCode=" + fiscalCode + ", legalRepresentativeFiscalCode="
					+ legalRepresentativeFiscalCode + "]";
		}
	}


	public Creditor getCreditor() {
		return creditor;
	}

	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}

	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Boolean getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(Boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public Boolean getIsInstant() {
		return isInstant;
	}

	public void setIsInstant(Boolean isInstant) {
		this.isInstant = isInstant;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getFeeAccountId() {
		return feeAccountId;
	}

	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}

	public TaxRelief getTaxRelief() {
		return taxRelief;
	}

	public void setTaxRelief(TaxRelief taxRelief) {
		this.taxRelief = taxRelief;
	}

	@Override
	public String toString() {
		return "BonificoBean [creditor=" + creditor + ", executionDate=" + executionDate + ", uri=" + uri
				+ ", description=" + description + ", amount=" + amount + ", currency=" + currency + ", isUrgent="
				+ isUrgent + ", isInstant=" + isInstant + ", feeType=" + feeType + ", feeAccountId=" + feeAccountId
				+ ", taxRelief=" + taxRelief + "]";
	}

}
