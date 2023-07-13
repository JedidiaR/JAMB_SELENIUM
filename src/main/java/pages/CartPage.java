package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.OutilTechnique;

public class CartPage extends AbstractPage{
	
	
	@FindBy (name = "quantity")
	private WebElement quantity;
	
	@FindBy (xpath = "//a[@onclick=\"javascript:updateCart('#mainCartTable');\"]")
	private WebElement recalculate;
	
	@FindBy (xpath = "//a[@href='/shopizer/shop/order/checkout.html']")
	private WebElement payment;
	
	@FindBy (className = "nomargin")
	private WebElement item;
	
	@FindBy (className = "amount")
	private WebElement subtotal;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	/**
	 * 
	 * @return WebElement
	 * get item from cart
	 */
	public WebElement getItemFromCart() {
		return item;
	}
	
	/**
	 * 
	 * @param wait
	 * return double quantity from cart
	 */
	public void doubleQuantity(WebDriverWait wait) {
		quantity = wait.until(ExpectedConditions.elementToBeClickable(quantity));
		
		int sum = Integer.parseInt(quantity.getAttribute("value")) * 2;
		OutilTechnique.remplirChamp(quantity, String.valueOf(sum));
	}
	/**
	 * click recalculate button
	 */
	public void recalculate() {
		recalculate.click();
	}
	
	/**
	 * 
	 * @param wait
	 * go to payment page
	 */
	public void goToPayment(WebDriverWait wait) {
		payment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/shopizer/shop/order/checkout.html']")));
		payment.click();
	}
	
	/**
	 * 
	 * @return quantity value : number of items in cart
	 * 
	 */
	public int getQuantity() {
		return Integer.parseInt(quantity.getAttribute("value"));
	}
	
	/**
	 * 
	 * @return price item
	 */
	public WebElement getPriceItem() {
		return getDriver().findElement(By.xpath("//td[@data-th='Prix']"));
	}
	
	/**
	 * 
	 * @return total price item
	 */
	public WebElement getTotalItem() {
		return getDriver().findElement(By.xpath("//td[@data-th='Total']"));
	}
	
	/**
	 * 
	 * @return webelement quantity of item
	 */
	public WebElement getQuantityWE() {
		return quantity;
	}
	
	/**
	 * 
	 * @return String subtotal
	 * 
	 */
	public String getSubTotal() {
		return subtotal.getText().substring(3);
	}
	
	/**
	 * 
	 * @return String subtotal
	 * 
	 */
	public String getSubTotal2() {
		WebElement sub = getDriver().findElement(By.xpath("//span[@class='amount']"));
		String res = sub.getText().substring(3);
		return res;
//		return Integer.parseInt(res);
	}
	
	/**
	 * 
	 * @return image of item
	 * 
	 */
	public WebElement getImgItem() {
		return getDriver().findElement(By.xpath("//div[@class='row-cart']/*/img"));
		
	}	
	
}
