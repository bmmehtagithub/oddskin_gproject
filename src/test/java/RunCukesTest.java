import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".",
        glue={"com.oddsking.step_def", "com.oddsking.hooks"},
        plugin ={"pretty", "html:target/cucumber-html-report","json:target/cucumber.json","rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true,
        tags =("@Regression or @Smoke")

)
public class RunCukesTest {

}
