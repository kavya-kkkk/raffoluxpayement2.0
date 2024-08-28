package com.pompackage;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator; 

public class Checkout_POM_3 {

	 private Page page;

	    // XPath or CSS Selectors
	    private String dropdownButtonXPath = "#dropdownMenuButton1Log";
	    private String dropdownListXPath = "//ul[@id='dropDownMenuListLog']/li[normalize-space() ='%s']";
	    private String totalPriceXPath = "//button[@class='btn addBtn']/span/following-sibling::span";
	    private String addButtonXPath = "//button[@class='btn addBtn']";
	    private String successHeadingRole = "Success!";
	    private String addCartWithLoginXPath = "#addCartwithlogin";
	    private String viewCartButtonRole = "View cart";

	    public Checkout_POM_3(Page page) {
	        this.page = page;
	    }

	    public void clickDropdownButton() {
	        page.locator(dropdownButtonXPath).click();
	    }

	    public void selectDropdownOption(String option) {
	        page.locator(String.format(dropdownListXPath, option)).click();
	    }

	    public String getTotalPrice() {
	        return page.locator(totalPriceXPath).textContent();
	    }

	    public void clickAddButton() {
	        page.locator(addButtonXPath).click();
	    }
	    public boolean isSuccessMessageVisible() {
	        // Use a simple locator if getByRole doesn't work
	         boolean successHeading = page.locator("h1", new Page.LocatorOptions().setHasText(successHeadingRole)).isVisible();
	         return successHeading;
	         
	     //return page.locator("h1", new Locator.LocatorOptions().setHasText(successHeadingRole)).isVisible(); Original code
        
	    }

	    public boolean isAddedToCartMessageVisible(String entries, String raffleTitle) {
	        return page.locator(addCartWithLoginXPath)
	                .textContent().contains(entries + " entries for the " + raffleTitle + " have been added to your cart.");
	    }

	    public void clickViewCartButton() {
	        // Use a simple button locator if getByRole doesn't work
	        page.locator("button:has-text('" + viewCartButtonRole + "')").click();
	    }
//	    public boolean isSuccessMessageVisible() {
//	        return page.getByRole("heading", new Page.GetByRoleOptions().setName(successHeadingRole)).isVisible();
//	    }
//
//	    public boolean isAddedToCartMessageVisible(String entries, String raffleTitle) {
//	        return page.locator(addCartWithLoginXPath)
//	                .containsText(entries + " entries for the " + raffleTitle + " have been added to your cart.");
//	    }
//
//	    public void clickViewCartButton() {
//	        page.getByRole("button", new Page.GetByRoleOptions().setName(viewCartButtonRole)).click();
//	    }
	
}
