package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	private  String site = "http://localhost:8080/shopizer/shop?locale=fr";
	
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
		assertEquals("Importa", driver.getTitle());
		logger.info("ASSERT STEP 1 DONE");
		
		// STEP 2 DONE : GET RANDOM ITEM TO ADD TO CART
		// CHANGE div[1] to div[2] or more to chose other item
		PageShop pageShop = new PageShop(driver); // home page
		pageShop.addItem(wait);
		logger.info("STEP 2 : ADD ITEM TO CART");		
		logger.info("ASSERT STEP 2 IN PROGRESS...");
		assertEquals(1, pageShop.countItems(wait));
		logger.info("ASSERT STEP 2 DONE");	
		
		// STEP 3 DONE : CLICK TO 'panier d achat'
		pageShop.recapCart();
		logger.info("CART RECAP");
		CartPage cartPage = pageShop.goToCartPage(wait);
		logger.info("STEP 3 : GO TO CART PAGE");
		logger.info("ASSERT STEP 3 IN PROGRESS...");
		assertEquals("http://localhost:8080/shopizer/shop/cart/shoppingCart.html",driver.getCurrentUrl());
		logger.info("ASSERT STEP 3 DONE");
		
		// STEP 4 DONE : ITEM VISIBLE
		logger.info("STEP 4 : ITEM VISIBILITY");
		assertTrue("ITEM IS NOT VISIBLE", cartPage.getItemFromCart().isDisplayed());
		
		// STEP 5 DONE : DOUBLE QUANTITY OF CHOSEN ITEM IN CART PAGE
		logger.info("STEP 5 : DOUBLE QUANTITY");
		cartPage.doubleQuantity(wait);
		logger.info("ASSERT STEP 5 IN PROGRESS...");
		assertEquals(2, cartPage.getQuantity());
		logger.info("ASSERT STEP 5 DONE");
		
		// STEP 6 DONE : RECALCULATE BUTTON
		logger.info("STEP 6 : RECALCULATE CART SUM");	
		cartPage.recalculate();	
		
		driver.navigate().refresh();
		
		// STEP 7 : PAYMENT
		cartPage.goToPayment(wait);
		logger.info("GO TO PAYMENT");
	}

}
