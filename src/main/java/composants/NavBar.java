package composants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.RegistrationPage;

public class NavBar {
	
	private WebDriver driver;
	
	@FindBy (xpath = "//li[@class='click_menu']/a")
	private WebElement account;
	
	@FindBy (id = "registerLink")
	private WebElement register;
	
	@FindBy (className = "lnr-cart")
	private WebElement cartRecap;
	
	public NavBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	/**
	 * 
	 * @return webelement cart
	 */
	public WebElement getCart() {
		return cartRecap;
	}
	
	/**
	 * click account
	 */
	public void clickAccount() {
		account.click();
	}
	
	/**
	 * click register
	 * @return registration page
	 */
	public RegistrationPage clickRegister() {
		register.click();
		return new RegistrationPage(driver);
	}
	
	/**
	 *  GETTER
	 * @return register webelement
	 */
	public WebElement getRegister() {
		return register;
	}

}
