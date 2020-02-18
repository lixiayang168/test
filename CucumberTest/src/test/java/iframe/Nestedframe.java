package iframe;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Nestedframe {
    WebDriver driver = null;

    @Given("^navigate to the nested frame page$")
    public void goToNestedframe(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    @Then("^check the context on each frame$")
    public void checkTheContext(DataTable frameName){
        for(Map<String,String> data : frameName.asMaps(String.class,String.class)) {
            driver.switchTo().frame(driver.findElement(By.name("frame-top")));
            driver.switchTo().frame(driver.findElement(By.name("frame-left")));
            assertEquals(driver.findElement(By.xpath("/html/body")).getText(),data.get("leftframe"));
            driver.switchTo().parentFrame();
            driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
            assertEquals(driver.findElement(By.xpath("/html/body")).getText(),data.get("middleframe"));
            driver.switchTo().parentFrame();
            driver.switchTo().frame(driver.findElement(By.name("frame-right")));
            assertEquals(driver.findElement(By.xpath("/html/body")).getText(),data.get("rightframe"));
            driver.switchTo().parentFrame();
            driver.switchTo().parentFrame();
            driver.switchTo().frame(driver.findElement(By.name("frame-bottom")));
            assertEquals(driver.findElement(By.xpath("/html/body")).getText(),data.get("bottomframe"));
            driver.close();
        }

    }
}
