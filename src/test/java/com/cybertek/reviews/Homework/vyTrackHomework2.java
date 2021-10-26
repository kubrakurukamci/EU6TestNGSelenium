package com.cybertek.reviews.Homework;


import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.TestersMeetingPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;

public class vyTrackHomework2 extends TestBase {

    public void preCondition(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();


    }

    @Test
    public void test1(){
        extentLogger=report.createTest("Subtitle Option");
        preCondition();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.options.isDisplayed());
        extentLogger.pass("Option subtitle test is PASSED");

    }
    @Test
    public void test2(){
        extentLogger=report.createTest("Page number");
        preCondition();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertEquals( calendarEventsPage.pageNumber.getAttribute("value"), "1");
        extentLogger.pass("Page number test is PASSED");

    }

    @Test
    public  void test3(){
        extentLogger=report.createTest("view per page number");
        preCondition();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals( calendarEventsPage.dropdownViewPerPage.getText(), "25");
        extentLogger.pass("View per page test is PASSED");

    }
    @Test
    public void test4(){
        extentLogger=report.createTest("number of calendar events");
        preCondition();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.rowNumber(), calendarEventsPage.records());

        extentLogger.pass("Test 4 is Passed");
    }
    @Test
    public void test5()  {
        extentLogger=report.createTest("Verify that all calendar events were selected ");
        preCondition();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.checkbox.click();


        List<WebElement> allCheckBoxes= Driver.get().findElements(By.xpath("//input[@tabindex='-1']"));
        for (WebElement allCheckBox : allCheckBoxes) {
            Assert.assertTrue(allCheckBox.isSelected());
        }
        extentLogger.pass("Test 5 is passed");

    }

    @Test
    public void test6(){
        extentLogger=report.createTest("Testers Meeting informations");
        preCondition();

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.TestersMeeting.click();

        TestersMeetingPage testersMeetingPage = new TestersMeetingPage();

        extentLogger.info("verify title");
        Assert.assertTrue(testersMeetingPage.title.isDisplayed());

        extentLogger.info("verify description");
        Assert.assertTrue(testersMeetingPage.description.isDisplayed());

        extentLogger.info("verify start");
        Assert.assertTrue(testersMeetingPage.start.isDisplayed());

        extentLogger.info("verify end");
        Assert.assertTrue(testersMeetingPage.end.isDisplayed());

        extentLogger.info("verify all day event");
        Assert.assertTrue(testersMeetingPage.allDayEvents.isDisplayed());

        extentLogger.info("verify organizer");
        Assert.assertTrue(testersMeetingPage.organizer.isDisplayed());

        extentLogger.info("verify recurrence");
        Assert.assertTrue(testersMeetingPage.recurrence.isDisplayed());

        extentLogger.info("verify call via hangout");
        Assert.assertTrue(testersMeetingPage.callViaHangout.isDisplayed());

        extentLogger.pass("TesterS meeting information test is PASSED");





    }



}
