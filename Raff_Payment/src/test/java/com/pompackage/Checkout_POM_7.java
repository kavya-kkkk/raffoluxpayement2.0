package com.pompackage;

import com.microsoft.playwright.Page;

public class Checkout_POM_7 {
	private Page page;
	 // Store locators as strings
    private String confirmationMessageTextLocator = "You will shortly receive an";
    private String continueButtonLocator = "Continue";
    public Checkout_POM_7(Page page) {
    	this.page=page;
    }
    // Getter methods to return locators
    public String getConfirmationMessageTextLocator() {
        return confirmationMessageTextLocator;
    }

    public String getContinueButtonLocator() {
        return continueButtonLocator;
    }
}
