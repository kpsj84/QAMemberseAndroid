package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.PostHistoryPage;
import WebPageObjects.WelcomePage;

public class wPlayVideoPostTest extends WBase {
	
	@Test
	public void wPlayVideoPostTestCase()throws InterruptedException {
		Thread.sleep(7000);
	    
	    WelcomePage wp = new WelcomePage(driver);
	    wp.LoginButton().click();
		Thread.sleep(1000);
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestcvp@yopmail.com");
		lp.Password().sendKeys("kqatestcvp");
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(10000);
			    
		HomePage hp = new HomePage(driver);
	    hp.CreatorMenu().click();
		Thread.sleep(2000);
		
		PostHistoryPage php = new PostHistoryPage(driver);
        php.PostHistorySubMenu().click();
    	Thread.sleep(5000);
		
    	php.ClickOnContent().click();
        Thread.sleep(3000);
        
        String Text = driver.findElement(By.xpath("//p[text()='Auto Test - View Video Post']")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"Auto Test - View Video Post");
	}      

}
