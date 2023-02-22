package SeleniumUseCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImageIsDisplayed {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://automation.techleadacademy.io/#/");

        ImageIsDisplayed obj = new ImageIsDisplayed();
        WebElement el = driver.findElement(By.id("selenium-img"));
        System.out.println(obj.verifyImageIsDisplayed(driver, el));
    }

    public boolean verifyImageIsDisplayed(WebDriver driver, WebElement image) {
        //if using inside framework then no need to pass driver as an argument, just a WebElement related to the image on the page
        // just use ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript(.....)
        Object result = ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && "+
                        "typeof arguments[0].naturalWidth != \"undefined\" && "+
                        "arguments[0].naturalWidth > 0", image);
        boolean loaded;
        if (result instanceof Boolean) {
            loaded = (Boolean) result;
            return loaded;
        } else {
            return false;
        }
    }
}
