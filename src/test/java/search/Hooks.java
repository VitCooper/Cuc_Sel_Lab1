package search;


//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
import Habrahabr.MainPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;
    private GooglePageObject mainPage;

    @Before(value = "@search1", order = 30)
    public static void Conversation() {
        //подготовить данные
    }

    @After(value = "@search1", order = 50)
    public void makeScreenshot(Scenario scenario){
        if (scenario.isFailed()) {
            // Take a screenshot...variant is failed with error: java.lang.NullPointerException
//            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(mainPage.getScreenShot(), "image/png");
//            mainPage.getScreenshotAsFile(); // ... and embed it in the report.
            scenario.embed(mainPage.getScreenShot(), "image/png");
            mainPage.getScreenshotAsFile();

        }
        //mainPage.tearDown();
    }

}
