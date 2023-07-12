package jamb_group;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jamb_group.OutilTechnique.ENavigateur;

public class RunTest {
	
	WebDriver driver;
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void first() {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.get("http://localhost:8080/shopizer/shop?locale=fr");
		logger.info("GO TO LANDING PAGE : " + driver.getTitle());
//		System.out.println(driver.getTitle());
		
		// STEP 2 : GET RANDOM ITEM TO ADD TO CART
		// CHANGE div[1] to div[2] or more to chose other item
		PageShop pageShop = new PageShop(driver);
		pageShop.addItem();
		logger.info("ADD ITEM TO CART");
		// STEP 2 DONE
		
		// STEP 3 : CLICK TO 'panier d achat'
		// => //div[3]/div[2]/div[1]/a
		pageShop.recapCart();
		logger.info("CART RECAP");
		CartPage cartPage = pageShop.goToCartPage();
		logger.info("GO TO CART PAGE");
		
		
		// STEP 4 : TO DO
		logger.info("STEP 4 TO DO");
		
		// STEP 5 : DOUBLE QUANTITY OF CHOSEN ITEM IN CART PAGE
		// => //td[2]/input
		
		// STEP 6 : RECALCULATE BUTTON
		// => //div[2]/div[1]/div/a[1]
		
		// STEP 7 : PAYMENT
		// => //div[2]/a
	}

}
