package tests;

import org.junit.Test;

import pages.PageShop;

public class TestRegister extends RunTest {
	
	@Test
	public void registerTest() {
		
		PageShop home = new PageShop(RunTest.driver);
		home.getNavBar().clickAccount();
		
	}

}
