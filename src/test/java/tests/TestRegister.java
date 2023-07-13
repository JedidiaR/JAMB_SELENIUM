package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pages.PageShop;

public class TestRegister extends RunTest {
	
	@Test
	public void registerTest() {
		
		PageShop home = new PageShop(RunTest.driver);
		home.getNavBar().clickAccount();
		logger.info("STEP 1 : CLICK ACCOUNT");
		assertTrue("ERROR REGISTER LINK NOT DISPLAYED", home.getNavBar().getRegister().isDisplayed());
		logger.info("STEP 1 ASSERT DONE");
		
		home.getNavBar().clickRegister();
		
	}

}
