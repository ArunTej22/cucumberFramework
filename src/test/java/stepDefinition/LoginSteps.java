package stepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	WebDriver driver;
		
	@Given("^User launch orangehrm url$")
	public void user_launch_orangehrm_url() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://orangehrm.qedgetech.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	}

	@When("^User enter username And User enter password$")
	public void user_enter_username_And_User_enter_password() throws Throwable {
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Qedge123!@#");
		
	}

	@When("^user clicks login button$")
	public void user_clicks_login_button() throws Throwable {
		driver.findElement(By.cssSelector("#btnLogin")).click();
	}

	@Then("^user validate url$")
	public void user_validate_url() throws Throwable {
	    String expected ="dashboard";
	    String actual =driver.getCurrentUrl();
	    if(actual.contains(expected)) 
	    {
	    	System.out.println("login success");	    	
	    }
	    else 
	    {
	    	System.out.println("login fail");
	    }
	}
	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
		driver.close();
	}

}
