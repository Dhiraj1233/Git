package stepDefinitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import pageObjects.HomePagePom;
import pageObjects.LoginPagePom;
import pageObjects.MyAccountPagePom;
import utility.ExcelUtility1;

public class LoginDdt 
{
	
	@Given("User opens the login Page")
	public void user_opens_the_login_page()
	{
		Hooks.driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}

	@When("user enters the credentials from excel and click on login")
	public void user_enters_the_credentials_from_excel_and_click_on_login() throws IOException 
	{
		String path="./testData/OpenCar_Login.xlsx";
		ExcelUtility1 u = new ExcelUtility1(path);
		int totalRows = u.getRowCount("Sheet1");
		int totalcols = u.getCellCount("Sheet1", 1);
		for(int r=1; r<=totalRows;r++) 
		{
			String username = u.getCellData("Sheet1", r, 0);
			String password = u.getCellData("Sheet1", r, 1);
			String res = u.getCellData("Sheet1", r, 2);
			
			LoginPagePom lp = new LoginPagePom(Hooks.driver);
			lp.enterEmail().sendKeys(username);
			lp.enterPass().sendKeys(password);
			lp.clickLogin();
			
			MyAccountPagePom myAcc= new MyAccountPagePom(Hooks.driver);
			HomePagePom hp = new HomePagePom(Hooks.driver);
			boolean targetPage = myAcc.isMyAccPageExist();
			
			if(res.equalsIgnoreCase("valid")) {
				if(targetPage==true) {
					myAcc.logoutBtn();
					Assert.assertTrue(true);
					hp.myAccount();
					hp.loginClickBtn();
				}
				else {
					Assert.assertTrue(false);
					hp.myAccount();
					hp.loginClickBtn();
				}
			}
			if(res.equalsIgnoreCase("invalid")) {
				if(targetPage==true) {
					myAcc.logoutBtn();
					Assert.assertTrue(false);
					hp.myAccount();
					hp.loginClickBtn();
				}
				else {
					Assert.assertTrue(true);
					hp.myAccount();
					hp.loginClickBtn();
				}
			}
		}    
	}
	@When("Close the browser")
	public void close_the_browser() {
	    System.out.println("Success");
	}

}
