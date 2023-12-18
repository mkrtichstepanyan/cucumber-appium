package org.example.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.example.utils.Utils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private AppiumDriver driver = null;
    private Properties properties;
    AppiumDriverLocalService service;

    public DriverFactory() {
        this.properties = Utils.loadProperties();
    }

    public void setUpDriver() {
        String platformName = properties.getProperty("platformName");
        if (platformName.equalsIgnoreCase("Android")) {
            setUpAndroidDriver();
        } else {
            setUpIOSDriver();
        }
    }

    public void setUpAndroidDriver() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Android SDK built for x86_64");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "13");

        cap.setCapability("appPackage", "com.vlume.dev");
        cap.setCapability("appActivity", ".SplashActivity");
        cap.setCapability("app", "/Users/Mkrtich_Stepanyan/Desktop/app-release.apk");
        cap.setCapability("automationName", "uiautomator2");
//        cap.setCapability(CapabilityType.TIMEOUTS,10000);

        if (this.driver == null) {
            try {
                this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Application was started");
    }

    public void setUpIOSDriver() {
//        XCUITestOptions options = new XCUITestOptions();
//        options.setPlatformName(properties.getProperty("platformName"));
//        options.setPlatformVersion(properties.getProperty("platformVersion"));
//        options.setDeviceName(properties.getProperty("deviceName"));
//        options.setApp(properties.getProperty("app"));
//        if (this.driver == null) {
//            try {
//                this.driver = new AndroidDriver(new URL(properties.getProperty("platformVersion")), options);
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
//        }
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
