package habrahabr.reading;


//import io.cucumber.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//path = src/test/resources/Habrahabr/reading/feed.feature
//cucumber.runtime.CucumberException: Error parsing feature file Habrahabr/reading/feed.feature
// it was because @web Scenarion were on the one line
@CucumberOptions(format = "junit:target/junit.xml", features = "src/test/resources")
//@CucumberOptions( features = "src/test/resources")

public class FeedStarter {


}
