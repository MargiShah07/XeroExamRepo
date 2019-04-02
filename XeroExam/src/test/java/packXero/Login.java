package packXero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import testData.TestData;

public class Login extends ReUsable 
{
	public static void LoginPage() throws Exception
	{
		System.out.println("TC1-A_Navigate to XERO");
		logger = report.startTest("Navigate to XERO");
		InitializeDriver();
		logger.log(LogStatus.INFO, "Chrome browser Launched.");
		Launch("https://login.xero.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login | Xero Accounting Software";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Title Matched");
			logger.log(LogStatus.PASS," Xero application page is displayed.");
		}
		else
		{
			System.out.println("Title didn't match");
			logger.log(LogStatus.FAIL," Xero application page is not displayed.");
		}

		String sUserName = TestData.getCellData(1, 1);
		String sPassword = TestData.getCellData(1, 2);
		
		WebElement un = driver.findElement(By.id("email"));
		un.sendKeys(sUserName);
		if(un.isDisplayed())
		{	
			logger.log(LogStatus.PASS, " User Name is displayed in User name field.");
		}
		else
		{
			logger.log(LogStatus.FAIL, " User Name is not displayed in User name field.");
		}

		Thread.sleep(2000);
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(sPassword);
		if(pass.isDisplayed())
		{
			//ClearText(pass);
			//pass.clear();
			logger.log(LogStatus.PASS, " Password is displayed in password field.");
		}
		else
		{
			logger.log(LogStatus.FAIL, " Password is not displayed in password field.");
		}

		WebElement Login = driver.findElement(By.id("submitButton"));
		if(Login.isDisplayed())
		{
			click_On_Button(Login, "Login");
			String actTitle = driver.getTitle();
			String expTitle = "Xero | Dashboard | Tekarch";
			if(actTitle.equalsIgnoreCase(expTitle))
			{
				System.out.println("Title Matched");
				//				logger.log(LogStatus.PASS," SFDC login page is opened");
				logger.log(LogStatus.PASS, "User's Home Page is displayed.");
			}

			else
			{
				System.out.println("Title didn't match");
				logger.log(LogStatus.FAIL," Error Message: Please check your username and password. Displayed.");
			}
		}
		else
		{
			logger.log(LogStatus.FAIL, "User's Home Page is not displayed.");
		}
	}
}
