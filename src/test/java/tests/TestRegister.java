package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import pages.PageShop;
import pages.RegistrationPage;

public class TestRegister extends RunTest {
	
	private String registrationURI = "http://localhost:8080/shopizer/shop/customer/registration.html";
	
	private Map<String, String> form = new HashMap<String, String>();
	
	/**
	 * JDD
	 */
	@Before
	public void initMap() {
		form.put("firstname", "Roberto");
		form.put("lastname", "Gilberto");
		form.put("hiddenZones", "lazone");
		form.put("emailAddress", "mymail@mail.fr");
		form.put("password", "secretpwd");
//		form.put("passwordAgain", "secretpwd");
		
	}
	
	@Test
	public void registerTest() {
		
		PageShop home = new PageShop(RunTest.driver);
		home.getNavBar().clickAccount();
		logger.info("STEP 1 : CLICK ACCOUNT");
		assertTrue("ERROR REGISTER LINK NOT DISPLAYED", home.getNavBar().getRegister().isDisplayed());
		
		RegistrationPage register = home.getNavBar().clickRegister();
		assertEquals("ERROR GO TO REGISTRATION",registrationURI, driver.getCurrentUrl());
		logger.info("STEP 1 ASSERTS DONE");
		
		logger.info("STEP 2 : FILL FORM");
		register.fillForm(form);
		
	}

}
