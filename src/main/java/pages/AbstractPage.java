package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import composants.NavBar;

public class AbstractPage {

	private WebDriver driver;
	protected NavBar navBar;
	
	
	public AbstractPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		navBar = new NavBar(driver);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public NavBar getNavBar() {
		return navBar;
	}
	
	
}
