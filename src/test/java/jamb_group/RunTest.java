package jamb_group;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jamb_group.OutilTechnique.ENavigateur;

public class RunTest {
	
	WebDriver driver;
	WebDriverWait wait;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String site = "http://localhost:8080/shopizer/shop?locale=fr";
	
	@Before
	public void init() {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.get(site);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@Test
	public void first() {

		logger.info("STEP 1 : GO TO LANDING PAGE : " + driver.getTitle());
		
		// STEP 2 DONE : GET RANDOM ITEM TO ADD TO CART
		// CHANGE div[1] to div[2] or more to chose other item
		PageShop pageShop = new PageShop(driver);
		pageShop.addItem(wait);
		logger.info("STEP 2 : ADD ITEM TO CART");
		
		// STEP 3 DONE : CLICK TO 'panier d achat'
		pageShop.recapCart();
		logger.info("CART RECAP");
		CartPage cartPage = pageShop.goToCartPage(wait);
		logger.info("STEP 3 : GO TO CART PAGE");
		
		// STEP 4 : TO DO
		logger.info("STEP 4 TO DO");
		
		// STEP 5 DONE : DOUBLE QUANTITY OF CHOSEN ITEM IN CART PAGE
		logger.info("STEP 5 : DOUBLE QUANTITY");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		cartPage.doubleQuantity(wait);
		
		// STEP 6 DONE : RECALCULATE BUTTON
		logger.info("STEP 6 : RECALCULATE CART SUM");	
		cartPage.recalculate();
		
		
		// STEP 7 : PAYMENT
		
		cartPage.goToPayment(wait);
		logger.info("GO TO PAYMENT");
	}

}
