package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.example.pages.LanguageSelectionPage;


public class LoginSteps {

    AppiumDriver driver;
    LanguageSelectionPage languageSelectionPage;

    @Before
    public void createData() {
        driver = BaseSteps.driverFactory.getDriver();
        languageSelectionPage = new LanguageSelectionPage(driver);
    }


    @Given("App is opened")
    public void appIsOpened() {
        languageSelectionPage.pageIsOpened();
    }
}
