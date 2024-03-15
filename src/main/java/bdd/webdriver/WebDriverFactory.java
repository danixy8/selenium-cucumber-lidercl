package bdd.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private static WebDriver driver;

    private WebDriverFactory() {
        // Constructor privado para evitar instanciación directa
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            initializeWebDriver();
        }
        return driver;
    }

    private static void initializeWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
    }
}