package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pages.CartPage;
import pages.PageShop;
import utils.Utils;
import utils.Utils.ENavigateur;

public class RunTest {
	
	WebDriver driver;
	WebDriverWait wait;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String site = "http://localhost:8080/shopizer/shop?locale=fr";
	
	@Before
	public void init() {
		driver = Utils.choisirNavigateur(ENavigateur.chrome);
		driver.get(site);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@Test
	public void testCaseOne() {
		
		// STEP 1 DONE
		logger.info("STEP 1 : GO TO LANDING PAGE : " + driver.getTitle());
		logger.info("ASSERT STEP 1 IN PROGRESS...");
		assertEquals("ERROR GET SITE","Importa", driver.getTitle());
		logger.info("ASSERT STEP 1 DONE");
		
		// STEP 2 DONE : GET RANDOM ITEM TO ADD TO CART
		// CHANGE div[1] to div[2] or more to chose other item
		PageShop pageShop = new PageShop(driver); // home page
		pageShop.addItem(wait);
		logger.info("STEP 2 : ADD ITEM TO CART");		
		logger.info("ASSERT STEP 2 IN PROGRESS...");
		assertEquals("ERROR COUNT ITEMS",1, pageShop.countItems(wait));
		logger.info("ASSERT STEP 2 DONE");	
		
		// STEP 3 DONE : CLICK TO 'panier d achat'
		pageShop.recapCart();
		logger.info("CART RECAP");
		CartPage cartPage = pageShop.goToCartPage(wait);
		logger.info("STEP 3 : GO TO CART PAGE");
		logger.info("ASSERT STEP 3 IN PROGRESS...");
		assertEquals("ERROR GO TO CART PAGE","http://localhost:8080/shopizer/shop/cart/shoppingCart.html",driver.getCurrentUrl());
		logger.info("ASSERT STEP 3 DONE");
		
		// STEP 4 DONE : ITEM VISIBLE
		logger.info("STEP 4 : ITEM VISIBILITY");
		assertTrue("ITEM IS NOT VISIBLE", cartPage.getItemFromCart().isDisplayed());
		// TODO: image / nom / quantité / prix / total
		
		
		// STEP 5 DONE : DOUBLE QUANTITY OF CHOSEN ITEM IN CART PAGE
		logger.info("STEP 5 : DOUBLE QUANTITY");
		cartPage.doubleQuantity(wait);
		logger.info("ASSERT STEP 5 IN PROGRESS...");
		assertEquals("ERROR DOUBLE QUANTITY",2, cartPage.getQuantity());
		logger.info("ASSERT STEP 5 DONE");
		
		// STEP 6 DONE : RECALCULATE BUTTON
		logger.info("STEP 6 : RECALCULATE CART SUM");
		String subTotal1 = cartPage.getSubTotal();
		logger.info("STEP 6 BEFORE ASSERT : " + subTotal1);
		cartPage.recalculate();	
		
		driver.navigate().refresh();
		
		String subTotal2 = cartPage.getSubTotal2();
		float expected = Float.parseFloat(subTotal1) * 2;
		assertEquals("ERROR SUBTOTAL",expected, Float.parseFloat(subTotal2), 1.00);
		logger.info("STEP 6 AFTER ASSERT : " + subTotal2);
		
		
		// STEP 7 : PAYMENT
		cartPage.goToPayment(wait);
		logger.info("STEP 7 : GO TO PAYMENT");
		logger.info("ASSERT STEP 7 IN PROGRESS...");
		assertEquals("http://localhost:8080/shopizer/shop/order/checkout.html", driver.getCurrentUrl());
		logger.info("ASSERT STEP 7 DONE");
	}

}
