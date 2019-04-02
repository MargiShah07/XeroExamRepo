package packXero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class ProfileImage extends ReUsable
{
	public static void UploadPhoto() throws Exception
	{
		Login.LoginPage();
		Thread.sleep(2000);
		System.out.println("TC6-A_Test Upload profile image");
		logger = report.startTest("Test Upload profile image");

		WebElement UserName = driver.findElement(By.xpath("//button[contains(@title,'Margi Shah')]"));
		if(UserName.isDisplayed())
		{
			click_On_Button(UserName, "MS UserName");
			logger.log(LogStatus.PASS, "Xero navigation box is displayed");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Xero navigation box is not displayed");
		}

		WebElement EditProfile = driver.findElement(By.xpath("//li[@class='xrh-addon xrh-addon-lastvisible']//li[1]//a[1]"));
		if(EditProfile.isDisplayed())
		{
			click_On_Button(EditProfile, "Edit Profile");
			logger.log(LogStatus.PASS, "Profile Setting page is displayed");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Profile Setting page is not displayed");
		}

		WebElement UploadImage = driver.findElement(By.xpath("//span[contains(text(),'Upload Image')]"));
		if(UploadImage.isDisplayed())
		{
			click_On_Button(UploadImage, "Edit Profile");
			System.out.println("Upload Image is clicking");
		}
		else
		{
			System.out.println("Upload Image is not clicking");
		}
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement browse = driver.findElement(By.xpath("//input[@name='file']"));
		browse.sendKeys("C:\\Users\\Nilay\\Desktop\\PayRoll1\\img\\accounting.png");


		WebElement upload = driver.findElement(By.xpath("//div[@id='button-1178-btnWrap']"));
		if(upload.isDisplayed())
		{
			click_On_Button(upload, "Upload Image");
			logger.log(LogStatus.PASS, "Uploaded Image is displayed");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Uploaded Image is not displayed");
		}
	}
}
