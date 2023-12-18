package org.example.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.example.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory1 {
    Logger logger = LoggerFactory.getLogger(DriverFactory1.class);
    private AppiumDriver driver = null;
    private Properties properties;
    AppiumDriverLocalService service;

    public DriverFactory1() {
        this.properties = Utils.loadProperties();
    }

    public void setUpDriver() {
        String platformName = properties.getProperty("platformName");
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        if (platformName.equalsIgnoreCase("Android")) {
            setUpAndroidDriver();
            System.out.println("asd");
        } else {
            setUpIOSDriver();
        }
    }

    public void setUpAndroidDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(properties.getProperty("platformName"));
        options.setPlatformVersion(properties.getProperty("platformVersion"));
        options.setAppPackage(properties.getProperty("packageName"));
        options.setDeviceName(properties.getProperty("deviceName"));
        options.setApp(properties.getProperty("app"));

        if (this.driver == null) {
            try {
                this.driver = new AndroidDriver(new URL(properties.getProperty("platformVersion")), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setUpIOSDriver() {

        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName(properties.getProperty("platformName"));
        options.setPlatformVersion(properties.getProperty("platformVersion"));
        options.setDeviceName(properties.getProperty("deviceName"));
        options.setApp(properties.getProperty("app"));
        if (this.driver == null) {
            try {
                this.driver = new AndroidDriver(new URL(properties.getProperty("platformVersion")), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public AppiumDriver getDriver() {
        return this.driver;
    }

    public void setImplicitWait(int seconds) {
        this.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }


    public void closeDriver() {
        service.stop();
        if (this.driver != null) {
            driver.quit();
        }
        this.driver = null;
    }
}
