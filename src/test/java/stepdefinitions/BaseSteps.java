package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.example.driver.DriverFactory;

public class BaseSteps {

    public static DriverFactory driverFactory;

    @BeforeAll
    public static void setup() {
        driverFactory = new DriverFactory();
        driverFactory.setUpDriver();
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After All");
    }
}
