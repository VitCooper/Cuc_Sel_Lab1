package page;

import org.openqa.selenium.WebDriver;

public class PageObjects {

    private WebDriver driver;

    private static final String WEBDRIVER_CHROME_DRIVER_KEY = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER = "C:\\Temp\\chromedriver.exe";

    static {
        System.setProperty(WEBDRIVER_CHROME_DRIVER_KEY, WEBDRIVER_CHROME_DRIVER);
    }

    public void PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public void tearDown() {
        driver.close();

    }
}
