package Testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Feature/Purchase_product.feature"},
        glue = {"Stepdef"},
        plugin = {"json:target/cucumber.json"})
public class TestRunner {

}
