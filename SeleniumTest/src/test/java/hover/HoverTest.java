package hover;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HoverPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTest extends BaseTest {

    @Test
    public void testHover(){
        HoverPage hoverPage = homePage.clickHover();
        var caption = hoverPage.hoverOverFigure(0);
        assertTrue(caption.isCaptionDisplayed(),"Caption not displayed");
        //assertEquals(caption.getTitle(),"name: user1","Caption title is incorrect");
        //assertEquals(caption.getLinkText(),"View profile","Caption link text is incorrect");
        //don't assert the absolute address, assert the relative address
        //assertTrue(caption.getLink().endsWith("/users/1"),"Link incorrect");

    }

}
