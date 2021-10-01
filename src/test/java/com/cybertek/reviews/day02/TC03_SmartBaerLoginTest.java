package com.cybertek.reviews.day02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC03_SmartBaerLoginTest {
    public static void main(String[] args) {
        /*
        Basic login authentication
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Verify title equals: String expectedTitle = "Web Orders Login"
- Enter username: Tester
- Enter password: test
- Click “Sign In” button
- Verify title equals: String expectedHomePageTitle = "Web Orders"
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String expectedTitle = driver.getTitle();

        WebElement username=driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password=driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement login= driver.findElement(By.id("ctl00_MainContent_login_button"));
        login.click();
        String actualTitle= driver.getTitle();
        if(actualTitle.equalsIgnoreCase("Web Orders")){
            System.out.println("pass");
            System.out.println("expected: " + expectedTitle);
            System.out.println("actual:" + actualTitle);
        }else{
            System.out.println("fail");
            System.out.println("expected: " + expectedTitle);
            System.out.println("actual" + actualTitle);
        }

        driver.quit();





    }
}
