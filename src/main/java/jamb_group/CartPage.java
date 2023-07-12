package jamb_group;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import jamb_group.OutilTechnique;

public class CartPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath = "//td[2]/input")
	private WebElement quantity;
	
	public CartPage(WebDriver driver) {
//		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void doubleQuantity() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		quantity = wait.until(ExpectedConditions.elementToBeClickable(quantity));
		
		int sum = Integer.parseInt(quantity.getAttribute("value")) * 2;
		OutilTechnique.remplirChamp(quantity, String.valueOf(sum));
	}
	
	
}
