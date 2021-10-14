package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest() {
        //name of the test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter username:user1");
        loginPage.passwordInput.sendKeys("some password");
        extentLogger.info("Enter password:some password");
        loginPage.loginBtn.click();
        extentLogger.info("Click login button");

        extentLogger.info("Verify the url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("Wrong password test is PASSED");

    }
    @Test
    public void wrongUsername(){
        //name of the test
        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter username:someusername");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter password:UserUser123");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");

        extentLogger.info("Verify the url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("PASSED");

    }
}
