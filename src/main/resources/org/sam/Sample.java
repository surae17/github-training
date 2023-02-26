package org.sam;

import org.junitTesting.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sample extends Baseclass {
	public static void main(String[] args) {
		LaunchBrowser();
		LaunchUrl("www.facebook.com");
		WindowMaximize();
	}

}
