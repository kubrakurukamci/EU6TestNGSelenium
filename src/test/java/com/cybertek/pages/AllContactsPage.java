package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllContactsPage extends BasePage{

    @FindBy(xpath = "//tbody/tr[1]")
    public WebElement listOfFirstRow;

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    public WebElement email;

    public void getCellInRelationToAnotherCellInSameRow(String firstName) {


        String xpath= "//table//td[.='"+firstName+"']/../td[4]";
        WebElement email= Driver.get().findElement(By.xpath(xpath));
        email.click();

    }


}
