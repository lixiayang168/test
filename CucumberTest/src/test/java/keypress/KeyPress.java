package keypress;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KeyPress {
    WebDriver driver = null;

    @Given("^navigate to the internet page$")
    public void navigate_to_the_internet_page(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @When("^click the key press link$")
    public void click_the_key_press_link(){
        driver.findElement(By.linkText("Key Presses")).click();
    }

    @When("^input keys as \"(.*)\"$")
    public void input_keys_as(String keys){
        switch (keys){
            case "SPACE":
                driver.findElement(By.id("target")).sendKeys(Keys.SPACE);
                break;
            case "SHIFT":
                driver.findElement(By.id("target")).sendKeys(Keys.SHIFT);
                break;
            case "BACK_SPACE":
                driver.findElement(By.id("target")).sendKeys(Keys.BACK_SPACE);
                break;
            default:
                System.out.println("invalid input");
        }
    }

    @Then("^show I input the \"(.*)\"$")
    public void show_what_I_input(String keys){
        assertTrue(driver.findElement(By.id("result")).getText().contains(keys));
        driver.close();
    }
}
