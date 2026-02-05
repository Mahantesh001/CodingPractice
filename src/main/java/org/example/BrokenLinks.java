package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/broken-links/?utm_source=chatgpt.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));

        int noOfBrokenLinks = 0;
        int noOfValidLinks = 0;
        int noOfLinks = links.size();
        System.out.println("Total number of links on webpage = " + noOfLinks);

        for (WebElement link : links) {
            String linkString = link.getAttribute("href");
            if (linkString == null || linkString.isBlank()) {
                System.out.println("This link can not be checked whether it is broken link or valid link");
                continue;
            }
            try {
                URL url = new URL(linkString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                int statusCode = connection.getResponseCode();

                if (statusCode >= 400) {
                    System.out.println("This is broken link ======> " + linkString + " & Status code = " + statusCode);
                    noOfBrokenLinks++;
                } else {
                    System.out.println("This is valid link ======> " + linkString + " & Status code = " + statusCode);
                    noOfValidLinks++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Number of broken links = " + noOfBrokenLinks);
        System.out.println("Number of valid links = " + noOfValidLinks);
        int noOfBlankHrefAttValueLinks = noOfLinks - (noOfBrokenLinks + noOfValidLinks);
        System.out.println("Number of links for which href attribute don't have any value = " + noOfBlankHrefAttValueLinks);
        driver.quit();
    }
}
