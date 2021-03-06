package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{
    @FindBy(xpath = "//h1[.='Mariam Brackstone']")
    public WebElement fullName;

    @FindBy(xpath = "//a[@class='email']")
    public WebElement email;

    @FindBy(xpath = "//a[@class='phone']")
    public WebElement phoneNumber;

    /* JAMAL'IN BULDUGU LOCATORLAR

       @FindBy(css = "div.pull-left>h1.user-name")
        public WebElement fullName;

        @FindBy(css = "a.phone")
        public WebElement phone;

        @FindBy(css = "a.email")
        public WebElement email;
     */
}
