package stepDefinitions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPagePom;
import pageObjects.MyAccountPagePom;
public class LoginStepDefitions 
{
	LoginPagePom lp ;
	MyAccountPagePom myAcc;
	
	@Given("user opens login page")
	public void user_opens_login_page()
	{
		Hooks.driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}
	@When("user enter {string} and {string}")
	public void user_enter_username_and_password(String username,String password)
	{
		lp = new LoginPagePom(Hooks.driver);
		lp.enterEmail().sendKeys(username);
		lp.enterPass().sendKeys(password);
	}
	@And("click on login button")
	public void click_on_login_button() {
		lp.clickLogin();
	}
	@Then("home page should be displayed")
	public void home_page_should_be_displayed() throws InterruptedException 
	{
		Thread.sleep(2000);
		myAcc=new MyAccountPagePom(Hooks.driver);
		boolean targetPage = myAcc.isMyAccPageExist();
		Assert.assertTrue(targetPage);
	}
	@Then("Logout the page")
	public void logout_the_page() {
		//myAcc.logoutBtn();
	}
	@Then("close the browser")
	public void close_the_browser() throws InterruptedException 
	{
	}


}
