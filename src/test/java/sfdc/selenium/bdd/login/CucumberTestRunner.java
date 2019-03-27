package sfdc.selenium.bdd.login;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty"} , features= "Feature", glue={"sfdc.selenium.bdd"},tags= "@loginTest")
public class CucumberTestRunner {

}
