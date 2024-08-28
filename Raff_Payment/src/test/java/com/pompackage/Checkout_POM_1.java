package com.pompackage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Checkout_POM_1 {
	 private Page page;

	    public Checkout_POM_1(Page page) {
	        this.page = page;
	    }

	    private String rpTextXPath = "//p[contains(text(), 'RP')]";
	    private String profileImageXPath = "(//IMG[@aria-controls='offcanvasRight'])[1]";
	    private String myCreditHeadingXPath = "//h3[text()='My Credit']";
	    private String creditBalanceXPath = "//h3[@class=\'creditBalance mb-balanceMargin\']";
	    private String competitionsLinkXPath = "div[contains(text(), 'All competitionsWinnersMy tickets')]//a";

	    public Locator getRpTextLocator() {
	        return page.locator(rpTextXPath);
	    }

	    public Locator getProfileImageLocator() {
	        return page.locator(profileImageXPath);
	    }

	    public Locator getMyCreditHeadingLocator() {
	        return page.locator(myCreditHeadingXPath);
	    }

	    public Locator getCreditBalanceLocator() {
	        return page.locator(creditBalanceXPath);
	    }

	    public Locator getCompetitionsLinkLocator() {
	        return page.locator(competitionsLinkXPath).first();
	    }

	    public String getBeforePurchasingPoints() {
	        return getRpTextLocator().textContent();
	    }

	    public void clickProfileImage() {
	        getProfileImageLocator().click();
	    }

	    public void clickMyCreditHeading() {
	        getMyCreditHeadingLocator().click();
	    }

	    public String getBeforeUsingCreditValue() {
	        return getCreditBalanceLocator().textContent();
	    }

	    public void clickFirstCompetitionLink() {
	        getCompetitionsLinkLocator().click();
	    }
}
