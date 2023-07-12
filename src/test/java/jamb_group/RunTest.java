package jamb_group;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jamb_group.OutilTechnique.ENavigateur;

public class RunTest {
	
	WebDriver driver;
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String site = "http://localhost:8080/shopizer/shop?locale=fr";
	
	@Test
	public void first() {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.get(site);
		logger.info("STEP 1 : GO TO LANDING PAGE : " + driver.getTitle());
//		System.out.println(driver.getTitle());
		
		// STEP 2 DONE : GET RANDOM ITEM TO ADD TO CART
		// CHANGE div[1] to div[2] or more to chose other item
		PageShop pageShop = new PageShop(driver);
		pageShop.addItem();
		logger.info("STEP 2 : ADD ITEM TO CART");
		
		// STEP 3 DONE : CLICK TO 'panier d achat'
		pageShop.recapCart();
		logger.info("CART RECAP");
		CartPage cartPage = pageShop.goToCartPage();
		logger.info("STEP 3 : GO TO CART PAGE");
		
		// STEP 4 : TO DO
		logger.info("STEP 4 TO DO");
		
		// STEP 5 DONE : DOUBLE QUANTITY OF CHOSEN ITEM IN CART PAGE
		logger.info("STEP 5 : DOUBLE QUANTITY");
		cartPage.doubleQuantity();
		
		// STEP 6 DONE : RECALCULATE BUTTON
		logger.info("STEP 6 : RECALCULATE CART SUM");	
		cartPage.recalculate();
		
		
		// STEP 7 : PAYMENT
		logger.info("GO TO PAYMENT");
		cartPage.goToPayment();
	}

}
