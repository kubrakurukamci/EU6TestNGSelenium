package com.cybertek.reviews.Homework;

import com.cybertek.pages.AllContactsPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class vytrackHomework extends TestBase {

    @Test
    public void Test1(){
        extentLogger=report.createTest("Customer Mariam");

        // login as a sales manager
        LoginPage loginPage=new LoginPage();
        extentLogger.info("Login as a salesmanager");
        loginPage.loginAsSalesManager();

        //navigate to customers ->contacts
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Customers", "Contacts");
       // new DashboardPage().navigateToModule("Customers", "Contacts"); lazy way
        extentLogger.info("Navigate to costomer contacts page");
        BrowserUtils.waitFor(3);

        //click on email mbrackstone9@example.com
        AllContactsPage allContactsPage=new AllContactsPage();
        allContactsPage.getCellInRelationToAnotherCellInSameRow("Mariam");
        extentLogger.info("Click on email");


        ContactsPage contactsPage= new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        // verify that full name is Mariam Brackstone
        Assert.assertEquals(contactsPage.fullName.getText(),"Mariam Brackstone", "verify that name is Mariam Brackstone");
        extentLogger.info("Verifying the name");

        //verify that email is mbrackstone9@example.com
        Assert.assertEquals(contactsPage.email.getText(), "mbrackstone9@example.com");
        extentLogger.info("Verifying the email");

        //verify that phone number is +18982323434
        Assert.assertEquals(contactsPage.phoneNumber.getText(), "+18982323434");;
        extentLogger.info("Verifying the number");

        //verify that test is passed
        extentLogger.pass("Customer Mariam test is PASSED ");






    }

}
