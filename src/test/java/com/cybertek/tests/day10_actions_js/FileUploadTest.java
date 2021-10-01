package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        // driver.quit();
    }
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/upload");
        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));
        //sending file with sendKeys method
        chooseFile.sendKeys("C:\\Users\\kubra\\Desktop\\file1.txt");

        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is file.txt
        Assert.assertEquals(actualFileName, "file1.txt");
    }

    @Test //dynamic way, bilgisayar masaustune bagli degil!
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");
        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));
        //sending file with sendKeys method
        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/textfile.txt";//java ile ayni sirada olusturdugumuz dosya ismine sag tikla, src ile baslayani kopyala
        String fullPath=projectPath+"/"+filePath;
        chooseFile.sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is file.txt
        Assert.assertEquals(actualFileName, "textfile.txt");



    }


}
