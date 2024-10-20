package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	//webElement
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement txt_firstname ;
	
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txt_lastname ;
	
	@FindBy(xpath = "//input[@id='input-email']") WebElement txt_email ;
	
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement txt_tel ;
	
	@FindBy(xpath = "//input[@id='input-password']") WebElement txt_pass ;
	
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txt_confirm_pass ;
	
	@FindBy(xpath = "//input[@name='agree']") WebElement chk_agree ;
	
	@FindBy(xpath = "//input[@value='Continue']") WebElement btn_continue ;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement Confirmation_Msg;
	
	//Actions
	
	public void setFirstname (String fname)
	
	{
		txt_firstname.sendKeys(fname);
	}
	public void setLastname (String lname)
		
		{
		txt_lastname.sendKeys(lname);
		}
	
	public void setemail(String email)
	{
		txt_email.sendKeys(email);
	}
	public void setTel(String tel)
	{
		txt_tel.sendKeys(tel);
	}
	public void setPass(String pwd)
	{
		txt_pass.sendKeys(pwd);
	}
	public void conPass(String pwd)
	{
		txt_confirm_pass.sendKeys(pwd);
	}
	public void ChekAgree()
	{
		chk_agree.click();
	}
	public void btn_Click()
	{ //sol1
		btn_continue.click();
	}
	//sol2 
	//btnContinue.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
				
	//sol4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();", btnContinue);
	
	//Sol 5
	//btnContinue.sendKeys(Keys.RETURN);
	
	//Sol6  
	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
	public String get_Confirmation()
	{
		try
		{
		return (Confirmation_Msg.getText());
		}
			
		catch (Exception e) {
			return (e.getMessage());

		}
		
	}

}
