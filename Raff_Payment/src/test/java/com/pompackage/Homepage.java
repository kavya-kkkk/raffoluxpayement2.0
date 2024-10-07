package com.pompackage;

import com.microsoft.playwright.Locator;

import com.microsoft.playwright.Page;

public class Homepage {
	 private Page page;

	    public Homepage(Page page) {
	        this.page = page;
	    }
	    private String homePageRaffleTitleXPath = "//div[contains(@class,'homeSFColWidth')]/descendant::h1";
	    private String homePageRafflePriceXPath = "//h1[.='%s']/following-sibling::div/p";
	    private String homePageRaffleButtonXPath = "//h1[text()='%s']/following-sibling::button";
	    private String allCompetitionsLinkXPath = "//a[@class=\"allCompetitionsMargin\"]//h5";
	    private String featuredCompetitionsHeadingXPath = "//div[@class=\"cardBg-img\"]/descendant::h1";
	    private String featuredCompetitionsPriceXPath = "//div[@class=\"cardBg-img\"]//h3";
	    private String rpTextXPath = "//p[contains(text(), 'RP')]";
	    private String profileImageXPath = "(//IMG[@aria-controls='offcanvasRight'])[1]";
	    private String myCreditHeadingXPath = "//h3[text()='My Credit']";
	    private String creditBalanceXPath = "//h3[@class=\'creditBalance mb-balanceMargin\']";
	    private String competitionsLinkXPath = "//img[@class=\"logo-img\"]";

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

	    // Methods to interact with the page
	    public String getHomePageRaffleTitle() {
	        return page.locator(homePageRaffleTitleXPath).first().textContent();
	    }

	    public String getHomePageRafflePrice(String raffleTitle) {
	        return page.locator(String.format(homePageRafflePriceXPath, raffleTitle)).first().textContent();
	    }

	    public void clickHomePageRaffleButton(String raffleTitle) {
	        page.locator(String.format(homePageRaffleButtonXPath, raffleTitle)).first().click();
	    }

	    public void clickAllCompetitionsLink() {
	        page.locator(allCompetitionsLinkXPath).first().click();
	    }

	    public String getFeaturedCompetitionsTitle() {
	        return page.locator(featuredCompetitionsHeadingXPath).last().textContent();
	    }

	    public String getFeaturedCompetitionsPrice() {
	        return page.locator(featuredCompetitionsPriceXPath).last().textContent();
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
