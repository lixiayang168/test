package dropdown;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class Dropdown {
    WebDriver driver=null;

    @Given("^open dropdown page$")
    public void open_dropdown_page(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @When("^select option 1$")
    public void select_option_1(){
        Select dropdownElement =  new Select(driver.findElement(By.id("dropdown")));
        dropdownElement.selectByValue("1");
    }

    @Then("^option 1 is selected$")
    public void option_1_is_selected(){
        Select dropdownElement =  new Select(driver.findElement(By.id("dropdown")));
        assertEquals(dropdownElement.getFirstSelectedOption().getText(),"Option 1");
        driver.close();
    }

    @When("^select option 2$")
    public void select_option_2(){
        Select dropdownElement =  new Select(driver.findElement(By.id("dropdown")));
        dropdownElement.selectByVisibleText("Option 2");
    }

    @Then("^option 2 is selected$")
    public void option_2_is_selected(){
        Select dropdownElement =  new Select(driver.findElement(By.id("dropdown")));
        assertEquals(dropdownElement.getFirstSelectedOption().getText(),"Option 2");
        driver.close();
    }
}
