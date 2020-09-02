package cucumber.examples.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class) -- junit run
@CucumberOptions(
//        glue = {"cucumber.examples.stepdefinitions"},
        glue = {"cucumber.examples.stepdefinitions","cucumber.examples.typeregistry","cucumber.examples.hooks"},
        features = "src/test/resources/features")
public class RunTest extends AbstractTestNGCucumberTests {
}
