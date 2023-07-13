package composants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBar {
	
	private WebDriver driver;
	
	@FindBy (xpath = "//li[@class='click_menu']/a")
	private WebElement account;
	
	public NavBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickAccount() {
		account.click();
	}

}
