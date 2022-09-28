package pages;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AuthPage {

    private final SelenideElement logo = $x("//div[@class='logo']");
    private final SelenideElement loginField = $(By.id("login"));
    private final SelenideElement passwordField = $(By.id("password"));
    private final SelenideElement submitButton = $x("//button[@type='submit']");
    private final SelenideElement alertMissingText = $x("//div[@role='alert']");
    private final SelenideElement wrongPasswordOrLoginAlertText = $x("//div[contains(@class,'ant-notification-bottomRight')]");

    public boolean isDisplayedAlertMessage(){
        return alertMissingText.isDisplayed();
    }

    public boolean isEnabledAlertMessageWrongParam(){
        return wrongPasswordOrLoginAlertText.isEnabled();
    }

    public boolean pageIsDisplayed(){
       return logo.shouldBe(Condition.visible).isDisplayed();
    }

    public AuthPage enterLogin(String login){
        loginField.shouldBe(Condition.visible).click();
        loginField.sendKeys(login);
        return this;
    }

    public AuthPage enterPassword(String password){
       passwordField.shouldBe(Condition.visible).click();
       passwordField.sendKeys(password);
       return this;
    }

    public void clickSubmitButton(){
        submitButton.shouldBe(Condition.visible).click();
    }
}
