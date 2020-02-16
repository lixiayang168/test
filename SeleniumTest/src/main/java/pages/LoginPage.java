package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By userNameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("#login > button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecurePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecurePage(driver);
    }

}
