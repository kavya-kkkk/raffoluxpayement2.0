package com.stepdefinition;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.raffolux.redev.datadriven.ConfigReader;

import static com.stepdefinition.Base_Test.*;

public class Login{
	public static String email = ConfigReader.getProperty("useremail");
	
	 public static String password = ConfigReader.getProperty("password");
	
	public static void uerLogin() throws InterruptedException {	
		System.out.println(email);
		Thread.sleep(2000);
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
	    Thread.sleep(5000);
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("your email")).fill(ConfigReader.getProperty("useremail"));//divya3@gmail.com
	    page.getByPlaceholder("password", new Page.GetByPlaceholderOptions().setExact(true)).fill(password);//123456
	    page.locator("#logIn-view").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Sign in")).click();
	}
}