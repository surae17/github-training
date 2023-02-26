package org.junitTesting;

import java.util.Date;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SampleProject extends Baseclass {
	@Test
	public void tc3() {
	System.out.println("Test case 3");

	}
	@Before
	public void startDate() {
		Date d = new Date();
		System.out.println(d);
	
	}
	@After
	public void endDate() {
	//closeEntireBrowser();
	}
	@BeforeClass
	public static void LaunchTheBrowser() {
		LaunchBrowser();
		WindowMaximize();
	}
	
	@AfterClass
	public static void CloseTheBrowser() {
		
	}
	@Test
	public void tc1() {
		System.out.println("Test case 1");
		LaunchUrl("https://mail.google.com/mail/u/0/#inbox");
	}

	
	@Test
	public void tc5() {
		System.out.println("Test case 5");
		LaunchUrl("https://www.facebook.com/");
		String title = pageTitle();
		String url  = pageUrl();
		FbLoginPojo f = new  FbLoginPojo();
		passText("seleniuminmakes@gmail.com", f.getEmail());
		Assert.assertEquals("check your url", "url",url.contains("facebook"));
		passText("samuel", f.getPassword());
	}
	
		
	@Test
	public void tc2() {
		System.out.println("Test case 2");
		LaunchUrl("https://inmakes.com/");
	}
	@Test
	public void tc4() {
		System.out.println("Test case 4");
		LaunchUrl("https://www.youtube.com/");
	}

}
