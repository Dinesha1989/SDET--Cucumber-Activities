package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;



public class LoginTestSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given ("^User is on Login page$")
	public void loginPage() {
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	
	@When ("^User enters username and password$")
	public void login() {
		
		driver.findElement(By.name("Username")).sendKeys("admin");
		driver.findElement(By.name("Password")).sendKeys("password");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@When ("^User enters \"(.*)\" and \"(.*)\"$")
	public void loginwithparameterization(String Username, String Password) {
		
		driver.findElement(By.name("Username")).sendKeys(Username);
		driver.findElement(By.name("Password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	
	@Then ("^Read the page title and confirmation message$")
	public void getTitle() {
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
		String Title = driver.getTitle();
		String LoginMessage = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Title of the page is: "+Title);
		System.out.println("Login message is: "+LoginMessage);
		
        if(LoginMessage.contains("admin")) {
        	
            Assert.assertEquals(LoginMessage, "Welcome Back, admin");
	
        } else {
	
            Assert.assertEquals(LoginMessage, "Invalid Credentials");
	
        }
	}
	
	@And ("^Close the Browser$")
	public void closeBrowser() {
		driver.close();
	}
}
