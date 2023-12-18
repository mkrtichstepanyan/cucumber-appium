package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LanguageSelectionPage extends BasePage {


    @AndroidFindBy(accessibility = "pickALanguage")
    @iOSXCUITFindBy(accessibility = "pickALanguage")
    private WebElement title;


    @AndroidFindBy(accessibility = "languageSelectButton0")
    @iOSXCUITFindBy(accessibility = "languageSelectButton0")
    private WebElement languageEnglish;

    @AndroidFindBy(accessibility = "languageSelectButton1")
    @iOSXCUITFindBy(accessibility = "languageSelectButton1")
    private WebElement languageEasternArmenian;


    @AndroidFindBy(accessibility = "languageSelectButton6")
    @iOSXCUITFindBy(accessibility = "languageSelectButton6")
    private WebElement languageWesternArmenian;


    @AndroidFindBy(accessibility = "welcomePage1GetStarted")
    @iOSXCUITFindBy(accessibility = "welcomePage1GetStarted")
    private WebElement continueButton;


    public LanguageSelectionPage(AppiumDriver driver) {
        super(driver);
    }


    @Override
    public void pageIsOpened() {
        waitHelper.waitElementsToBeVisible(title, languageEnglish, languageEasternArmenian, languageWesternArmenian, continueButton);
    }


}
