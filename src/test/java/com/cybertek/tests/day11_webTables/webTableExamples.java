package com.cybertek.tests.day11_webTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webTableExamples {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    @Test
    public void printTable(){
        WebElement table =driver.findElement(By.id("table1"));
        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));

    }
    @Test
    public void getAllHeaders(){
        //how many columns we have?
        List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }


    }
    @Test
    public void printTableSize(){

        //how many columns we have?
        List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());

        //how many rows?
        List<WebElement> rowsWithHeader=driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(rowsWithHeader.size());

        //number of rows without header    ===we prefer this===
        List<WebElement> rowsWithoutHeader=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(rowsWithoutHeader.size());


    }
    @Test
    public void getRow(){
        //print the second row information
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));

        //System.out.println(row2.getText());

        //get all rows dynamically
        //1.find number of rows
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        //2.iterate one by one
        for (int i = 1; i <= numRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i+"-"+row.getText());
        }

    }
    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());

        }

    }

    @Test
    public void getASingleCellByIndex() {

        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println(singleCell.getText());

    }

    @Test
    public void printAllCellsByIndex(){
        int numberOfRows=getNumberOfRow();
        int numberOfColumn=getNumberOfColumn();

        System.out.println("numberOfRows = " + numberOfRows);
        System.out.println("numberOfColumn = " + numberOfColumn);


        //iterate through each row on the table
        for (int i = 1; i <= numberOfRows; i++) {

            //iterate through each cell in the row
            for (int j = 1; j <= numberOfColumn; j++) {
                String xpath="//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(xpath);
                
                WebElement cell= driver.findElement(By.xpath(xpath));
                System.out.println(cell.getText());

            }

        }
    }

    private int getNumberOfColumn() {
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return elements.size();
    }

    private int getNumberOfRow() {
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return elements.size();
    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow() {
        String firstname="John";

        String xpath= "//table[@id='table1']//td[.='"+firstname+"']/../td[3]";
        WebElement email= driver.findElement(By.xpath(xpath));
        System.out.println("email.getText() = " + email.getText());

    }






}
