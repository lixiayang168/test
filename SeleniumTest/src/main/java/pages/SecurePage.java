package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {
    private WebDriver driver;
    private By successInfo = By.id("flash");

    public SecurePage(WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessInfo(){
        return driver.findElement(successInfo).getText();
    }
}
