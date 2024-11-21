package qa.test;

import org.testng.annotations.Test;
import Base.BaseTest;
import PageEvents.HomePageEvents;
import PageEvents.LoginPageEvents;
import Utils.ElementFetch;

public class Testcase1 extends BaseTest{
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
  @Test
  public void sampleMethodForEnteringCredentials() throws InterruptedException {
	  homePage.signInButton();
	  loginPage.enterCredentials();
	  loginPage.buttonClick();
	  
	  loginPage.verifyIfLoginPageIsLoaded();
	  Thread.sleep(5000);
  }
  
  @Test
  public void secondTest() {
	  
  }
}
