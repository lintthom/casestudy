package elearning_stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Elearning_definition {

	WebDriver driver;
	

		@Given("user is in registration page")
		public void user_is_in_registration_page() {
			  
		    System.setProperty("webdriver.chrome.driver","C:\\Users\\LintoThomas\\Desktop\\Linto Archive W10\\Automation\\chromedriver.exe");
			 
			  driver = new ChromeDriver();
			  
			  driver.get("http://elearningm1.upskills.in/"); 
			  driver.findElement(By.xpath("//a[contains(text(),' Sign up! ')]")).click();
			  	  
		}


		
		@Given("user enters firstname {string}")
		public void user_enters_firstname(String Fname) {
		    driver.findElement(By.id("registration_firstname")).sendKeys(Fname);
		}
		@Given("user enters lastname {string}")
		public void user_enters_lastname(String Lname) {
		   driver.findElement(By.id("registration_lastname")).sendKeys(Lname);
		}
		@Given("user enters e-mail id {string}")
		public void user_enters_e_mail_id(String Remail) {
		  driver.findElement(By.id("registration_email")).sendKeys(Remail);
		}
		@Given("user enters username {string}")
		public void user_enters_username(String Username) {
		  driver.findElement(By.id("username")).sendKeys(Username);
		}
		@Given("user enters password {string}")
		public void user_enters_password(String Password) {
		  driver.findElement(By.id("pass1")).sendKeys(Password);
		}
		@Given("user confirms the password {string}")
		public void user_confirms_the_password(String Cpassword) {
		   driver.findElement(By.id("pass2")).sendKeys(Cpassword);
		}
		@When("user clicks on register button")
		public void user_clicks_on_register_button() {
			
		  driver.findElement(By.id("registration_submit")).click();
		}
		@Then("user sees the confirmation message {string}")
		public void user_sees_the_confirmation_message(String LoginName) {
			driver.findElement(By.className("dropdown-toggle")).click();
			String Expected = LoginName;
			String Actual = driver.findElement(By.className("name")).getText();
			System.out.println();
		       Assert.assertEquals(Expected, Actual);
		       System.out.println("User registration completed succesfully");
		}
		@Then("user navigates to HomePage")
		public void user_navigates_to_home_page() throws InterruptedException {
		   driver.findElement(By.xpath("//a[@title='Homepage']")).click();
		   driver.findElement(By.className("dropdown-toggle")).click();
		   driver.findElement(By.xpath("//a[@title='Inbox']")).click();
		   Thread.sleep(3000);
		}
		@Then("user click on compose")
		public void user_click_on_compose() {
		   driver.findElement(By.xpath("//img[@title='Compose message']")).click();
		   
		}
		@Then("user enters recipient email {string}")
		public void user_enters_recipient_email(String Remail) throws InterruptedException {
		  driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Remail);
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//li[contains(@class,'option--highlighted')]")).click();
		}
		@Then("user enters subject {string}")
		public void user_enters_subject(String Subject) {
		  driver.findElement(By.id("compose_message_title")).sendKeys(Subject);
		}
		@Then("user enters enters message")
		public void user_enters_enters_message() throws InterruptedException {
		 Thread.sleep(3000);
		 //river.findElement(By.xpath("//span[@class='cke_button_icon cke_button__newpage_icon']")).click();
		 driver.findElement(By.xpath("//span[@class='cke_button_icon cke_button__inserthtml_icon']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//textarea[@class='cke_dialog_ui_input_textarea ']")).sendKeys("Hi "+Keys.ENTER + "This is a system generated test email. Do not reply."+Keys.ENTER + "Thanks");
		 driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
		}
		@When("user clicks on send message button")
		public void user_clicks_on_send_message_button() {
		    driver.findElement(By.id("compose_message_compose")).click();
		}
		@Then("user sees success message {string}")
		public void user_sees_success_message(String SMessage) throws InterruptedException {
			String Expected = SMessage;
			String Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			if(Actual.contains(Expected)) {
				System.out.println("Email is sent successfully!!");
				Thread.sleep(5000);
			}
			else
			{
				System.out.println("Email was not sent");
			}
		}
		@When("user tries to logout")
		public void user_tries_to_logout() {
			driver.findElement(By.xpath("//img[@class='img-circle']")).click();
			driver.findElement(By.id("logout_button")).click(); 
		}
		@Then("user is logged out")
		public void user_is_logged_out() {
			if(driver.findElement(By.xpath("//a[@title='Homepage']")).isDisplayed()) {
		    	System.out.println("User is successfully logged out");
		    	driver.close();
		    	System.out.println("Done1");
		    }
		}
		




}
