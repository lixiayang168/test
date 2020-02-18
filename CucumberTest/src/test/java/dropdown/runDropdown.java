package dropdown;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/feature/dropdown.feature"},
        tags = {"@SmokeTest,@RegressionTest"}
)

public class runDropdown {
}
