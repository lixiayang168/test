package sendemail;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;

public class SendEmailTest extends BaseTest {

    @Test
    public void testSendEmail(){
        ForgotPasswordPage forgotPasswordPage =homePage.clickForgotPassword();
        forgotPasswordPage.setEmailField("yanglixia@gmail.com");
        EmailSentPage emailSentPage = forgotPasswordPage.clickRetrieveButton();
        assertEquals(emailSentPage.getContent(),"Your e-mail's been sent!","send email success");
    }

}
