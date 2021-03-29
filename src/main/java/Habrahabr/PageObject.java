package Habrahabr;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class PageObject {
    private WebDriver driver;

    private static final String WEBDRIVER_CHROME_DRIVER_KEY = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER = "C:\\Temp\\chromedriver.exe";

    static {
        System.setProperty(WEBDRIVER_CHROME_DRIVER_KEY, WEBDRIVER_CHROME_DRIVER);
    }

    public PageObject(WebDriver driver) {
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
