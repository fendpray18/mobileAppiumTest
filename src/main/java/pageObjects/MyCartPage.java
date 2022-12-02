package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyCartPage {
	
	private AppiumDriver<AndroidElement> driver;
	
	public MyCartPage(AndroidDriver<AndroidElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/priceTV") //Sauce Lab Back Packs
	private WebElement unitActPrice;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/totalPriceTV") //Sauce Lab Back Packs
	private WebElement actTotalPrice;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Proceed To Checkout']")
	private WebElement checkoutBtn;
	
	public void checkoutButton(){ checkoutBtn.click(); }
	
	public boolean validateProduct(String valueProduct) throws InterruptedException{ 
		 Thread.sleep(3000);
		 By prodElement = By.xpath("//android.widget.TextView[@text='"+valueProduct+"']");
	     WebElement productSelected = driver.findElement(prodElement);
	     
	     WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(productSelected));
	     
	     return productSelected.isDisplayed(); 
	     
		}
	
	public boolean validateColor(String color) throws InterruptedException{ 
		Thread.sleep(3000);
		 By colorType = By.xpath("//android.widget.ImageView[@content-desc='"+color+" color']");
	     WebElement colorSelected = driver.findElement(colorType);
	     
	     WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(colorSelected));
	     return colorSelected.isDisplayed(); 
		}
	
	public boolean validateQuantity(int qty) throws InterruptedException{ 
		Thread.sleep(3000);
		 By qtyElement = By.xpath("//android.widget.TextView[@text='"+qty+" Items']");
    	 WebElement qtySelected = driver.findElement(qtyElement);
    	 
    	 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(qtySelected));
	     return qtySelected.isDisplayed(); 
	     
		}
	
	public String priceCalculate(int qty){ 
		 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(unitActPrice));
	     
	     String unitPrice = unitActPrice.getText();
	     
	     int unit = removedChar(unitPrice);
	     int expCalc= unit*qty;
	     
	     String formatr = currencyformatter(expCalc);
	     System.out.println("$ "+formatr+"");
	     return "$ "+formatr+"";
		}
	
	public String actCalculate(int actCost){ return actTotalPrice.getText();
		}
	
	public static int removedChar(String valueProduct) {
		 char current = valueProduct.charAt(1);
		 String priceString="";
		 if(current!=' ') {
			 priceString = valueProduct.substring(1);
		 } else {
			 priceString = valueProduct.substring(2);
		 }
	     String priceFormater = priceString.replace(".", "");
	     return Integer.parseInt(priceFormater);
	}
	
	public static String currencyformatter(int number) {
//		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		return String.format("%.2f", number/100.0);
	}
	
}
