package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MainPage;

public class MainPageSteps {

    private MainPage mainPage = new MainPage();

    public void mainPageIsDisplayed(){
        Assert.assertTrue(mainPage.isDisplayedPage(),"Main Page Not Displayed");
    }
}
