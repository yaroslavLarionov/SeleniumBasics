package day02;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Practicing {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://automation.techleadacademy.io/#/multiplewindow");

        driver.findElement(By.partialLinkText("Google")).click();
        System.out.println(switchWindow(driver, true).equals("Google"));

        System.out.println(driver.getTitle());

        //System.out.println(driver.getTitle().equals("TLA Automation"));

        //driver.quit();




    }

    protected static String switchWindow(WebDriver driver, boolean closeWindow) {
        String pageTitle = "";
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String each : allWindows) {
            if (!each.equals(mainWindow)) {
                if (closeWindow) {
                    driver.close();
                }
                driver.switchTo().window(each);
                pageTitle = driver.getTitle();
            }
        }
        return pageTitle;
    }
}
