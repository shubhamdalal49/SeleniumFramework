package PageObjects;

public interface LoginPageElements {
	String loginText = "//*[@id=\"ui\"]/div/div/form/div/div[3]";
	String emailAddress = "//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input";
	String loginPassword = "//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input";
	String mainPageText = "//*[@id=\"top-header-menu\"]/div[2]/span[1]";
}
