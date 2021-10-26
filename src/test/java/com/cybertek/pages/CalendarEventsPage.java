package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "(//div[@data-toggle='dropdown'])[2]")
    public WebElement options;

    @FindBy(css = "input[value='1']")
    public WebElement pageNumber;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    public WebElement dropdownViewPerPage;

    @FindBy(xpath = "//button[@data-toggle='dropdown']//input")
    public WebElement checkbox;

    @FindBy(xpath = "//td[@data-column-label='Selected Rows']")
    public WebElement allBoxes;

    @FindBy(xpath = "//*[.='Testers Meeting']")
    public WebElement TestersMeeting;

    public int rowNumber(){
        List<WebElement> rows=Driver.get().findElements(By.xpath("//table/tbody/tr"));
        return rows.size();
    }
    public int records(){
        WebElement record = Driver.get().findElement(By.xpath("//*[@class='dib'][3]"));
        String s= record.getText();
        String[] s1 = s.split(" ");
        return Integer.parseInt(s1[2]);
    }
}
