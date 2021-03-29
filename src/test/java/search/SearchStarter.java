package search;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        //src/test/resources/search/search.feature
        //C:\Luxoft\2021\projects\Google_Habr\src\test\resources\search\search.feature
        features = "src/test/resources/search",
// error in the next line = cucumber.api.PendingException: TODO: implement me
//        glue = "src.test.java.search",
        tags = "@search1",
//        dryRun = false,
        strict = true,
        monochrome = true
//        snippets = CucumberOptions.SnippetType.CAMELCASE,
//        plugin = {
//                "json:target/cucumber3.json",
//                "pretty",
//                "html:target/cucumber-reports/cucumber-pretty.html",
//        }
)


public class SearchStarter {
}
