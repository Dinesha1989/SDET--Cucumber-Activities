package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AlertSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	Alert alert;

	@Given ("^User is on the page$")
	public void useronPage() {
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);	
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		
	}
	
	@When ("^User clicks the Simple Alert button$")
	public void clicksSimpleAlert() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("simple")).click();
	}
	
	@When ("^User clicks the Confirm Alert button$")
	public void clickConfirmAlert() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("confirm")).click();
		
	}
	
	@When ("^User clicks the Prompt Alert button$")
	public void clickPromptAlert() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("prompt")).click();
		
	}
	
	@Then ("^Alert opens$")
	public void openAlert() {
		
		alert = driver.switchTo().alert();
		
	}
	
	@And ("^Read the text from it and print it$")
	public void readText() {
		
		String alertText = alert.getText();
		System.out.println("Alert text is: "+ alertText);
		
	}
	
	@And ("^Write a custom message in it$")
	public void writeText() {
		
		alert.sendKeys("This is test message");
	}
	
	@And ("^Close the alert$")
	public void closeAlert() {
		alert.accept();
		
	}
	
	@And ("^Close the alert with Cancel$")
	public void closeAlertCancel() {
		
		alert.dismiss();
	}
	
	/*@And ("^Read the result text$")
	public void readResult() {
		
		driver.findElement(By.id("result")).getText();
		
	}
	*/
	
	@And ("^Close Browser$")
	public void closeBrowser() {
		
		driver.close();
	}
}
