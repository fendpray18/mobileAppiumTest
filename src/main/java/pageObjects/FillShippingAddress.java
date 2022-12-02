package pageObjects;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FillShippingAddress {
	
	private AppiumDriver<AndroidElement> driver;
	
	public FillShippingAddress(AndroidDriver<AndroidElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/checkoutTitleTV")
	private WebElement addressPage;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/fullNameET")
	private WebElement fullname;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/address1ET")
	private WebElement address1;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/address2ET")
	private WebElement address2;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/cityET")
	private WebElement city;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/stateET")
	private WebElement state;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/zipET")
	private WebElement zip;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/countryET")
	private WebElement country;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='To Payment']")
	private WebElement paymentBtn;
	
	public boolean validateAddressPage() throws InterruptedException{ 
		 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(addressPage));
	     return addressPage.isDisplayed(); 
		}
	
	public void inputFullname(String fullnamedata){ 
		fullname.sendKeys(fullnamedata);
		}
	
	public void inputAddress1(String address){ 
		address1.sendKeys(address);
		}
	
	public void inputAddress2(String address){ 
		address2.sendKeys(address);
		}
	
	public void inputCity(String cityData){ city.sendKeys(cityData); }
	
	public void inputState(String stateData){ state.sendKeys(stateData); }
	
	public void inputZip(String zipData){ 
		zip.sendKeys(zipData); 
		}
	
	public void inputCountry(String countryData){ country.sendKeys(countryData); }
	
	public void paymentButton(){ paymentBtn.click(); }
	
	public static String randomValues(int number) {
		Random random = new Random();
		int rand= random.nextInt(number);
		return Integer.toString(rand);
	}
	
}
