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

public class FillPayment {
	
	private AppiumDriver<AndroidElement> driver;
	
	public FillPayment(AndroidDriver<AndroidElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/enterPaymentTitleTV")
	private WebElement paymentPage;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/nameET")
	private WebElement fullnameEl;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/cardNumberET")
	private WebElement cardNumberEl;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/expirationDateET")
	private WebElement expDateEl;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/securityCodeET")
	private WebElement secureDateEl;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox")
	private WebElement checkbox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Review Order']")
	private WebElement reviewBtn;
	
	public boolean validatePaymentPage() throws InterruptedException{ 
		 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(paymentPage));
	     return paymentPage.isDisplayed(); 
		}
	
	public void inputFullname(String fullname){ 
		fullnameEl.sendKeys(fullname);
		}
	
	public void inputCard(String card){ 
		cardNumberEl.sendKeys(card);
		}
	
	public void inputExp(String expDate){
		expDateEl.sendKeys(expDate);
		}
	
	public void inputSecure(){
		String randomData = FillShippingAddress.randomValues(100);
		secureDateEl.sendKeys(randomData);
		}
	
	public String validateCheckbox() throws InterruptedException{ 
		 String statusCheckbox = checkbox.getAttribute("checked");
		 System.out.println(statusCheckbox);
		 
		 if(statusCheckbox=="false") {
			 checkbox.click();
		 }else {
			 System.out.println("Already checked");
		 }
		 String actStatus = checkbox.getText();
		 String str = actStatus.replace("My ", "").replace("my ", "").replace(".", "");
		 return str.substring(0, 1).toUpperCase() + str.substring(1);
	     
		}
	
	public void reviewButton(){ reviewBtn.click(); }
	
}
