package FeatureLogin.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/FeatureLogin/features",
    glue = "FeatureLogin.stepDef",
    plugin={"html:target/HTML_report.html"}
)
public class RunLogin {

}
