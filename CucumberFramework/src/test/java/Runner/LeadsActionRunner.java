package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature/LeadsAction.feature", glue="Steps")
public class LeadsActionRunner extends AbstractTestNGCucumberTests {
}
