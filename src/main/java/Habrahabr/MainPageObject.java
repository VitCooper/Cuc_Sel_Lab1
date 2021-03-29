package Habrahabr;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import search.SearchResultPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPageObject extends PageObject {

    private static final String HABR_COM_RU = "https://habr.com/ru/";
    @FindBy(className = "posts_list")
    private WebElement postsList;

    @FindBy(xpath = "//*/article")
    private List<WebElement> articleList;
    
    
    public MainPageObject(WebDriver driver) {
        super(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }

    public boolean postsListExist(){
        return postsList != null && postsList.isDisplayed();
    }


//    public void goToUrl(String url){
//        driver.get(url);
//    }


    public short getArticleCount() {
        return (short) articleList.size();
    }

    public void openMainPage(){
        super.goToUrl(HABR_COM_RU);
    }
    public void openPathInMainPage(String path, String subPath) {
        super.goToUrl(HABR_COM_RU + path + subPath + "/");
    }


}

