package com.actiplans.demo;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyFileReader;
import utils.TestApp;



public class EmployeeAccessingTheSystem {

    LoginFactoryPage loginPage;

    HomeFactoryPage homePage = new HomeFactoryPage();

    PropertyFileReader property = new PropertyFileReader();

    String workingTimeEffortData = property.getProperty("testData", "workDayTimeEntry");
    String wokTimeEffortLastWeekData = property.getProperty("testData","wokTimeEffortLastWeekData");

    @BeforeMethod
    public void testLogin() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        loginPage = PageFactory.initElements(TestApp.getInstance().getDriver(), LoginFactoryPage.class);
        homePage = PageFactory.initElements(TestApp.getInstance().getDriver(), HomeFactoryPage.class);
        loginPage.loginAsEmployee();
    }

    @AfterMethod
    public void tearDown() {
        TestApp.getInstance().closeBrowser();
    }

    @Test
    public void testEnterTimeForLastWeekDayOrTwo() {
        homePage.selectLastWeekDateFromDatePicker();
        homePage.enterWorkTimeForLastWeek(wokTimeEffortLastWeekData);
        homePage.enterLastWeekLeave();
        homePage.clickOnReadyToApproveToggleAndSaveChanges();
        homePage.logout();

    }


    @Test
    public void testEnterWorkedTime() {
        homePage.closeOpenedPopUp();
        homePage.selectCurrentWeekFromDatePicker();
        homePage.closeOpenedPopUp();
        homePage.enterWorkTime(workingTimeEffortData);
        homePage.closeOpenedPopUp();
        homePage.enterLeave();
        homePage.closeOpenedPopUp();
        homePage.clickOnReadyToApproveToggleAndSaveChanges();
        homePage.closeOpenedPopUp();
        homePage.logout();
    }


}
