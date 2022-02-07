package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginstepsMultidata {
	WebDriver driver;
	String url ="http://orangehrm.qedgetech.com";

	@Given("^user launch orangehrm url in \"([^\"]*)\"$")
	public void user_launch_orangehrm_url_in(String brw) throws Throwable {
		if (brw.equalsIgnoreCase("chrome")) 
		{
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);			
		} 
		else
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		}
	   
	}

	@When("^user enter \"([^\"]*)\" in username$")
	public void user_enter_in_username(String username) throws Throwable {
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys(username);;
	    
	}

	@When("^user enter \"([^\"]*)\" in password$")
	public void user_enter_in_password(String password) throws Throwable {
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
	   
	}

	@When("^user click login$")
	public void user_click_login() throws Throwable {
		driver.findElement(By.cssSelector("#btnLogin")).click();
	}

	@Then("^user validate login url$")
	public void user_validate_login_url() throws Throwable {
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
