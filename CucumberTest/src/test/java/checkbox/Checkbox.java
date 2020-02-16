package checkbox;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Checkbox {
    WebDriver driver = null;
    @Given("^navigate to the checkbox page$")
    public void goToCheckbox(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @When("^click the checkbox$")
    public void clickCheckbox(DataTable boxNumber){
        List<List<String>> box = boxNumber.raw();
        List<WebElement> checkboxes = driver.findElement(By.id("checkboxes")).findElements(By.tagName("input"));
        int index = Integer.parseInt(box.get(0).get(0));
        checkboxes.get(index).click();
    }

    @Then("^the box is selected$")
    public void checkTheBoxSelected(){
        assertTrue(driver.findElement(By.id("checkboxes")).findElements(By.tagName("input")).get(0).isSelected());
        driver.close();
    }
}
