package bdd.step;

import bdd.page.SearchProductPage;

public class SearchProductStep {

    public void stepLaunchBrowser(String url){
        searchProductPage().launchBrowser(url);
    }


    public SearchProductPage searchProductPage(){
        return new SearchProductPage();
    }

    public void stepClickOnSearch(){
        searchProductPage().clickOnSearchInput();
    }

    public void stepTypeProductName(String txtProduct){
        searchProductPage().typeProductName(txtProduct);
    }

    public void stepClickOnSearchBtn(){
        searchProductPage().clickOnSearchBtn();
    }

    public String stepValidateResult(){
        return searchProductPage().validateResult();
    }
}
