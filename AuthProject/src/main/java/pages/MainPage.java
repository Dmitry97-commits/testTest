package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private  SelenideElement menu = $x("//div[@class='menu']");

    public boolean isDisplayedPage(){
        return menu.shouldBe(Condition.visible).isDisplayed();
    }
}
