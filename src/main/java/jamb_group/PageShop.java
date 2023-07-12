package jamb_group;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageShop{
	
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy (xpath = "//div[1]/div[2]/div/div/a")
	private WebElement item;
	
	@FindBy (xpath = "//div[3]/div[2]/div[1]/a")
	private WebElement cartRecap;
	
	@FindBy (xpath = "//ul/li[4]/a")
	private WebElement goToCart;
	
	
	public PageShop(WebDriver driver) {
//		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addItem() {
		item.click();
		
	}
	
	public void recapCart() {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		cart = wait.until(ExpectedConditions.elementToBeClickable(cart));
//		cart.click();
		
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(cartRecap).perform();
	}
	
	public CartPage goToCartPage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		goToCart = wait.until(ExpectedConditions.elementToBeClickable(goToCart));
		goToCart.click();
		return new CartPage(driver);
	}
	
}
