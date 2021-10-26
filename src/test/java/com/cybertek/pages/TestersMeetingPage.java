package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestersMeetingPage extends  BasePage{

    @FindBy(xpath = "(//*[.='Testers Meeting'])[2]")
    public WebElement title;

    @FindBy(tagName = "p")
    public WebElement description;

    @FindBy(xpath = "//div[contains(text(),'9:30')]")
    public WebElement start;

    @FindBy(xpath = "//div[contains(text(),'10:30')]")
    public WebElement end;

    @FindBy(xpath = "//div[.='No']")
    public WebElement allDayEvents;

    @FindBy(linkText = "John Doe")
    public WebElement organizer;

    @FindBy(xpath = "//div[contains(text(),'every')]")
    public WebElement recurrence;

    @FindBy(xpath = "(//div[contains(text(),'No')])[4]")
    public WebElement callViaHangout;



}
