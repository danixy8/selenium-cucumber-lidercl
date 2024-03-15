package bdd.webdriver;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DOM {

    static String screenshotDir = "/Users/danielgutierrez/Documents/selenium_projects/Mi_Primer_Script_Web/src/test/resources/evidence/";

    public static WebDriver webDriver () {
        return WebDriverFactory.getWebDriver();
    }

    public DOM() {
        PageFactory.initElements(webDriver(), this);
    }

    public static void startBrowser(String url){
        webDriver().get(url);
        webDriver().manage().window().maximize();
    }

//    public static void takeScreenShot(String fileName){
//        File screenshotFile = ((TakesScreenshot)webDriver()).getScreenshotAs(OutputType.FILE);
//        String destinationPath = screenshotDir + fileName + ".png";
//
//        try {
//            FileUtils.copyFile(screenshotFile, new File(destinationPath));
//            System.out.println("captura de pantalla tomada con exito");
//        } catch (IOException e) {
//            System.out.println("Ha ocurrido un error al guardar la captura de pantalla");
//            throw new RuntimeException(e);
//        }
//    }

    public void takeScreenShot(Scenario scenario){
        try {
            String screenshotName = "screenshot_" + UUID.randomUUID() + ".png";
            final byte[] screenshot = ((TakesScreenshot) webDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClick(WebElement element){
        element.click();
    }

    public void type(WebElement element, String text){
        element.sendKeys(text);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void quitDriver(){
        webDriver().quit();
    }
}
