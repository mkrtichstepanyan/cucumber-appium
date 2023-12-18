package org.example.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.helpers.WaitHelper;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {
    protected AppiumDriver driver;
    WaitHelper waitHelper;

    private final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public abstract void pageIsOpened();
}
