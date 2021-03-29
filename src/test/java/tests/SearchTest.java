package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Before;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    //@CucumberOptions(format = "junit:target/junit.xml")
    @CucumberOptions(format = "junit:target/junit.xml", features = "src/test/resources")


    public class SearchTest {

}
