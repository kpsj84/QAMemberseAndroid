package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.SignupPage;
import WebPageObjects.WelcomePage;

public class wDeleteAccountTest extends WBase {
	
	@Test
	public void wDeleteAccountTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.SignupButtton())).click();
		
		String email = getSaltString();
		System.out.println(email);
		String password = "123456";
		
		SignupPage sp = new SignupPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.Email())).sendKeys(email);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.Password())).sendKeys(password);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.confirmPassword())).sendKeys(password);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.SignupButton())).click();
		u.shortDelay();
		
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys(email);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys(password);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		driver.findElement(By.xpath("//*[text()='As a Creator']")).click();
		driver.findElement(By.xpath("//a[text()='Account']")).click();
		driver.findElement(By.xpath("//p[text()='Delete Account']")).click();
		u.shortDelay();
		driver.findElement(By.xpath("//*[@class='text-base font-medium leading-4']")).click();
		driver.findElement(By.xpath("//span[text()='Confirm']")).click();
		u.shortDelay();
		
		String verifyUrl = driver.getCurrentUrl();
		System.out.println(verifyUrl);
		Assert.assertEquals(verifyUrl, "https://app-qa.so.fa.dog/auth/signup");
		System.out.println("Test Case Completed");
	}
	
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString() + "@yopmail.com";
        return saltStr;
    }

}
