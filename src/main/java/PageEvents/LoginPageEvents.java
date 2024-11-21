package PageEvents;

import org.testng.Assert;

import PageObjects.LoginPageElements;
import Utils.ElementFetch;

public class LoginPageEvents {
	ElementFetch ele = new ElementFetch();
//	LoginPageEvents lp = new LoginPageEvents();
	public void verifyIfLoginPageIsLoaded() {
//		Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.loginText).size()>0, "Element not found");
		String expectedText = ele.getWebElement("XPATH", LoginPageElements.mainPageText).getText();
		
		Assert.assertEquals("Shubham Dalal", expectedText);
//		return expectedText;
		
		
	}
	public void enterCredentials() {
		ele.getWebElement("XPATH", LoginPageElements.emailAddress).sendKeys("shubhamdalal1997@gmail.com");
		ele.getWebElement("XPATH", LoginPageElements.loginPassword).sendKeys("Shubham@123");
	}
	public void buttonClick() {
		ele.getWebElement("XPATH", LoginPageElements.loginText).click();
		String expectedText = ele.getWebElement("XPATH", LoginPageElements.mainPageText).getText();
		
		System.out.println(expectedText);
	}
}
