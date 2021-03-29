package habrahabr.reading;

import Habrahabr.MainPageObject;

//import io.cucumber.java.After;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FeedSteps {
    private MainPageObject mainPage;

    @Before
    public void initMainPage(){
        mainPage = new MainPageObject(new ChromeDriver());
    }

    @Given("^opened habrahabr mainpage$")
    public void openMainPage(){
        mainPage.openMainPage();
    }

    @When("^open \"([^\"]*)\" and \"([^\"]*)\" in habrahabr$")
    public void openPathAndSubpath(String path, String subPath){
        mainPage.openPathInMainPage(path, subPath);
    }

    @Then("^feed list exists$")
    public void checkFeedListExists(){
        assertTrue(mainPage.postsListExist());
    }

    @Then("^there are at least (\\d+) articles in feed$")
    public void checkArticleCount(short articleCount){
        assertEquals(articleCount, mainPage.getArticleCount());
    }
    @After("@web")
    public void clear(Scenario scenario){
        scenario.getStatus();
        if(scenario.isFailed()) {
            //TakesScreenshot takesScreenshot
            scenario.embed(mainPage.getScreenShot(), "image/png");
            mainPage.getScreenshotAsFile();
        }
        mainPage.tearDown();
    }
}
