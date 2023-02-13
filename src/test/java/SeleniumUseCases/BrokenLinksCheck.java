package SeleniumUseCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinksCheck {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaril\\Selenium\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://automation.techleadacademy.io/#/");


        /**
         * Broken links are links or URLs that are not reachable. They may be down or not
         * functioning due to some server error. To find broken links using selenium it means we
         * need to check the link which is pointing to the wrong URL or invalid URL.
         * A URL will always have a status with 2xx which is valid. There are different HTTP
         * status codes which are having different purposes. For an invalid request, HTTP status is
         * 4xx and 5xx.
         * Some of the HTTP status codes:
         * 200 – Valid Link
         * 404 – Link not found
         * 400 – Bad request
         * 401 – Unauthorized
         * 500 – Internal Error
         *
         * While doing validation you only have to verify status
         * 200- Success - ok
         *
         * Steps to find broken links:
         * ● Collect all the links from the webpage. All the links are associated with the Tag ‘a‘.
         * ● Create a list of type WebElement to store all the Link elements in it.
         * ● Now Create a Connection using URL object( i.e ., link)
         * ● Connect using the Connect Method.
         * ● Use getResponseCode () to get response code. e.g. 200
         */


        List<WebElement> list = driver.findElements(By.xpath("//a[@class='link']"));
        for (int i = 0; i < list.size(); i++) {
            String linkURL = list.get(i).getAttribute("href");
            if (linkURL != null) {
                URL obj = new URL(linkURL);
                HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
                try {
                    int statusCode = conn.getResponseCode();
                    if (statusCode == 200) {
                        System.out.println(linkURL + " is valid " + statusCode);
                    } else {
                        System.out.println(linkURL + " is invalid " + statusCode);
                    }
                } catch (Exception e) {
                    System.out.println(linkURL + " connection error, can't retrieve status code");
                    continue;
                    // we continue with the process if we get a connection errors, to finish analyzing other links
                }
            }
        }
    }
}
