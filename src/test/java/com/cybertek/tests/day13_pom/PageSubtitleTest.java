package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.BasePage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case
     * Open Chrome browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */

    @Test
    public void test1() {

        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage();

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle, "verify the subtitle of dashboard");

        dashboardPage.navigateToModule("Activities" , "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(2); //diger sayfanin subtitle almamasi icin bekliyoruz

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(), "Calendar Events", "verify subtitle of calendar page"); //lazy way



    }



}
