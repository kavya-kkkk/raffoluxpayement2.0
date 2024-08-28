package com.pompackage;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat; 

public class Checkout_POM_2 {
	 private Page page;

	    // XPath selectors
	    private String homePageRaffleTitleXPath = "//div[contains(@class,'homeSFColWidth')]/descendant::h1";
	    private String homePageRafflePriceXPath = "//h1[.='%s']/following-sibling::div/p";
	    private String homePageRaffleButtonXPath = "//h1[text()='%s']/following-sibling::button";
	    private String allCompetitionsLinkXPath = "div[contains(text(), 'All competitionsWinnersMy tickets')]//a";
	    private String featuredCompetitionsHeadingXPath = "//div[@class=\"cardBg-img\"]/descendant::h1";
	    private String featuredCompetitionsPriceXPath = "//div[@class=\"cardBg-img\"]//h3";
	    private String rafflePageRaffleTitleXPath = "//div[@class='detailsCardStylings mb-detailsCard']/h4";
	    private String rafflePageRafflePriceXPath = "//div[@class=\"raffle-launch-price-text d-flex justify-content-center\"] | //div[@class=\"cardPrice mb-cardPriceText\"]";

	    // Constructor
	    public Checkout_POM_2(Page page) {
	        this.page = page;
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

	    public String getRafflePageRaffleTitle() {
	        return page.locator(rafflePageRaffleTitleXPath).textContent();
	    }

	    public String getRafflePageRafflePrice() {
	        return page.locator(rafflePageRafflePriceXPath).textContent();
	    }

	    public void assertRaffleEndedIsVisible() {
	        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("RAFFLE ENDED"))).isVisible();
	    }

	    public void assertFeaturedCompetitionsIsVisible() {
	        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("FEATURED COMPETITIONS"))).isVisible();
	    }
}
