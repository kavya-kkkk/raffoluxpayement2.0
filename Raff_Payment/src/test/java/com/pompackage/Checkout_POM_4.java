package com.pompackage;

import com.microsoft.playwright.Page;

public class Checkout_POM_4 {
	private Page page;
	
	  // Store locators as strings
    private String totalCostLocator = "//p[@class=\"cost total-text mb-0\"]";
    private String pointsForPurchaseLocator = "//*[@id=\"app\"]/div/div/main/div/div[2]/div/div[2]/div[4]/div[1]/p";
    private String pointsLocator = "//span[@class=\"points\"]";
    private String beforePurchasingPointsLocator = "//p[contains(text(), 'RP')]";

  public Checkout_POM_4(Page page){
    	this.page=page;
    }
    // Getter methods to return locators
    public String getTotalCostLocator() {
        return totalCostLocator;
    }

    public String getPointsForPurchaseLocator() {
        return pointsForPurchaseLocator;
    }

    public String getPointsLocator() {
        return pointsLocator;
    }

    public String getBeforePurchasingPointsLocator() {
        return beforePurchasingPointsLocator;
    }	
	
}
