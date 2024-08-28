package com.stepdefinition;
import com.microsoft.playwright.Page;
import com.raffolux.redev.datadriven.ConfigReader;
import com.raffolux.playwright.PlaywrightFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Base_Test {
	public static Page page;
	String browser = ConfigReader.getProperty("browser");
	String redevURL = ConfigReader.getProperty("redevURL");


	@Before
	public void setUp() {

		page = PlaywrightFactory.initBrowser(browser);
		page.navigate(redevURL);
	}

	@After
	public void tearDown() {

		//PlaywrightFactory.closeBrowser(page);
		
		page.close();
		
	}
}
