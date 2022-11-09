package com.actiplans.demo;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertyFileReader;
import utils.TestApp;

public class ApproveTimeTrackPage {

    PropertyFileReader property = new PropertyFileReader();

    HomeFactoryPage homePage = new HomeFactoryPage();

    @FindBy(xpath = "//*[@class='pagetitle']")
    public WebElement timeTrackPageTitlelabel;

    @FindBy(xpath = "//*[@class='filterWordsField']/tbody/tr/td[1]/input")
    public WebElement nameSearchBox;

    @FindBy(xpath = "//*[@class='data']//*[@class='noRecordsRow']/td")
    public WebElement noRecordsMessage;

    @FindBy(id = "approveButton")
    public WebElement approveButton;

    @FindBy(id = "rejectButton")
    public WebElement rejectButton;

    @FindBy(id = "rejectWeekCommentTextArea")
    public WebElement rejectCommentTextArea;

    @FindBy(xpath = "//*[@class='rejectCaptionDiv']//span[1]")
    public WebElement rejectPopUpTitle;

    @FindBy(xpath = "//*[@class='ui-dialog-buttonset']//span[text()='Reject']")
    public WebElement rejectPopUpButton;

    @FindBy(xpath = "//tbody//*[@class='childRow ready'][1]//*[@class='selectionCell']/input")
    public WebElement timeSheetSelectionCheckBox;

    @FindBy(xpath = "//*[@class='childRow ready'][1]//*[@class='submitTTLinkCell']/a")
    public WebElement timeSheetPeriodSelectionLink;

    @FindBy(xpath = "//*[@class='userNameInfo']//*[@class='highlightToken']")
    public WebElement highlightedSearchedValue;

    @FindBy(xpath = "//*[@class='childRow operationWasApplied approved']//*[@class='revokeCell']/a")
    public WebElement revokeLinkInApprovedListView;

    @FindBy(xpath = "//*[@class='childRow operationWasApplied rejected']//*[@class='revokeCell']/a")
    public WebElement revokeLinkInRejectedListView;




    public ApproveTimeTrackPage searchEmployee(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='searchNameText']"), 20);
        String empFirstName = property.getProperty("testData","empFirstName");
        nameSearchBox.sendKeys(empFirstName);
        TestApp.log.info("Successfully searched employee name");
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='userNameInfo']//*[@class='highlightToken']"),20);
        highlightedSearchedValue.isDisplayed();
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='groupingRow']//*[@class='userNameInfo']"),20);
        return this;
    }

    public ApproveTimeTrackPage searchInvalidEmployee(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='searchNameText']"), 20);
        String empFirstName = property.getProperty("testData","empInvalidName");
        nameSearchBox.sendKeys(empFirstName);
        TestApp.log.info("Successfully searched invalid employee name");
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='data']//*[@class='noRecordsRow']/td"),20);
        noRecordsMessage.isDisplayed();
        TestApp.log.info("No records message is displayed");
        return this;
    }

    public String getNoRecordsMessageText(){
        return noRecordsMessage.getText();
    }

    public ApproveTimeTrackPage approveTimeRequestFromListView(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//tbody//*[@class='childRow ready'][1]//*[@class='selectionCell']/input"),20);
        timeSheetSelectionCheckBox.click();
        TestApp.log.info("Select the time sheet selection check box");
        TestApp.getInstance().waitUntilNextElementAppears(By.id("approveButton"),20);
        approveButton.click();
        TestApp.log.info("Successfully approved the time sheet");
        return this;
    }

    public ApproveTimeTrackPage revokeTimeRequestFromListViewAfterApproved(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='childRow operationWasApplied rejected']//*[@class='revokeCell']/a"),20);                 revokeLinkInRejectedListView.click();
        TestApp.log.info("Successfully revoked the approved time sheet");
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//tbody//*[@class='childRow ready'][1]//*[@class='selectionCell']/input"),20);
        timeSheetSelectionCheckBox.isDisplayed();
        TestApp.log.info("Time sheet selection checkbox visible");
        return this;
    }

    public ApproveTimeTrackPage revokeTimeRequestFromListViewAfterRejected(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='childRow operationWasApplied approved']//*[@class='revokeCell']/a"),20);
        revokeLinkInApprovedListView.click();
        TestApp.log.info("Successfully revoked the rejected time sheet");
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//tbody//*[@class='childRow ready'][1]//*[@class='selectionCell']/input"),20);
        timeSheetSelectionCheckBox.isDisplayed();
        TestApp.log.info("Time sheet selection checkbox visible");
        return this;
    }

    public  ApproveTimeTrackPage verifyHighlightedSearchedValueIsDisplayed(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='childRow ready'][1]//*[@class='submitTTLinkCell']/a"),20);
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='userNameInfo']//*[@class='highlightToken']"),20);
        highlightedSearchedValue.isDisplayed();
        return this;
    }


    public ApproveTimeTrackPage navigateToTimeRequestFromDetailView(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='childRow ready'][1]//*[@class='submitTTLinkCell']/a"),20);
        timeSheetPeriodSelectionLink.click();
        TestApp.log.info("Successfully navigated to the time entry details page");
        return this;
    }


    public ApproveTimeTrackPage rejectTimeRequestFromListView(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//tbody//*[@class='childRow ready'][1]//*[@class='selectionCell']/input"),20);
        timeSheetSelectionCheckBox.click();
        TestApp.log.info("Select the time sheet selection check box");
        TestApp.getInstance().waitUntilNextElementAppears(By.id("approveButton"),20);
        TestApp.getInstance().waitUntilNextElementAppears(By.id("rejectButton"),20);
        rejectButton.click();
        TestApp.getInstance().waitUntilNextElementAppears(By.id("rejectWeekCommentTextArea"),20);
        rejectPopUpTitle.isDisplayed();
        TestApp.log.info("Reject pop up is opened");
        TestApp.getInstance().waitUntilNextElementAppears(By.id("rejectWeekCommentTextArea"),20);
        rejectCommentTextArea.sendKeys(property.getProperty("testData","RejectReason1"));
        TestApp.log.info("Successfully entered rejected reason");
        rejectPopUpButton.click();
        TestApp.log.info("Successfully rejected the time sheet");
        return this;
    }




}
