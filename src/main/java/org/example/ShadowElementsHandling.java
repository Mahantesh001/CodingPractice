package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShadowElementsHandling {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        driver.get("https://testautomationcentral.com/demo/shadow_dom.html?utm_source=chatgpt.com");

        // Normal xpath will not work for Shadow Elements
        // WebElement shadowElement= driver.findElement(By.xpath("//div[@class='shadow-box']//p"));

        // Handling Shadow Element
        WebElement shadowHost = driver.findElement(By.cssSelector("#shadow-host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowElement = shadowRoot.findElement(By.cssSelector("div[class=shadow-box]"));
        String shadowElementText = shadowElement.getText();
        System.out.println(shadowElementText);
        driver.quit();
    }
}
