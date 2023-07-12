package jamb_group;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageShop extends AbstractPage{
	

	@FindBy (xpath = "//a[@class='addToCart']")
	private WebElement item;
	
	@FindBy (xpath = "//span[@class='lnr lnr-cart']")
	private WebElement cartRecap;
	
	@FindBy (xpath = "//a[@onclick='viewShoppingCartPage();']")
	private WebElement goToCart;
	
	@FindBy (xpath = "//div[@class='shop-cart']/a")
	private WebElement countItem;
	
	
	public PageShop(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCountItem() {
		return countItem;
	}
	
	public void addItem(WebDriverWait wait) {
		item = wait.until(ExpectedConditions.elementToBeClickable(item));
		item.click();
		
	}
	
	public void recapCart() {		
		//Creating object of an Actions class
		Actions action = new Actions(super.getDriver());

		//Performing the mouse hover action on the target element.
		action.moveToElement(cartRecap).perform();
	}
	
	public CartPage goToCartPage(WebDriverWait wait) {
		goToCart = wait.until(ExpectedConditions. elementToBeClickable(goToCart));
		goToCart.click();
		return new CartPage(super.getDriver());
	}
	
}
