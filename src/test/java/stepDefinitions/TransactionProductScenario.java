package stepDefinitions;

import java.util.concurrent.TimeUnit;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import dataFile.Storage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageObjects.*;
import resources.base;

public class TransactionProductScenario extends base{
	
	public static AndroidDriver<AndroidElement> driver;
	Storage data = new Storage();
	MainPage main;
	DetailProduct detail;
	Scrolling scroll;

	/*
    =========== Scenario ========================
    */

	@Given("^Open the list product page$")
	public void open_the_list_product_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
    	
    	service = startServer();
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
    	main = new MainPage(driver);
    	main.validateMainPage();

	}

	@When("^User choose the \"([^\"]*)\"$")
	public void userChooseThe(String product) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		main = new MainPage(driver);
		main.findProductSelected(product);

		data.valueProduct = product;
	}

	@And("Validate product on detail product page")
	public void ValidateProductOnDetailPage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		detail = new DetailProduct(driver);
		System.out.println(data.valueProduct);
		detail.validateDetailPage(data.valueProduct);

	}

	@And("^User input criteria to \"([^\"]*)\" and \"([^\"]*)\" product$")
	public void UserInputCriteria(String color, int quantity) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		detail = new DetailProduct(driver);
		scroll=new Scrolling(driver);
		scroll.scrollDown();
//		scroll.scrollToText("Add to cart");
		detail.clickColor(color);
		detail.incrementQuantity(quantity);

		data.valueColor = color;
		data.valueQuantity = quantity;

		detail.addToCartButton();
		scroll.scrollUp();

	}

	@Then("Tap add cart button")
	public void TapAddCartButton() {
	    // Write code here that turns the phrase above into concrete actions

		detail = new DetailProduct(driver);
		detail.tapCartIcon();

	}

	@And("Validate product on My Cart Page")
	public void ValidateProductOnMyCartPage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		MyCartPage cart = new MyCartPage(driver);
		cart.validateProduct(data.valueProduct);

		System.out.println(data.valueColor);
		System.out.println(data.valueQuantity);

		//Not found color element specifically for validation
		//cart.validateColor(data.valueColor);
		cart.validateQuantity(data.valueQuantity);

		String expTotal = cart.priceCalculate(data.valueQuantity);
		String actTotal = cart.actCalculate(data.valueQuantity);

		try {
			  Assert.assertEquals(actTotal, expTotal);
			} catch (Exception e) {
			  System.out.println("assertion not expected");
		}

		data.valueTotal = expTotal;

		cart.checkoutButton();
	}

	@Then("Log in account to proceed payment")
	public void LogInAccount() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		LoginPage login = new LoginPage(driver);
		login.validateLoginPage();

		String extNama = login.textNameData();
		String extPswrd = login.textPaswrdData();
		login.inputName(extNama);
		login.inputPassword(extPswrd);
		login.loginButton();

	}

	@Then("Fill shipping address")
	public void FillShippingAddress() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		FillShippingAddress ship = new FillShippingAddress(driver);
		String randomData = ship.randomValues(10000);
		ship.validateAddressPage();
		ship.inputFullname(data.fullName+randomData);
		ship.inputAddress1(data.Address1+randomData);
		ship.inputAddress2(data.Address2+randomData);

		scroll.scrollDown();
		ship.inputCity(data.City);
		ship.inputState(data.State);
		ship.inputZip(randomData);
		ship.inputCountry(data.Country);

		data.values = randomData;

		ship.paymentButton();

		System.out.println(data.values);
	}

	@Then("Fill account payment")
	public void FillAccountPayment() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		FillPayment payment = new FillPayment(driver);
		payment.validatePaymentPage();
		payment.inputFullname(data.fullName+ data.values);
		payment.inputCard(data.Card+ data.values);
		payment.inputExp(data.Exp);
		payment.inputSecure();
		payment.validateCheckbox();

		data.valueCheckbox = payment.validateCheckbox();

		System.out.println(data.valueCheckbox);

		payment.reviewButton();

	}

	@Then("Validate checkout deliver data")
	public void ValidateCheckoutDeliver() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		CheckoutDeliver delivery = new CheckoutDeliver(driver);
		delivery.validateReviewPage();

		detail.validateDetailPage(data.valueProduct);

		scroll.scrollDown();

		//validate personal data
		Assert.assertEquals(delivery.actFullNameAddress(), data.fullName+ data.values);
		System.out.println("Success validate - 1");
		Assert.assertEquals(delivery.actAdress(), data.Address1+ data.values);
		System.out.println("Success validate - 2");
		Assert.assertEquals(delivery.actCity(), data.City+", "+ data.State);
		System.out.println("Success validate - 3");
		Assert.assertEquals(delivery.actCountry(), data.Country+", "+ data.values);
		System.out.println("Success validate - 4");
		Assert.assertEquals(delivery.actFullNamePayment(), data.fullName+ data.values);
		System.out.println("Success validate - 5");
		Assert.assertEquals(delivery.actCard(), data.Card+ data.values);
		System.out.println("Success validate - 6");
		Assert.assertEquals(delivery.actExp(), delivery.expiredFormatter(data.Exp));
		System.out.println("Success validate - 7");
		Assert.assertEquals(delivery.actStatusCheckBox(), data.valueCheckbox);
		System.out.println("Success validate - 8");

		//validate delivery cost calculation
		String expTotal = delivery.deliveryCalculate(data.valueTotal);
		String actTotal = delivery.actCalculate(data.valueQuantity);
		System.out.println(actTotal);

		try {
			  Assert.assertEquals(actTotal, expTotal);
			} catch (Exception e) {
			  System.out.println("assertion not expected");
		}

		delivery.placeOrderButton();

	}

	@Then("Validate success buy product")
	public void ValidateSuccessBuyProduct() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		CompleteTransactionPage complete = new CompleteTransactionPage(driver);
		complete.validateCompletePage();

		String expTotal = complete.validateWordingSuccess();
		String actTotal = data.WordingSuccess;
		System.out.println(actTotal);

		try {
			  Assert.assertEquals(actTotal, expTotal);
			} catch (Exception e) {
			  System.out.println("assertion not expected");
		}

	}

}
    