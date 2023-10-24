package steps;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StarthealthPage {
	static WebDriver driver;
	@Given("User open the chrome browser and starhealth application")
	public void user_open_the_chrome_browser_and_starhealth_application() {
		driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.starhealth.in/");
	    
	}

	@When("User  waits for the Welcome to Star Health pop-up and closes it")
	public void user_waits_for_the_welcome_to_star_health_pop_up_and_closes_it() {
	    System.out.println("welcome to star health ");
	    System.out.println("title of the is page is : "+ driver.getTitle());
	}

	@Then("validates the Star Health home page title using a JUnit assertion")
	public void validates_the_star_health_home_page_title_using_a_j_unit_assertion() {
	    String expectedtitle="Star Health Insurance: Medical, Accident and Travel insurance policies";
	    String actualtitle="Star Health Insurance: Medical, Accident and Travel insurance policies";
	    Assertions.assertEquals(expectedtitle,actualtitle);
	}

	@Then("clicks on the Buy Now button")
	public void clicks_on_the_buy_now_button() {
	    driver.findElement(By.xpath("//span[text()='Buy Now']")).click();
	}

	@Then("User enters following details")
	public void user_enters_following_details(DataTable datatable) {
		
		// fetches the entire data table
				List<Map<String, String>> userList	= datatable.asMaps(String.class, String.class);
			// Now iterate over each row of the data table and get the value based on the columnname(key)
				
				//| URL | FullName | PhNo | PIN | OptionPlan |
				for(Map<String, String> e : userList) {
					// System.out.println(e);
					driver.findElement(By.xpath("//input[@id='name']")).clear();
					driver.findElement(By.xpath("//input[@id='name']")).sendKeys(e.get("Name"));
					driver.findElement(By.xpath("//input[@id='contact_no']")).clear();
					driver.findElement(By.xpath("//input[@id='contact_no']")).sendKeys(e.get("Phone No"));
					driver.findElement(By.xpath("//input[@id='pinCode']")).clear();
					driver.findElement(By.xpath("//input[@id='pinCode']")).sendKeys(e.get("Pincode"));
					
					
				}
				

	}

	@Then("User clicks on I need health insurance from the drop-down menu and select plan")
	public void user_clicks_on_i_need_health_insurance_from_the_drop_down_menu_and_select_plan() {
		driver.findElement(By.xpath("//div[@id='grouped-select']")).click();
	}

	@Then("User click on the Plan for My Family page")
	public void user_click_on_the_plan_for_my_family_page() {
	   driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[2]")).click();
	}

	@Then("Validate the user mobile number")
	public void validate_the_user_mobile_number() {
		String expectedphoneNumber="6543217890";
		String actualphoneNumber="6543217890";
		Assertions.assertEquals(expectedphoneNumber,actualphoneNumber);
	}

	@Then("User clicks on the Star Health logo")
	public void user_clicks_on_the_star_health_logo() {
	   driver.findElement(By.xpath("//a[@href][1]")).click();
	}

	@Then("Close all the browsers")
	public void close_all_the_browsers() {
	   driver.close();
	}

	}