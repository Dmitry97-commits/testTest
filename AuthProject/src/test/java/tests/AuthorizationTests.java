package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import services.ListenerAllure;
import steps.AuthPageSteps;
import utils.ResourcesUtils;

@Listeners({ListenerAllure.class})
public class AuthorizationTests extends BaseTest{

    private final AuthPageSteps authPageSteps = new AuthPageSteps();

    Faker faker = new Faker();

    @Test(priority = 1)
    @Description("Make authorization with password and login")
    public void LoginTestWithAllParams() throws Exception {
        authPageSteps
                .authPageIsDisplayed()
                .enterLogin(ResourcesUtils.getResources("configs","login"))
                .enterPassword(ResourcesUtils.getResources("configs","password"))
                .clickSubmitButton()
                .mainPageIsDisplayed();
    }

    @Test(priority = 2)
    @Description("Make authorization with password only")
    public void LoginTestWithoutLogin() throws Exception {
        authPageSteps
                .authPageIsDisplayed()
                .enterPassword(ResourcesUtils.getResources("configs","password"))
                .clickSubmitButton()
                .alertMessageIsDisplayed();

    }

    @Test(priority = 3)
    @Description("Make authorization with login only")
    public void LoginTestWithoutPassword() throws Exception {
        authPageSteps
                .authPageIsDisplayed()
                .enterLogin(ResourcesUtils.getResources("configs","login"))
                .clickSubmitButton()
                .alertMessageIsDisplayed();
    }

    @Test(priority = 4)
    @Description("Make authorization with wrong login")
    public void LoginTestWithWrongLogin() throws Exception {
        authPageSteps
                .authPageIsDisplayed()
                .enterLogin(faker.funnyName().toString())
                .enterPassword(ResourcesUtils.getResources("configs","password"))
                .clickSubmitButton()
                .alertMessageWrongParamIsDisplayed();
    }

    @Test(priority = 5)
    @Description("Make authorization with wrong password")
    public void LoginTestWithWrongPassword() throws Exception {
        authPageSteps
                .authPageIsDisplayed()
                .enterLogin(ResourcesUtils.getResources("configs","login"))
                .enterPassword(faker.internet().password())
                .clickSubmitButton()
                .alertMessageWrongParamIsDisplayed();
    }
}
