import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",
        glue = {"stepdefinitions"},
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber-report.json"}
)

public class TestRunner {

    public static void main(String[] args) {
        int i = (int)3.2;
    }
}


