package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.Iterator;
import java.util.List;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        driver.manage().window().setSize(new Dimension(375,812));

        homePage = new HomePage(driver);
    }

    /*
    public void testShiftingContent(){
        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 1: Menu Element")).click();
        List<WebElement> list = driver.findElements(By.tagName("li"));
        for(Iterator it = list.iterator(); it.hasNext();)  {
            System.out.println(it.next());
        }
    }*/

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    /*
    public static void main(String args[]){
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
        //baseTest.testShiftingContent();
    }*/
}
