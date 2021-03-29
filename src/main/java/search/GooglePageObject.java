package search;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class GooglePageObject {
    private WebDriver driver;

    private static final String WEBDRIVER_CHROME_DRIVER_KEY = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER = "C:\\Temp\\chromedriver.exe";

    static {
        System.setProperty(WEBDRIVER_CHROME_DRIVER_KEY, WEBDRIVER_CHROME_DRIVER);
    }

    @FindBy(css = "input[name=q]")
    private WebElement searchBox;

    public GooglePageObject() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        PageFactory.initElements(driver, this);
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void enterSearchTerm(String searchTerm) {
        searchBox.sendKeys(searchTerm);
    }

    public SearchResultPage tapInSearchBox() {
        searchBox.sendKeys(Keys.ENTER);

        return new SearchResultPage(driver);
    }

    public void tearDown() {
        driver.close();
    }

    public byte[] getScreenShot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot)  driver;
        return takesScreenshot.getScreenshotAs((OutputType.BYTES) );
    }

    public void getScreenshotAsFile() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File file = takesScreenshot.getScreenshotAs((OutputType.FILE));
        System.out.println(file.getPath());

    }

}