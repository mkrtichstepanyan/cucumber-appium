package org.example.helpers;

import io.appium.java_client.AppiumDriver;
import org.example.pages.BasePage;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;

public final class UIHelper {

    private final AppiumDriver driver;

    private UIHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    public <T extends BasePage> T back(final Class<T> clazz) {
        driver.navigate().back();
        T page = null;
        try {
            Constructor<T> cons = clazz.getDeclaredConstructor();
            page = cons.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    public <T extends BasePage> T back(final Class<T> clazz, final WebElement back) {
        back.click();
        T page = null;
        try {
            Constructor<T> cons = clazz.getDeclaredConstructor();
            page = cons.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }
}
