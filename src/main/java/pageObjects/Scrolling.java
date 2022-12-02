package pageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scrolling {
	AndroidDriver<AndroidElement>  driver;

	public Scrolling(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}

	
	public void scrollToText(String text)
	{
//	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textContains(\""+text+"\"));");
	     driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));
	}
	
	public void scrollDown()
	{
	  	 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
	}
	
	
	public void scrollUp()
	{
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
	}
}
