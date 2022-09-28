package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.AuthPage;

public class AuthPageSteps extends MainPageSteps{

    AuthPage authPage = new AuthPage();

    @Step("Enter Login [{login}]")
    public AuthPageSteps enterLogin(String login){
        authPage.enterLogin(login);
        return this;
    }

    @Step("Enter Password [{password}]")
    public AuthPageSteps enterPassword(String password){
        authPage.enterPassword(password);
        return this;
    }

    @Step("Click Submit Button")
    public AuthPageSteps clickSubmitButton(){
        authPage.clickSubmitButton();
        return this;
    }


    @Step("Check Authorization Page Is Displayed")
    public AuthPageSteps authPageIsDisplayed(){
        authPage.pageIsDisplayed();
        return this;
    }

    @Step("Check Main Page Is Displayed")
    public void mainPageIsDisplayed(){
        new MainPageSteps().mainPageIsDisplayed();
    }

    @Step("Check Alert Message")
    public void alertMessageIsDisplayed(){
        Assert.assertTrue(authPage.isDisplayedAlertMessage(), "Alert Message Not Displayed");
    }

    @Step("Check Alert Message")
    public AuthPageSteps alertMessageWrongParamIsDisplayed(){
        Assert.assertTrue(authPage.isEnabledAlertMessageWrongParam(), "Alert Message Not Enabled");
        return this;
    }

}
