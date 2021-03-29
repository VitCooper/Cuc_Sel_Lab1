package search;

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "search",
//        glue = "search",
//        tags = "@tag",
//        dryRun = false,
        strict = true,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "json:target/cucumber3.json",
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
        }
)


public class SearchStarter {
}
