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

public class CheckoutDeliver {
	
	private AppiumDriver<AndroidElement> driver;
	
	public CheckoutDeliver(AndroidDriver<AndroidElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView [@text='Review your order']")
	private WebElement reviewCheckoutPage;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/priceTV") 
	private WebElement unitActPrice;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/itemNumberTV") 
	private WebElement itemNumber;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/totalAmountTV")
	private WebElement totalAmount;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/amountTV") 
	private WebElement deliveryCost;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/fullNameTV") 
	private WebElement fullNameEl;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/addressTV") 
	private WebElement addressEl;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/cityTV") 
	private WebElement cityEl;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/countryTV") 
	private WebElement countryEl;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/cardHolderTV") 
	private WebElement cardHolder;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/cardNumberTV") 
	private WebElement cardNumber;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/expirationDateTV") 
	private WebElement expired;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/billingAddressTV") 
	private WebElement statusAddress;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Place Order']")
	private WebElement placeBtn;
	
	public void placeOrderButton(){ placeBtn.click(); }
	
	public String actFullNameAddress(){ return fullNameEl.getText();
	}
	
	public String actAdress(){ return addressEl.getText();
	}
	
	public String actCity(){ return cityEl.getText();
	}
	
	public String actCountry(){ return countryEl.getText();
	}
	
	public String actFullNamePayment(){ return cardHolder.getText();
	}
	
	public String actCard(){ return cardNumber.getText();
	}
	
	public String actExp(){ return expired.getText();
	}
	
	public String actStatusCheckBox(){ return statusAddress.getText();
	}
	
	public boolean validateReviewPage() throws InterruptedException{ 
	     WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(reviewCheckoutPage));
	     return reviewCheckoutPage.isDisplayed(); 
		}
	
	public String actCalculate(int actCost){ return totalAmount.getText();
	}
	
	public String deliveryCalculate(String totalPrice){ 
		 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(deliveryCost));
	     
	     String deliveryPrice = deliveryCost.getText();
	     
	     int delivery = MyCartPage.removedChar(deliveryPrice);
	     int total = MyCartPage.removedChar(totalPrice);
	     
	     int expCalc= delivery+total;
	     
	     String formatr = MyCartPage.currencyformatter(expCalc);
	     System.out.println("$ "+formatr+"");
	     return "$ "+formatr+"";
		}
	
	public String expiredFormatter(String str) {
		 return "Exp: "+ str.substring(0, 2) + "/" + str.substring(2, str.length());
		}
	
}
