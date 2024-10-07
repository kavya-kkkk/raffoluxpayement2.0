

	import com.microsoft.playwright.*;
	import com.microsoft.playwright.options.*;

import Common.Methods.Common_Utils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.*;
import java.util.regex.Pattern;

	public class Testprizes {
		
		
	  public static void main(String[] args) throws InterruptedException {
		  String rafflePageSelectentries ="25";
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://testing.d21ajyco9f10q5.amplifyapp.com/");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("your email")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("your email")).fill("testprize@gmail.com");
	      page.getByPlaceholder("password", new Page.GetByPlaceholderOptions().setExact(true)).click();
	      page.getByPlaceholder("password", new Page.GetByPlaceholderOptions().setExact(true)).fill("1234567");
	     // page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in").setExact(true)).click();
	     // page.getByPlaceholder("password", new Page.GetByPlaceholderOptions().setExact(true)).click();
	     // page.getByPlaceholder("password", new Page.GetByPlaceholderOptions().setExact(true)).fill("1234567");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in").setExact(true)).click();
	      
	      for(int i=1;i<=10;i++) {
	    	  
	    	  System.out.println("loop>>"+i);
	    	  Thread.sleep(2000);
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ENTER NOW").setExact(true)).nth(1).click();
	      Thread.sleep(2000);
	     // page.getByText("£20,000 Bank Vault Instant Win! £4.9935%02091 tickets sold 5999499 MAX per").click();
	      page.locator("#dropdownMenuButton1Log").click();
			Thread.sleep(3000);

			page.locator("//ul[@id='dropDownMenuListLog']/li[normalize-space() ='" + rafflePageSelectentries + "']")
					.click();
			Thread.sleep(2000);

			//rafflePageTotalPrice = page.locator("//button[@class='btn addBtn']/span/following-sibling::span").textContent();

		//	assertTrue(Common_Utils.compare_entries_with_price(rafflePageSelectentries, rafflePageRaffleprice,
					//rafflePageTotalPrice));

			page.locator("//button[@class='btn addBtn']").click();
			Thread.sleep(3000);
			//assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Success!"))).isVisible();
			//Thread.sleep(3000);
		//	assertThat(page.locator("#addCartwithlogin")).containsText(rafflePageSelectentries + " entries for the "
				//	+ rafflePageRaffleTitle + " have been added to your cart.");

			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View cart")).click();
			Thread.sleep(2000);
	    //  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View cart")).click();
	      page.locator("//div[@class=\"desk-cartContent-hide\"]//i[@class=\"fa-solid fa-xmark cross-mark\"]").click();
	      Thread.sleep(2000);
	      page.navigate("https://testing.d21ajyco9f10q5.amplifyapp.com");
	      Thread.sleep(2000);
	      
	      }
	      
	      System.out.println("loop ended");
	      
	    }
	  }
	}


