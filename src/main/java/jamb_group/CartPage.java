package jamb_group;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
//		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
