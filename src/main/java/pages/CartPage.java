package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.OutilTechnique;

public class CartPage extends AbstractPage{
	
	
	@FindBy (xpath = "//input[@name='quantity']")
	private WebElement quantity;
	
	@FindBy (xpath = "//a[@onclick=\"javascript:updateCart('#mainCartTable');\"]")
	private WebElement recalculate;
	
	@FindBy (xpath = "//a[@href='/shopizer/shop/order/checkout.html']")
	private WebElement payment;
	
	@FindBy (xpath = "//span[@class='nomargin']")
	private WebElement item;
	
	public CartPage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getItemFromCart() {
		return item;
	}
	
	public void doubleQuantity(WebDriverWait wait) {
		quantity = wait.until(ExpectedConditions.elementToBeClickable(quantity));
		
		int sum = Integer.parseInt(quantity.getAttribute("value")) * 2;
		OutilTechnique.remplirChamp(quantity, String.valueOf(sum));
	}
	
	public void recalculate() {
		recalculate.click();
	}
	
	public void goToPayment(WebDriverWait wait) {
		payment = wait.until(ExpectedConditions.elementToBeClickable(payment));
		payment.click();
//		payment.click();
	}
	
	
}
