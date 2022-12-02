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

public class DetailProduct {
	
	private AppiumDriver<AndroidElement> driver;
	
	public DetailProduct(AndroidDriver<AndroidElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/plusIV") //Sauce Lab Back Packs
	private WebElement incrementQty;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Add to cart']")
	private WebElement cartButton;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@content-desc='View cart']")
	private WebElement cartIcon;
	
	public void addToCartButton(){ cartButton.click(); }
	
	public void tapCartIcon(){ cartIcon.click(); }
	
	public boolean validateDetailPage(String valueProduct) throws InterruptedException{ 
		 Thread.sleep(3000);
		 By prodElement = By.xpath("//android.widget.TextView[@text='"+valueProduct+"']");
	     WebElement productSelected = driver.findElement(prodElement);
	     
	     WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(productSelected));
	     
	     return productSelected.isDisplayed(); 
	     
		}
	
	public void clickColor(String color) throws InterruptedException{ 
		 By colorType = By.xpath("//android.widget.ImageView[@content-desc='"+color+" color']");
	     WebElement colorSelected = driver.findElement(colorType);
	     
	     WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(colorSelected));
	     colorSelected.click(); 
		}
	
	public void incrementQuantity(int qty) throws InterruptedException{ 
		 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(incrementQty));
	     
	     for(int i=1; i<qty; i++){
	    	 By qtyElement = By.xpath("//android.widget.TextView[@text='"+i+"']");
	    	 WebElement qtySelected = driver.findElement(qtyElement);
	    	 String qtyAct = qtySelected.getText();
			 
			 String qtyExp= Integer.toString(qty);
				if(qtyAct!=qtyExp){
					incrementQty.click();
				} else {
					break;
				}
			}
	     
		}
	
}
