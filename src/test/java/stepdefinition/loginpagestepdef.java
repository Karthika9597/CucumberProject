package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageexeabs.BookHotelexe;

public class loginpagestepdef extends BookHotelexe{
	
	@Given("User Enters the URL")
	public void user_enters_the_url() {  
		selectingBrowser("chrome"); 
		launching(propReader("url")); 
	}
	@When("User enters the username and password and clicks login button {string} {string}")
	public void user_enters_the_username_and_password_and_clicks_login_button(String username, String password) {
	    username();
	   password();   
	    login();
	    } 
	@Then("validate the home page title")
	public void validate_the_home_page_title() {
		String expectedTitle="https://adactinhotelapp.com/SearchHotel.php";
		String ActualTitle=getTitle();
		Assert.assertEquals(expectedTitle, ActualTitle);
	   
	} 



	}


