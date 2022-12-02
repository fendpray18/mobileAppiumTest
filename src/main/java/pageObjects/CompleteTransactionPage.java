package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CompleteTransactionPage {
	
	private AppiumDriver<AndroidElement> driver;
	
	public CompleteTransactionPage(AndroidDriver<AndroidElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/completeTV") 
	private WebElement completeTransactionPage;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/thankYouTV") 
	private WebElement wordingSuccess;
	
	public boolean validateCompletePage() throws InterruptedException{ 
		 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(completeTransactionPage));
	     
	     return completeTransactionPage.isDisplayed(); 
	     
		}
	
	public String validateWordingSuccess() throws InterruptedException{ 
		 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(wordingSuccess));
	     
	     return wordingSuccess.getText(); 
		}
	
}
