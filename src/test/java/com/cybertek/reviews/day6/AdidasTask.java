package com.cybertek.reviews.day6;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdidasTask {

    /*
   You have to implement the following Web automated checks over our DEMO ONLINE
   SHOP: https://www.demoblaze.com/index.html
   • Customer navigation through product categories: Phones, Laptops and Monitors
   • Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
   • Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
   • Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
   • Click on "Place order".
   • Fill in all web form fields.
   • Click on "Purchase"
   • Capture and log purchase Id and Amount.
   • Assert purchase amount equals expected.
   • Click on "Ok"
    */
    WebDriver driver;
    WebDriverWait wait;

    int expectedPurchaseAmount=0;
    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void purchaseTest(){

        String[][] purchaseInfo = new String[][]{{"Laptops","Sony vaio i5"},{"Laptops","Dell i7 8gb"},
                {"Monitors","Apple monitor 24"},{"Phones","Nexus 6"}};
        for(String[] strings : purchaseInfo){
            expectedPurchaseAmount+=productAdder(strings[0],strings[1]);
        }

        String[] unwantedProductsInfo = {"Dell i7 8gb","Apple monitor 24"};
        for (String s : unwantedProductsInfo) {
            expectedPurchaseAmount-= productRemover(s);
        }

        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);


    }

    private int productAdder(String category, String product){
        // click on any category  Laptops, Phones, Monitors
        driver.findElement(By.linkText(category)).click();
        // click on any product that I provide
        driver.findElement(By.linkText(product)).click();

        String priceText = driver.findElement(By.xpath("//h3[@class='price-container']")).getText();
        String[] arrayAmount = priceText.split(" ");
        int listPrice= Integer.parseInt(arrayAmount[0].substring(1));

        driver.findElement(By.linkText("Add to cart")).click();

        // sometimes webpage gives no such ALert exception so we are waiting dynamically
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.partialLinkText("Home")).click();

        return listPrice;
    }

    public int productRemover(String product){

        driver.findElement(By.linkText("Cart")).click();
        String productPath = "//td[.='"+product+"']"; //string concatination to get dynamically locator
        String productPricePath = productPath+"/../td[3]";
        String deletePath = productPath+"/../td[4]/a";

        // get the price of deleted product
        String priceText = driver.findElement(By.xpath(productPricePath)).getText();

        // delete the product
        driver.findElement(By.xpath(deletePath)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(productPath)));
        return Integer.parseInt(priceText);

    }

}
