package hover;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Hover {
    WebDriver driver = null;
    WebElement figure =  null;


    @Given("^navigate to Hover Page$")
    public void goToHover(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");
    }

    @When("^I hover on \"(.*)\" image$")
    public void hoverOverImage(String number){
        //WebElement figure = driver.findElements(By.className("figure")).get(0);
        Actions actions = new Actions(driver);
        switch (number){
            case "first" :
                figure = driver.findElements(By.className("figure")).get(0);
                actions.moveToElement(figure).perform();
                break;
            case "second" :
                figure = driver.findElements(By.className("figure")).get(1);
                actions.moveToElement(figure).perform();
                break;
            case "third" :
                figure = driver.findElements(By.className("figure")).get(2);
                actions.moveToElement(figure).perform();
                break;
            default :
                System.out.println("no matched input!");
        }
        //WebElement figure = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));

    }

    @Then("^show title \"(.*)\"$")
    public void checkHoverTitle(String user){
        assertEquals("Caption title is incorrect",figure.findElement(By.className("figcaption")).findElement(By.tagName("h5")).getText(),"name: " + user);
        //assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText(),"name: user1"); cannot user xpath to find hover hidden web element
    }

    @Then("^show link \"(.*)\"$")
    public  void checkHoverLink(String link){
        assertTrue("Caption link is incorrect",figure.findElement(By.className("figcaption")).findElement(By.tagName("a")).getAttribute("href").endsWith(link));
        assertEquals("Caption link text is incorrect",figure.findElement(By.className("figcaption")).findElement(By.tagName("a")).getText(),"View profile");
        driver.close();
    }



}
