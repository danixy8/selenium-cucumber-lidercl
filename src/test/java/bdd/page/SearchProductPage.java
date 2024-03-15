package bdd.page;

import bdd.webdriver.DOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchProductPage extends DOM {

    @FindBy(css = "input[type='search'].ais-SearchBox-input")
    protected WebElement txtSearch;

    @FindBy(css = "button.ais-SearchBox-submit.search-input-icons")
    protected WebElement btnSearch;

    @FindBy(xpath = "//h2[contains(@class, 'product-description')]//span[contains(@style, 'font-weight: bold; color: rgb(0, 0, 0);')]")
    protected WebElement resultSearchItem;



    public void launchBrowser(String url){
        startBrowser(url);
    }

    public void clickOnSearchInput(){
        onClick(txtSearch);
    }

    public void typeProductName(String txtProduct){
        type(txtSearch, txtProduct);
    }

    public void clickOnSearchBtn(){
        onClick(btnSearch);
    }

    public String getTextOfFirstResult() {
        Wait<WebDriver> wait = new WebDriverWait(webDriver(), Duration.ofSeconds(2));
        wait.until(d -> resultSearchItem.isDisplayed());
        System.out.println("resultado" + resultSearchItem.getText());
        return getText(resultSearchItem);
    }

    public String validateResult() {
        return getTextOfFirstResult();
    }

}
