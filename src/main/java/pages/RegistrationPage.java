package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Helpers;

public class RegistrationPage extends AbstractPage{
	
	
	@FindBy (id = "firstName")
	private WebElement firstName;
	
	@FindBy (id = "lastName")
	private WebElement lastName;
	
	@FindBy (id = "registration_country")
	private WebElement registrationCountry;
	
	@FindBy (id = "hidden_zones")
	private WebElement hiddenZones;
	
	@FindBy (id = "emailAddress")
	private WebElement emailAddress;
	
	@FindBy (id = "password")
	private WebElement password;
	
	@FindBy (id = "passwordAgain")
	private WebElement passwordAgain;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * fill registration form
	 * @param form
	 */
	public void fillForm(Map<String,String> form) {
		Helpers.fillInput(firstName, form.get("firstname"));
		Helpers.fillInput(lastName, form.get("lastname"));
		Helpers.fillInput(hiddenZones, form.get("hiddenZones"));
		Helpers.fillInput(emailAddress, form.get("emailAddress"));
		Helpers.fillInput(password, form.get("password"));
		Helpers.fillInput(passwordAgain, form.get("password"));
	}
}
