package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ResourcesUtils;

public class BaseTest {

    @Step("Set Up Browser")
    @BeforeMethod
    public void setUp() throws Exception {
        Selenide.open(ResourcesUtils.getResources("configs","mainUrl"));
        Configuration.timeout = Long.parseLong(ResourcesUtils.getResources("configs","timeout"));
       // Configuration.holdBrowserOpen = true;

    }

    @Step("Tear Down Browser")
    @AfterMethod
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
