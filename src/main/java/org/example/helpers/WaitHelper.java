package org.example.helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class WaitHelper {

    private AppiumDriver driver;
    private Wait<WebDriver> wait;
    private final long DEFAULT_SECONDS_TO_WAIT = 10;

    public WaitHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    public void waitForSeconds(final int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForMilliseconds(final long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement waitElementToBeClickable(final WebElement target) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_SECONDS_TO_WAIT));
        return wait.until(ExpectedConditions.elementToBeClickable(target));
    }

    public WebElement waitElementToBeClickable(final WebElement target, final int secondsToWait) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
        return wait.until(ExpectedConditions.elementToBeClickable(target));
    }

    public WebElement waitElementToBeVisible(final WebElement target) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_SECONDS_TO_WAIT));
        return wait.until(ExpectedConditions.visibilityOf(target));
    }


    public WebElement waitElementToBeVisible(final WebElement target, final int secondsToWait) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
        return wait.until(ExpectedConditions.visibilityOf(target));
    }

    public List<WebElement> waitElementsToBeVisible(final WebElement... elements) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_SECONDS_TO_WAIT));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public List<WebElement> waitElementsToBeVisible(final int secondsToWait, final WebElement... elements) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
