package org.testng.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNgExample {
    WebDriver driver;
    @BeforeTest
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");

    }
    @Test
    public void searchForAProduct(){
        driver.findElement(By.id("gh-search-input")).click();
        driver.findElement(By.id("gh-search-input")).sendKeys("IPHONE 15");
        driver.findElement(By.xpath("//button[@title='submit search']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> list=driver.findElements(By.xpath("//h4[@class='sku-title']"));
        for(WebElement e:list){
            if(!e.getText().contains("iPhone 15")){
                throw new RuntimeException("Result mismatched");
            }
        }
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
