package iframe;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Iframe {
    WebDriver driver = null;

    @Given("^navigate to iframe page$")
    public void toToIframe(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @When("clear the original context and input new context as \"(.*)\"$")
    public void editTheContext(String input){
        //switch to the iframe
        driver.switchTo().frame("mce_0_ifr");
        //clear the original context
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys(input);
        //switch back to the main page
        driver.switchTo().parentFrame();
    }

    @When("^change the context format$")
    public void editTheFormat(){
        driver.findElement(By.id("mceu_6")).click();
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.id("tinymce")).sendKeys(Keys.CONTROL,"a");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("mceu_3")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("^check the context$")
    public void checkTheContext(){
        driver.switchTo().frame("mce_0_ifr");
        assertEquals(driver.findElement(By.id("tinymce")).getText(),"Hello Word!");
        driver.switchTo().parentFrame();
        driver.close();
    }
}
