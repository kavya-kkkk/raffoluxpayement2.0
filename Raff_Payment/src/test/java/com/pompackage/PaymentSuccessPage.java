package com.pompackage;

import static com.stepdefinition.Base_Test.page;


import com.microsoft.playwright.Page;

public class PaymentSuccessPage {
	private Page page;
	  // Store locators as strings
    private String confirmationMessageLocator = "You will shortly receive an";
    private String continueButtonRoleLocator = "Continue";
    
    private String confirmationMessageTextLocator = "You will shortly receive an";
    private String continueButtonLocator = "Continue";
    
public PaymentSuccessPage(Page page) {
	this.page=page;
}
    // Getter methods to return locators
    public String getConfirmationMessageLocator() {
        return confirmationMessageLocator;
    }

    public String getContinueButtonRoleLocator() {
        return continueButtonRoleLocator;
    }
    
    
    // Getter methods to return locators
    public String getConfirmationMessageTextLocator() {
        return confirmationMessageTextLocator;
    }

    public String getContinueButtonLocator() {
        return continueButtonLocator;
    }
}
