package com.raffolux.playwright;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.Base64;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

//	static Playwright playwright;
//	static Browser browser;
//	static BrowserContext context;
//	static Page page;
	
	private static ThreadLocal<Browser> browser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> page = new ThreadLocal<>();
	private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();

	public static Playwright getPlaywright() {
		return playwright.get();
	}

	public static Browser getBrowser() {
		return browser.get();
	}

	public static BrowserContext getBrowserContext() {
		return browserContext.get();
	}

	public static Page getPage() {
		return page.get();
	}

	public static Page initBrowser(String browserName) {
		playwright.set(Playwright.create());

		switch (browserName.toLowerCase().trim()) {
		case "chromium":
			browser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;

		case "firefox":
			browser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;

		case "safari":
			browser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;

		case "chrome":
			browser.set(getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;

		case "msedge":
			browser.set(getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("edge").setHeadless(false)));
			break;

		default:
			System.out.println("Please enter the valid Browser name");
			break;
		}
		System.out.println("<< Launched "+ browserName +" Browser >>");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		System.out.println("Width: " + width + " Height: " + height);
		

		browserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(width, height)));
		page.set(getBrowserContext().newPage());
		
		return getPage();

	}

	public static void closeBrowser() {
		
		getBrowserContext().close();
		getPage().close();
		getBrowser().close();
		
		System.out.println("<< Browser Closed >>");
		
	}
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		
		return base64Path;
	}
}
