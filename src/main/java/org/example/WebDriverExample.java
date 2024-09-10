package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverExample {

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Page Tittle is: "+driver.getTitle());
        Assert.assertEquals("Amazon.com. Spend less. Smile more.",driver.getTitle());

        driver.findElement(By.id("twotabsearchtextbox")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 15");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> list=driver.findElements(By.xpath("//span[contains(text(),'iPhone 15')]//parent::a"));
        for(WebElement e:list){
            System.out.println(e.getText());
        }
        driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 15, 128GB, Black - Unlocked (Renewed)')]//parent::a")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals("Apple iPhone 15, 128GB, Black - Unlocked (Renewed)",driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone 15, 128GB, Black - Unlocked (Renewed)')])[1]")).getText());


    }
}
