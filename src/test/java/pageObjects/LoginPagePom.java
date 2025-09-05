package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePom 
{
	@FindBy(id = "input-email")
	private WebElement emailTxt;

	@FindBy(id = "input-password")
	private WebElement passTxt;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement LoginBtn;

	public LoginPagePom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement enterEmail()
	{
		return emailTxt;
	}
	public WebElement enterPass()
	{
		return passTxt;
	}
	public void clickLogin()
	{
		LoginBtn.click();	
	}
}
