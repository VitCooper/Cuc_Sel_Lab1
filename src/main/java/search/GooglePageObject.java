package search;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}