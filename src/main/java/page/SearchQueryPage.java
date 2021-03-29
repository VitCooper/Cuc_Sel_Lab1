package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.TestConf;

public class SearchQueryPage extends PageObjects{
//    private static final TestConf TEST_CONF = TestConf.get();
    public static final String GOOGLE_COM = "www.google.com";
    private WebDriver driver;

    @FindBy(css = "input[name=q]")
    WebElement query;

    @FindBy(css = "input[value=\"Google Search\"]")
    WebElement searchButton;

    @FindBy(css = "input[value=\"I'm Feeling Lucky\"]")
    WebElement luckyButton;


    /*
    java.lang.NoClassDefFoundError: Could not initialize class page.SearchQueryPage

	at tests.SearchSteps.A_Google_search_page(SearchSteps.java:44)
	at ✽.Given A Google search page(search.feature:17)

Test ignored.
       */


//    public static SearchQueryPage loadUsing(WebDriver driver) {
//
//        driver.get(TEST_CONF.getSearchUrl());
//        return new SearchQueryPage(driver);
//    }

    public SearchQueryPage setQuery(String term) {
        query.clear();
        query.sendKeys(term);
        return this;

    }

    public SearchQueryPage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, TEST_CONF.getAjaxWaitSeconds()), this);
        PageFactory.initElements(driver,this);
    }

    public SearchResultPage pressEnterInQuery() {
        query.sendKeys("\n");
        return new SearchResultPage(driver);

    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();
        return new SearchResultPage(driver);

    }

    public SearchResultPage clickLuckyButton() {
        luckyButton.click();
        return new SearchResultPage(driver);

    }

    public void openMainPage(){
        super.goToUrl(GOOGLE_COM);
    }

}
