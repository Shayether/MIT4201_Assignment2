package com.actiplans.demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.PropertyFileReader;
import utils.TestApp;

import java.io.File;
import java.io.IOException;


public class HRAccessingTheSystem {

    LoginFactoryPage loginPage;
    HomeFactoryPage homePage;

    ITestResult result;

    ApproveTimeTrackPage approveTimeTrackPage;

    PropertyFileReader property = new PropertyFileReader();



    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        loginPage = PageFactory.initElements(TestApp.getInstance().getDriver(), LoginFactoryPage.class);
        loginPage.loginAsAdmin();
        homePage = PageFactory.initElements(TestApp.getInstance().getDriver(), HomeFactoryPage.class);
        approveTimeTrackPage = PageFactory.initElements(TestApp.getInstance().getDriver(), ApproveTimeTrackPage.class);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        TestApp.getInstance().captureScreenshots(result.getName());
        TestApp.getInstance().closeBrowser();
    }

    @Test
    public void testApproveTimeEntriesFromListView() {
        homePage.checkUserIsInActiTimesPage();
        homePage.clickOnApproveTimeTrackMenuLink();
        //approveTimeTrackPage.searchEmployee();
        approveTimeTrackPage.approveTimeRequestFromListView();

    }

    @Test
    public void testApproveTimeEntriesFromDetailView() {
        homePage.checkUserIsInActiTimesPage();
        homePage.clickOnApproveTimeTrackMenuLink();
       // approveTimeTrackPage.searchEmployee();
        approveTimeTrackPage.navigateToTimeRequestFromDetailView();
        TestApp.log.info("Successfully navigated to the time entry details page");
        //Assert.assertEquals(homePage.getSelectedCustomerFirstName(),property.getProperty(("testData"),"empFirstName"));
        homePage.approveTimeSheetFromDetailsAfterChangeTimeSheetData();
        TestApp.log.info("Successfully approved the time entry");
    }

    @Test
    public void testRejectTimeSheetEntriesFromListView(){
        homePage.checkUserIsInActiTimesPage();
        homePage.clickOnApproveTimeTrackMenuLink();
       // approveTimeTrackPage.searchEmployee();
        approveTimeTrackPage.rejectTimeRequestFromListView();
    }

    @Test
    public void testRejectTimeSheetEntriesFromDetailView(){
        homePage.checkUserIsInActiTimesPage();
        homePage.clickOnApproveTimeTrackMenuLink();
        //approveTimeTrackPage.searchEmployee();
        approveTimeTrackPage.navigateToTimeRequestFromDetailView();
        TestApp.log.info("Successfully navigated to the time entry details page");
        //Assert.assertEquals(homePage.getSelectedCustomerFirstName(),property.getProperty(("testData"),"empFirstName"));
        homePage.rejectTimeSheetFromDetailsAfterChangeTimeSheetData();
        TestApp.log.info("Successfully rejected the time sheet");
        Assert.assertEquals(homePage.getTimeEntryStatus(),"Rejected");

    }

    @Test
    public void testRevokeTimeSheetEntriesFromListViewAfterApproved(){
        homePage.checkUserIsInActiTimesPage();
        homePage.clickOnApproveTimeTrackMenuLink();
        approveTimeTrackPage.searchEmployee();
        approveTimeTrackPage.verifyHighlightedSearchedValueIsDisplayed();
        approveTimeTrackPage.approveTimeRequestFromListView();
        approveTimeTrackPage.revokeTimeRequestFromListViewAfterApproved();

    }

    @Test
    public void testRevokeTimeSheetEntriesFromDetailViewAfterApproved(){
        homePage.checkUserIsInActiTimesPage();
        homePage.clickOnApproveTimeTrackMenuLink();
        approveTimeTrackPage.searchEmployee();
        approveTimeTrackPage.verifyHighlightedSearchedValueIsDisplayed();
        approveTimeTrackPage.navigateToTimeRequestFromDetailView();
        Assert.assertEquals(homePage.getSelectedCustomerFirstName(),property.getProperty(("testData"),"empFirstName"));
        homePage.approveTimeSheetFromDetailsAfterChangeTimeSheetData();
        Assert.assertEquals(homePage.getTimeEntryStatus(),"Approved");
        homePage.revokeTimeSheetFromDetailsView();
        Assert.assertEquals(homePage.getTimeEntryStatus(),"Ready");
    }

    @Test
    public void testRevokeTimeSheetEntriesFromListViewAfterReject(){
        homePage.checkUserIsInActiTimesPage();
        homePage.clickOnApproveTimeTrackMenuLink();
        approveTimeTrackPage.searchEmployee();
        approveTimeTrackPage.verifyHighlightedSearchedValueIsDisplayed();
        approveTimeTrackPage.rejectTimeRequestFromListView();
        approveTimeTrackPage.revokeTimeRequestFromListViewAfterRejected();

    }

    @Test
    public void testRevokeTimeSheetEntriesFromDetailViewAfterReject(){
        homePage.checkUserIsInActiTimesPage();
        homePage.clickOnApproveTimeTrackMenuLink();
        approveTimeTrackPage.searchEmployee();
        approveTimeTrackPage.verifyHighlightedSearchedValueIsDisplayed();
        approveTimeTrackPage.navigateToTimeRequestFromDetailView();
        Assert.assertEquals(homePage.getSelectedCustomerFirstName(),property.getProperty(("testData"),"empFirstName"));
        homePage.rejectTimeSheetFromDetailsAfterChangeTimeSheetData();
        Assert.assertEquals(homePage.getTimeEntryStatus(),"Rejected");
        homePage.revokeTimeSheetFromDetailsView();
        Assert.assertEquals(homePage.getTimeEntryStatus(),"Ready");
    }


    @Test
    public void testEmptyTimeSheetRequestPage(){
        homePage.checkUserIsInActiTimesPage();
        homePage.clickOnApproveTimeTrackMenuLink();
        approveTimeTrackPage.searchInvalidEmployee();
        Assert.assertEquals(approveTimeTrackPage.getNoRecordsMessageText(),"Check invalid data to Fail the test case");
    }





}
