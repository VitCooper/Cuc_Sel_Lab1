package search;



import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static sun.misc.Version.println;

public class SearchSteps {
    private GooglePageObject googlePage = new GooglePageObject();
    private SearchResultPage resultPage;

    @Given("^we are on google main page$")
    public void goOnGoogleMainPage(){
        googlePage.goToUrl("https://google.com");
    }

    @When("^we enter the \"([^\"]*)\" and tap$")
    public void searchAction(String searchTerm){
        googlePage.enterSearchTerm(searchTerm);
        resultPage = googlePage.tapInSearchBox();
    }

    @Then("^we see \"([^\"]*)\" in title of page$")
    public void checkTitle(String searchResult){
        assertTrue(resultPage.getTitle().contains(searchResult));
    }

    @Then("^we see \"([^\"]*)\" in any of result in list$")
    public void checkResultList(String searchResult){
      //  assertTrue(resultPage.allTitlesContains(searchResult));

       // assertEquals(searchResult, true);
       // String realData = wait().until(visibilityOfElementLocated(By.xpath().getText();
       // Assertions.assertEquals(searchResult, realData, "Search strings");
        assertEquals(resultPage.allTitlesContains(searchResult), true);
    }

    @After
    public void clear(){
        googlePage.tearDown();
    }
}
