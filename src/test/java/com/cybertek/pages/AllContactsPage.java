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

    //since we are extending BasePage we do not need explicit constructor for this class

    //    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")

    //    public WebElement email;

    public WebElement getContactEmail(String email){
        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }
    public void getCellInRelationToAnotherCellInSameRow(String firstName) {


        String xpath= "//table//td[.='"+firstName+"']/../td[4]";
        WebElement email= Driver.get().findElement(By.xpath(xpath));
        email.click();

    }


}
