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

public class LoginPage {
	
	private AppiumDriver<AndroidElement> driver;

	public LoginPage(AndroidDriver<AndroidElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/loginTV")
	private WebElement loginPage;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/nameET")
	private WebElement nameField;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/passwordET")
	private WebElement passwordField;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/username1TV")
	private WebElement nameData;
	
	@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/password1TV")
	private WebElement passwordData;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Login']") //Sauce Lab Back Packs
	private WebElement loginBtn;
	
	public boolean validateLoginPage() throws InterruptedException{ 
		 WebDriverWait wait= new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(loginPage));
	     return loginPage.isDisplayed(); 
		}
	
	public void inputName(String name){ 
		nameField.sendKeys(name);
		}
	
	public void inputPassword(String password){ 
		passwordField.sendKeys(password);
		}
	
	public String textNameData(){ 
		System.out.println("UserName : "+nameData.getText());
		return nameData.getText();
		}
	
	public String textPaswrdData(){ 
		System.out.println("Password : "+passwordData.getText());
		return passwordData.getText();
	}
	
	
	public void loginButton(){ loginBtn.click(); }
	
}
