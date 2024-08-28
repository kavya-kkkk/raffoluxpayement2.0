package com.pompackage;

import static com.stepdefinition.Base_Test.page;

import com.microsoft.playwright.Page;

public class Checkout_POM_6 {
	private Page page;
	  // Store locators as strings
    private String confirmationMessageLocator = "You will shortly receive an";
    private String continueButtonRoleLocator = "Continue";
public Checkout_POM_6(Page page) {
	this.page=page;
}
    // Getter methods to return locators
    public String getConfirmationMessageLocator() {
        return confirmationMessageLocator;
    }

    public String getContinueButtonRoleLocator() {
        return continueButtonRoleLocator;
    }
}
