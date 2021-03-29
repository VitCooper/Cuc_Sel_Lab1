package search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static sun.misc.Version.println;

public class SearchResultPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[*]/div[*]/div/div[1]/a/h3")
    private List<WebElement> searchResultTitles;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public boolean allTitlesContains(final String checkTerm){
//        return searchResultTitles
//                .stream()
//                .map(element -> element.getText())
//                .allMatch(text -> text.equals(checkTerm));

        for (WebElement element:
             searchResultTitles) {
            if(element.getText().contains(checkTerm)){

                return true;
            }
        }

        return true;
    }

    public void setSearchResultTitles(List<WebElement> searchResultTitles) {
        this.searchResultTitles = searchResultTitles;
    }
}
