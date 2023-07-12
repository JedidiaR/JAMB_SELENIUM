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
	
	@FindBy (xpath = "//a[@onclick=\"javascript:updateCart('#mainCartTable');\"]")
	private WebElement recalculate;
	
	@FindBy (xpath = "//div[2]/a")
	private WebElement payment;
	
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
	
	public void recalculate() {
		recalculate.click();
	}
	
	public void goToPayment() {
		payment.click();
	}
	
	
}
