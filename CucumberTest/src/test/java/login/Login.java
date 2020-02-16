package login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class Login {
    WebDriver driver = null;

    @Given("^navigate to login page$")
    public void goToLogin(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @When("^I enter username as (.*)$")
    public void enterUsername(String arg1){
        driver.findElement(By.id("username")).sendKeys(arg1);
    }

    @When("^I enter password as (.*)$")
    public void enterPassword(String arg1){
        driver.findElement(By.id("password")).sendKeys(arg1);
        driver.findElement(By.cssSelector(".radius")).click();
    }

    @Then("^login should pass$")
    public void checkPass(){
        assertTrue(driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"));
        System.out.println("login pass!");
        driver.close();
    }

    @Then("^login should fail")
    public void checkFail(){
        assertTrue(driver.findElement(By.id("flash")).getText().contains("Your username is invalid!"));
        System.out.println("login fail!");
        driver.close();
    }
}
