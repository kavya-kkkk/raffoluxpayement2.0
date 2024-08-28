package com.pompackage;

import com.microsoft.playwright.Page;

public class Checkout_POM_5 {

	private Page page;
	// Store locators as strings
    private String cardholderNameFrameLocator = "//iframe[@id='dna-payments-hosted-field-cardholderName']";
    private String cardholderNameInputLocator = "//input[@name='dna-payments-hosted-field-cardholder-name']";
    private String cardNumberFrameLocator = "//iframe[@id='dna-payments-hosted-field-cardNumber']";
    private String cardNumberInputLocator = "//input[@name='dna-payments-hosted-field-credit-card-number']";
    private String expirationDateFrameLocator = "//iframe[@id='dna-payments-hosted-field-expirationDate']";
    private String expirationDateInputLocator = "//input[@name='dna-payments-hosted-field-expiration']";
    private String cvvFrameLocator = "iframe[name='dna-payments-hosted-field-cvv']";
    private String cvvInputPlaceholder = "CVV";
    private String otpFrameLocator = "iframe[name='dna-payments-output_frame']";
    private String otpInputPlaceholder = "one-time password:";
    private String submitButtonRole = "BUTTON";
    private String submitButtonName = "Send";

    public Checkout_POM_5(Page page) {
    	this.page=page;
    }
    // Getter methods to return locators
    public String getCardholderNameFrameLocator() {
        return cardholderNameFrameLocator;
    }

    public String getCardholderNameInputLocator() {
        return cardholderNameInputLocator;
    }

    public String getCardNumberFrameLocator() {
        return cardNumberFrameLocator;
    }

    public String getCardNumberInputLocator() {
        return cardNumberInputLocator;
    }

    public String getExpirationDateFrameLocator() {
        return expirationDateFrameLocator;
    }

    public String getExpirationDateInputLocator() {
        return expirationDateInputLocator;
    }

    public String getCvvFrameLocator() {
        return cvvFrameLocator;
    }

    public String getCvvInputPlaceholder() {
        return cvvInputPlaceholder;
    }

    public String getOtpFrameLocator() {
        return otpFrameLocator;
    }

    public String getOtpInputPlaceholder() {
        return otpInputPlaceholder;
    }

    public String getSubmitButtonRole() {
        return submitButtonRole;
    }

    public String getSubmitButtonName() {
        return submitButtonName;
    }

}
