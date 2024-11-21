package PageEvents;

import PageObjects.HomePageElements;
import Utils.ElementFetch;

public class HomePageEvents {
	ElementFetch ele = new ElementFetch();
	public void signInButton() {
		ele.getWebElement("XPATH", HomePageElements.loginButton).click();;
	}
}
