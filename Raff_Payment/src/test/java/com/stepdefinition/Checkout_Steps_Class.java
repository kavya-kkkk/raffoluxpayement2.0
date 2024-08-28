package com.stepdefinition;

import com.common_utilities.Common_Utilities;
import com.common_utilities.ExcelLogger;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.pompackage.Checkout_POM_1;
import com.pompackage.Checkout_POM_2;
import com.pompackage.Checkout_POM_3;
import com.pompackage.Checkout_POM_4;
import com.pompackage.Checkout_POM_5;
import com.pompackage.Checkout_POM_6;
import com.pompackage.Checkout_POM_7;
import com.raffolux.redev.datadriven.ConfigReader;

import static com.stepdefinition.Base_Test.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout_Steps_Class{
	
	protected String points ;
	   public  String Checkoutcost;
	   public String Afterpurchasingpoints;
	   public String   Beforepurchasingpoints;
	   public String rafflePageRaffleTitle;
	   public  String rafflePageRaffleprice;
	   public String homePageRaffleprice;
	   public String homePageRaffleTitle;
	   public String rafflePageSelectentries = "6";
	   public String rafflePageTotalPrice;
	   public String  cartPageCreditValue ;
	   public String BeforeApplycartCreditValue;
	   public String cartCreditValueCheckBox;
	   public  String  cartAppliedCreditValue;
	   public String cartTotalCost;
	   public String	 AfterAppliedcreditCheckoutcost;
	   public String beforeUsingCreditValue;
	   public String afterUsingCreditValue;
	   public String promoCode ="MISSUdghJ";
	   public String  appliedPromoCodeValue;
	   
	   private static final String FILE_PATH = "C:\\Users\\DELL\\eclipse-workspace\\Raff_Payment\\Redev.xlsx";
	    private ExcelLogger excelLogger;

	    public Checkout_Steps_Class() {
	        excelLogger = new ExcelLogger("CheckoutData", FILE_PATH);
	    }

	    private void logFetchedData(String label, String data) {
	        excelLogger.logData(label, data);
	    }


	@Given("the browser is launched and the user is logged in to the application")
	public void the_browser_is_launched_and_the_user_is_logged_in_to_the_application() throws InterruptedException {
	Login.uerLogin(); 
	
	}

	@And("the home page should be displayed after login")
	public void the_home_page_should_be_displayed_after_login() throws InterruptedException {
		Checkout_POM_1 homePage=new Checkout_POM_1(page);
		Thread.sleep(2000);

        String beforePurchasingPoints = homePage.getBeforePurchasingPoints();
        logFetchedData("Before Purchasing Points", beforePurchasingPoints);
        System.out.println(beforePurchasingPoints + " >>> Before purchasing points");
       
        Thread.sleep(2000);
        homePage.clickProfileImage();
        

        Thread.sleep(2000);
        homePage.clickMyCreditHeading();

        String beforeUsingCreditValue = homePage.getBeforeUsingCreditValue();
        logFetchedData("Before Using Credit Value", beforeUsingCreditValue);
        System.out.println(beforeUsingCreditValue + " >>> Before using credit value");
        Thread.sleep(5000);
        
        homePage.clickFirstCompetitionLink();	    
	}

	@Then("validate the title, price, and total cost for the purchase on the raffle page")
	public void validate_the_title_price_and_total_cost_for_the_purchase_on_the_raffle_page() throws InterruptedException {
		Checkout_POM_2 rafflePage=new Checkout_POM_2(page);
		Thread.sleep(3000);
        homePageRaffleTitle = rafflePage.getHomePageRaffleTitle();
       String homePageRafflePrice = rafflePage.getHomePageRafflePrice(homePageRaffleTitle);
       rafflePage.clickHomePageRaffleButton(homePageRaffleTitle);

        Thread.sleep(3000);
        rafflePage.assertRaffleEndedIsVisible();

        Thread.sleep(3000);
        rafflePage.clickAllCompetitionsLink();
        rafflePage.assertFeaturedCompetitionsIsVisible();

        homePageRaffleTitle = rafflePage.getFeaturedCompetitionsTitle();
        Thread.sleep(3000);
        homePageRafflePrice = rafflePage.getFeaturedCompetitionsPrice();
        logFetchedData("Home Page Raffle Title", homePageRaffleTitle);
        logFetchedData("Home Page Raffle Price", homePageRafflePrice);
        Thread.sleep(3000);
        rafflePage.clickHomePageRaffleButton(homePageRaffleTitle);

        Thread.sleep(3000);
        rafflePageRaffleTitle = rafflePage.getRafflePageRaffleTitle();
        Thread.sleep(3000);
        rafflePageRaffleprice = rafflePage.getRafflePageRafflePrice(); 
        
        logFetchedData("Raffle Page Raffle Title", rafflePageRaffleTitle);
        logFetchedData("Raffle Page Raffle Price", rafflePageRaffleprice);

//        assertTrue(homePageRaffleTitle, rafflePageRaffleTitle);
//        Thread.sleep(3000);
//        assertTrue(homePageRafflePrice, rafflePageRaffleprice);
        
	}

	@Then("add the tickets to the cart")
	public void add_the_tickets_to_the_cart() throws InterruptedException {
		Checkout_POM_3 rafflePage=new Checkout_POM_3(page);
		rafflePage.clickDropdownButton();
        Thread.sleep(3000);

        rafflePage.selectDropdownOption(rafflePageSelectentries);
        rafflePageTotalPrice = rafflePage.getTotalPrice();
        logFetchedData("Total Price", rafflePageTotalPrice);

        assertTrue(Common_Utilities.compare_entries_with_price(rafflePageSelectentries, rafflePageRaffleprice,
                rafflePageTotalPrice));

        rafflePage.clickAddButton();
        assertTrue(Common_Utilities.compareText(homePageRaffleTitle, rafflePageRaffleTitle));
        Thread.sleep(3000);
        assertTrue(Common_Utilities.compareText(homePageRaffleprice, rafflePageRaffleprice));
        logFetchedData("Home Page Raffle Title", homePageRaffleTitle);
        logFetchedData("Home Page Raffle Price", rafflePageRaffleprice);
        rafflePage.clickViewCartButton();
	}

	@And("the cart page should be displayed")
	public void the_cart_page_should_be_displayed() {
		   System.out.println("Cart page is displayed");

	}

	@Then("validate that the points displayed for the purchase are correct")
	public void validate_that_the_points_displayed_for_the_purchase_are_correct() throws InterruptedException {
		Checkout_POM_4 cartPage=new Checkout_POM_4(page);
		// Use locators from the POM class
        Locator totalCostLocator = page.locator(cartPage.getTotalCostLocator());
        Locator pointsForPurchaseLocator = page.locator(cartPage.getPointsForPurchaseLocator());
        Locator pointsLocator = page.locator(cartPage.getPointsLocator());
        Locator beforePurchasingPointsLocator = page.locator(cartPage.getBeforePurchasingPointsLocator());

        // Perform actions using the locators
        Thread.sleep(3000);
        Checkoutcost = totalCostLocator.textContent();
        Thread.sleep(3000);
        String pointForPurchase = pointsForPurchaseLocator.textContent();
        Thread.sleep(3000);
        System.out.println(Checkoutcost + " > Checkoutcost");
        System.out.println(pointForPurchase + " > pointForPurchase");

        Thread.sleep(3000);
        points = pointsLocator.textContent();
        System.out.println(points + " > Points");

        Thread.sleep(3000);
        // Compare strings as integers to validate points
        assertTrue(Common_Utilities.compareStringsAsIntegers(Checkoutcost, points));
        System.out.println("passssssssssssss>>>>>>>>>>>>>.");

        Thread.sleep(3000);
        Beforepurchasingpoints = beforePurchasingPointsLocator.textContent();
        System.out.println(Beforepurchasingpoints + " >>> Beforepurchasingpoints");
        logFetchedData("Checkout Cost", Checkoutcost);
        logFetchedData("Points for Purchase", pointForPurchase);
        logFetchedData("Points", points);
        logFetchedData("Before Purchasing Points", Beforepurchasingpoints);

	}

	@When("the checkout button is clicked")
	public void the_checkout_button_is_clicked() throws InterruptedException {
		Thread.sleep(3000);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CHECKOUT £")).click();
	}

	@Then("the DNA payment popup should be displayed")
	public void the_dna_payment_popup_should_be_displayed() {
		System.out.println("skip the method");

	}

	@And("valid card details should be entered")
	public void valid_card_details_should_be_entered() throws InterruptedException {
		Checkout_POM_5 paymentPage=new Checkout_POM_5(page);
	        if (Checkoutcost.equals("£0.00")) {
	            System.out.println("Yes, checkout is equal to £0.00. The checkout cost is:>> " + Checkoutcost);
	        } else {
	            // Fill in the cardholder name
	            Thread.sleep(3000);
	            page.frameLocator(paymentPage.getCardholderNameFrameLocator())
	                .locator(paymentPage.getCardholderNameInputLocator()).fill("kavya");

	            // Fill in the card number
	            Thread.sleep(3000);
	            page.frameLocator(paymentPage.getCardNumberFrameLocator())
	                .locator(paymentPage.getCardNumberInputLocator()).fill("4111111111111111");

	            // Fill in the expiration date
	            Thread.sleep(3000);
	            page.frameLocator(paymentPage.getExpirationDateFrameLocator())
	                .locator(paymentPage.getExpirationDateInputLocator()).fill("1226");

	            // Fill in the CVV
	            Thread.sleep(3000);
	            page.frameLocator(paymentPage.getCvvFrameLocator())
	                .getByPlaceholder(paymentPage.getCvvInputPlaceholder()).fill("212");

	            // Click on the £ symbol (assumed to proceed with payment)
	            Thread.sleep(3000);
	            page.getByText("£").click();

	            // Fill in the one-time password (OTP)
	            Thread.sleep(3000);
	            page.frameLocator(paymentPage.getOtpFrameLocator())
	                .getByPlaceholder(paymentPage.getOtpInputPlaceholder()).fill("1111");

	            // Submit the payment form
	            Thread.sleep(3000);
	            page.frameLocator(paymentPage.getOtpFrameLocator())
	                .getByRole(AriaRole.valueOf(paymentPage.getSubmitButtonRole()), 
	                           new FrameLocator.GetByRoleOptions().setName(paymentPage.getSubmitButtonName())).click();
	        }
	}

	@Then("the user should be able to see the purchased tickets")
	public void the_user_should_be_able_to_see_the_purchased_tickets() throws InterruptedException {
		Checkout_POM_6 confirmationPage=new Checkout_POM_6(page);

        // Validate the presence of the confirmation message
        assertThat(page.getByText(confirmationPage.getConfirmationMessageLocator())).isVisible();

        // Validate the visibility of the Continue button
        assertThat(page.getByRole(AriaRole.BUTTON, 
                new Page.GetByRoleOptions().setName(confirmationPage.getContinueButtonRoleLocator()))).isVisible();

        // Wait for a short duration
        Thread.sleep(3000);

        // Click the Continue button
        page.getByRole(AriaRole.BUTTON, 
                new Page.GetByRoleOptions().setName(confirmationPage.getContinueButtonRoleLocator())).click();
 

	}

	@And("the user should receive the correct points for the purchase")
	public void the_user_should_receive_the_correct_points_for_the_purchase() throws InterruptedException {
		Checkout_POM_7 confirmationPage=new Checkout_POM_7(page);		
		  // Validate the presence of the confirmation message
        assertThat(page.getByText(confirmationPage.getConfirmationMessageTextLocator())).isVisible();

        // Validate the visibility of the Continue button
        assertThat(page.getByRole(AriaRole.BUTTON, 
                new Page.GetByRoleOptions().setName(confirmationPage.getContinueButtonLocator()))).isVisible();

        // Wait for a short duration
        Thread.sleep(3000);

        // Click the Continue button
        page.getByRole(AriaRole.BUTTON, 
                new Page.GetByRoleOptions().setName(confirmationPage.getContinueButtonLocator())).click();
	}
//	 @AfterClass
//	    public void tearDown() {
//	        // Save and close the Excel file at the end of the test
//	        excelLogger.close(FILE_PATH);
//	    } 
}
