package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageShop extends AbstractPage{
	

	@FindBy (xpath = "//a[@class='addToCart']")
	private WebElement item;
	
	@FindBy (className = "lnr-cart")
	private WebElement cartRecap;
	
	@FindBy (xpath = "//a[@onclick='viewShoppingCartPage();']")
	private WebElement goToCart;
	
	@FindBy (className = "shop-cart")
	private WebElement countItem;
	
	
	public PageShop(WebDriver driver) {
		super(driver);
//		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @param wait
	 * @return int
	 * return number of items in cart
	 */
	public int countItems(WebDriverWait wait) {
//		WebElement countItem = super.getDriver().findElement(By.xpath("//div[@class='shop-cart']/a/font"));
		WebElement countItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='shop-cart']/a/font")));
		String text = countItem.getText();
		return Integer.parseInt(text.replaceAll("[^0-9]", ""));
	}
	/**
	 * 
	 * @param wait
	 * add item to cart
	 */
	public void addItem(WebDriverWait wait) {
		item = wait.until(ExpectedConditions.elementToBeClickable(item));
		item.click();
		
	}
	
	/**
	 * mouse hover to see recap of items in cart
	 */
	public void recapCart() {		
		Actions action = new Actions(getDriver());
		action.moveToElement(cartRecap).perform();
	}
	
	/**
	 * 
	 * @param wait
	 * @return new cart page
	 * go to cart page
	 * 
	 */
	public CartPage goToCartPage(WebDriverWait wait) {
		goToCart = wait.until(ExpectedConditions. elementToBeClickable(goToCart));
		goToCart.click();
		return new CartPage(getDriver());
	}
	
}
