package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecurePage;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUserName("tomsmith");
        loginPage.setPasswordField("SuperSecretPassword!");
        SecurePage securePage = loginPage.clickLoginButton();
        String loginResult = securePage.getSuccessInfo();
        //assertEquals(loginResult,"You logged into a secure area! x","login in success");
        assertTrue(loginResult.contains("You logged into"),"login in success");



    }
}
