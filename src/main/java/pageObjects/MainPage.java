package pageObjects;

import java.util.List;

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

public class MainPage {
	
	private AppiumDriver<AndroidElement> driver;
	int index = 1;
	
	public MainPage(AndroidDriver<AndroidElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Products']")
	private WebElement productsPage;
	
	@AndroidFindBy(xpath="//android.widget.TextView") //Sauce Lab Back Packs
	private List<WebElement> listProducts;
	
	public boolean validateMainPage() {
		 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(productsPage));
	     return productsPage.isDisplayed(); 
		}
	
	public void findProductSelected(String valueProduct) throws InterruptedException{ 
		 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(productsPage));
	     
	     By prodElement = By.xpath("//android.widget.ImageView[@content-desc='"+valueProduct+"']");
	     WebElement productSelected = driver.findElement(prodElement);
	     
	     for(WebElement product : listProducts){
				String getProduct=product.getText();
				if(getProduct.equals(valueProduct)){
					productSelected.click();
					System.out.println("Product : "+ getProduct);
					break;
				} else {
					index++;
				}
			}
	     
		}	
	
}
