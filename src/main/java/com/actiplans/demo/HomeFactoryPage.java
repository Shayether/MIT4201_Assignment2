package com.actiplans.demo;

import org.apache.logging.log4j.core.util.Assert;
import org.bouncycastle.util.test.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.PropertyFileReader;
import utils.TestApp;

import javax.swing.*;
import java.text.DateFormatSymbols;
import java.time.Duration;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomeFactoryPage {


    WebDriver driver;
    PropertyFileReader property = new PropertyFileReader();

    @FindBy(id = "logoutLink")
    private WebElement logout;

    @FindBy(xpath = "//*[@class='userProfileLink username ']")
    private WebElement userProfileLink;

    @FindBy(xpath = "//*[@class='logoSwitcherText']")
    private WebElement switchToActiPlansLink;

    @FindBy(id = "userProfilePopup_firstNameField")
    private WebElement firstName;

    @FindBy(id = "userProfilePopup_lastNameField")
    private WebElement lastName;

    @FindBy(id = "closeProjectLightBoxBtn")
    private WebElement popUpCloseButton;

    @FindBy(xpath = "//*[@class='x-btn-text']")
    private WebElement datePickerButton;

    @FindBy(xpath = "//*[@class=' at-selected-week']//*[@class='x-date-active at-first-day ']//*[@class='x-date-date']/em/span")
    private WebElement datePickerLastWeekFirstDate;

    @FindBy(xpath = "//*[@class='x-date-bottom']/a")
    private WebElement datePickerCurrentWeek;

    @FindBy(id = "exitConfirmDialog")
    private WebElement modificationSaveConfirmationPopUp;

    @FindBy(xpath = "//*[@class='exitConfirmButton'][2]/input")
    private WebElement confirmationPopUpDiscardChangesButton;






    @FindBy(xpath = "//*[@class='weekApprovalStatusControlOuterContainer top ' ]//*[@class='switcherBackground']")
    private WebElement notReadyTopToggle;

    @FindBy(id = "ext-gen10")
    private WebElement weekSelectionLink;

    @FindBy(xpath = "//*[@id='actualTTRows']/tr[1]/td[4]/table/tbody/tr/td[1]//*[@class='text inputTT']")
    private WebElement mondayTextBox;

    @FindBy(xpath = "//*[@id='actualTTRows']/tr[1]/td[5]/table/tbody/tr/td[1]//*[@class='text inputTT']")
    private WebElement tuesdayTextBox;

    @FindBy(xpath = "//*[@id='actualTTRows']/tr[1]/td[6]/table/tbody/tr/td[1]//*[@class='text inputTT']")
    private WebElement wednesdayTextBox;

    @FindBy(xpath = "//*[@id='actualTTRows']/tr[1]/td[7]/table/tbody/tr/td[1]//*[@class='text inputTT']")
    private WebElement thursdayTextBox;

    @FindBy(xpath = "//*[@id='actualTTRows']/tr[1]/td[8]/table/tbody/tr/td[1]//*[@class='text inputTT']")
    private WebElement fridayTextBox;

    @FindBy(xpath = "//*[@id='actualTTRows']/tr[1]/td[9]/table/tbody/tr/td[1]//*[@class='text inputTT']")
    private WebElement saturdayTextBox;

    @FindBy(xpath = "//*[@id='actualTTRows']/tr[1]/td[10]/table/tbody/tr/td[1]//*[@class='text inputTT']")
    private WebElement sundayTextBox;

    @FindBy(xpath = "//*[@class='submitTTHead']/td[7]//*[@class='lock']")
    private WebElement lockMarkThursday;

    @FindBy(xpath = "//*[@class='submitTTHead']/td[8]//*[@class='lock']")
    private WebElement lockMarkFriday;





    @FindBy(id = "leaveButton_0_mainContentTd")
    private WebElement mondayWorkDayDropdown;

    @FindBy(id = "leaveButton_1_mainContentTd")
    private WebElement tuesdayWorkDayDropdown;

    @FindBy(id = "leaveButton_2_mainContentTd")
    private WebElement wednesdayWorkDayDropdown;

    @FindBy(id = "leaveButton_3_mainContentTd")
    private WebElement thursdayWorkDayDropdown;

    @FindBy(id = "leaveButton_4_mainContentTd")
    private WebElement fridayWorkDayDropdown;

    @FindBy(xpath = "//*[@class='dropdownContainer simpleListMenu ']//*[contains(text(),'Vacation')]")
    private WebElement dropdownValueVacation;

    @FindBy(xpath = "//*[@class='dropdownContainer simpleListMenu ']//*[contains(text(),'Time Off')]")
    private WebElement dropdownValueTimeOff;

    @FindBy(xpath = "//*[@class='dropdownContainer simpleListMenu ']//*[contains(text(),'Sick Leave')]")
    private WebElement dropdownValueSickLeave;

    @FindBy(xpath = "//*[@class='dropdownContainer simpleListMenu ']//*[contains(text(),'Business Trip')]")
    private WebElement dropdownValueBusinessTrip;

    @FindBy(xpath = "//*[@class='dropdownContainer simpleListMenu ']//*[contains(text(),'Stay Home')]")
    private WebElement dropdownValueStayHome;

    @FindBy(xpath = "//*[@class='dropdownContainer simpleListMenu ']//*[contains(text(),'due to some work')]")
    private WebElement dropdownValueDueToSomeWork;





    @FindBy(xpath = "//*[@class='mainContentPadding rightPadding myOwnTT weekStatusPresent formModified notReady']")
    private WebElement selectedNotReadyOnToggle;

    @FindBy(xpath = "//*[@class='mainContentPadding rightPadding myOwnTT weekStatusPresent formModified ready']")
    private WebElement selectedReadyOnToggle;

    @FindBy(id = "LeavePopupRadio_TimeOff")
    private WebElement enterLeaveTimeRadio;


    @FindBy(xpath = "//*[@class='leaveTypeSelect']")
    private WebElement leaveTypeSelectDropDown;



    @FindBy(id = "leaveTimeOffIcon")
    private WebElement leaveTimeOffIcon;


    @FindBy(name = "LeavePopupOK")
    private WebElement okBtnLeaveTypePopUp;


    @FindBy(id = "SubmitTTButton")
    private WebElement saveChangesBtn;


    //Admin User Home Page Specific Elements
    @FindBy(xpath = "//a[@href='/administration/approve_tt.do']")
    private WebElement approveTimeTrackMenuLink;

    @FindBy(xpath = "//*[@class='userNameWrapper']/span")
    private WebElement selectedEmployeeName;

    @FindBy(xpath = "//*[@class='weekApprovalStatusControlOuterContainer top ']//*[@class='changeStatusButton approveButton']")
    private WebElement approveButtonDetailsView;

    @FindBy(xpath = "//*[@class='weekApprovalStatusControlOuterContainer top ']//*[@class='changeStatusButton rejectButton']")
    private WebElement rejectButtonDetailsView;

    @FindBy(xpath = "//*[@class='rejectCaptionDiv']//span[1]")
    public WebElement rejectPopUpTitle;

    @FindBy(id = "rejectWeekCommentTextArea")
    public WebElement rejectCommentTextArea;

    @FindBy(xpath = "//*[@class='ui-dialog-buttonset']//span[text()='Reject']")
    public WebElement rejectPopUpButton;

    @FindBy(xpath = "//*[@class='weekApprovalStatusControlOuterContainer top ']//*[@class='revokeLink customLink']")
    public WebElement revokeLinkDetailView;

    @FindBy(xpath = "//*[@class='weekApprovalStatusControlOuterContainer top ']//*[@class='currentStatusCell statusText']")
    public WebElement timeEntryStatusDetailView;


    public HomeFactoryPage closeOpenedPopUp() {

        Set<String> wids = TestApp.getInstance().getDriver().getWindowHandles();

        if (wids.size() > 1) {
            driver.switchTo().window("Before you start exploring actiPLANS");
            TestApp.getInstance().waitUntilNextElementAppears(By.id("closeProjectLightBoxBtn"), 20);
            try {
                TestApp.getInstance().waitUntilNextElementAppears(By.id("closeProjectLightBoxBtn"), 20);
                WebElement elementOnPopUp = driver.findElement(By.id("closeProjectLightBoxBtn"));

                if (elementOnPopUp.isDisplayed()) {
                    popUpCloseButton.click();
                }
            } catch (NoSuchElementException ne) {

            }

        }
        return this;
    }

    public HomeFactoryPage selectLastWeekDateFromDatePicker(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='x-btn-text']"),20);
        datePickerButton.click();
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class=' at-selected-week']//*[@class='x-date-active at-first-day ']//*[@class='x-date-date']/em/span"),20);
        datePickerLastWeekFirstDate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            TestApp.log.info("Thread.Sleep() ERROR");
        }
        if(modificationSaveConfirmationPopUp.isDisplayed() == true){
            TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='exitConfirmButton'][2]/input"),20);
            confirmationPopUpDiscardChangesButton.click();
        }
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='weekApprovalStatusControlOuterContainer top ' ]//*[@class='switcherBackground']"),20);
        notReadyTopToggle.isDisplayed();

        return this;
    }

    public HomeFactoryPage selectCurrentWeekFromDatePicker(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='x-btn-text']"),20);
        datePickerButton.click();

        return this;
    }

    public HomeFactoryPage checkUserIsInActiTimesPage(){
        TestApp.getInstance().waitUntilNextElementAppears(By.className("logoSwitcherText"),20);
        if(switchToActiPlansLink.getText() == "Switch to actiTIME"){
            switchToActiPlansLink.click();
            TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//td[1]/div//*[@class='pagetitle'][1]"),20);
        }
        return this;
    }

    public HomeFactoryPage enterWorkTimeForLastWeek(String wokTimeEffortLastWeekData){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='userProfileLink username ']"),20);
        String wednesday = "Wednesday";
        String thursday = "Thursday";
        String nameOfDay = null;

        if (nameOfDay == "Wednesday" && lockMarkThursday.isDisplayed() == false) {
            TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@id='actualTTRows']/tr[1]/td[6]/table/tbody/tr/td[1]//*[@class='text inputTT']"),20);
            wednesdayTextBox.click();
            wednesdayTextBox.clear();
            wednesdayTextBox.click();
            wednesdayTextBox.sendKeys(wokTimeEffortLastWeekData);
            wednesdayTextBox.click();
        }
        if (nameOfDay == "Thursday" && lockMarkFriday.isDisplayed() == false) {
            TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@id='actualTTRows']/tr[1]/td[7]/table/tbody/tr/td[1]//*[@class='text inputTT']"),20);
            thursdayTextBox.click();
            thursdayTextBox.clear();
            thursdayTextBox.click();
            thursdayTextBox.sendKeys(wokTimeEffortLastWeekData);
            thursdayTextBox.click();
        }
        return this;
    }

    public HomeFactoryPage enterLastWeekLeave(){
        String friday = "Friday";
        String nameOfDay = null;

        if (nameOfDay == "Friday" && lockMarkThursday.isDisplayed() == false) {
            TestApp.getInstance().waitUntilNextElementAppears(By.id("leaveButton_4_mainContentTd"),20);
            fridayWorkDayDropdown.click();
            TestApp.getInstance().waitUntilNextElementAppears(By.id("LeavePopupRadio_TimeOff"),20);
            enterLeaveTimeRadio.click();
            leaveTypeSelectDropDown.click();
            dropdownValueBusinessTrip.click();
            okBtnLeaveTypePopUp.click();
            saveChangesBtn.click();
        }
        return this;
    }

    public HomeFactoryPage enterWorkTime(String wokTimeEffortData){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='userProfileLink username ']"),20);

        DateFormatSymbols dfs = new DateFormatSymbols();
        String weekdays[] = dfs.getWeekdays();
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        String nameOfDay = weekdays[day];
        TestApp.log.info("Work time added for" + nameOfDay);

        if(nameOfDay == "Monday"){
            mondayTextBox.click();
            mondayTextBox.clear();
            mondayTextBox.click();
            mondayTextBox.sendKeys(wokTimeEffortData);
            mondayTextBox.click();
        } else if (nameOfDay == "Tuesday") {
            tuesdayTextBox.click();
            tuesdayTextBox.clear();
            tuesdayTextBox.click();
            tuesdayTextBox.sendKeys(wokTimeEffortData);
            tuesdayTextBox.click();
        } else if (nameOfDay == "Wednesday") {
            wednesdayTextBox.click();
            wednesdayTextBox.clear();
            wednesdayTextBox.click();
            wednesdayTextBox.sendKeys(wokTimeEffortData);
            wednesdayTextBox.click();
        }else if (nameOfDay == "Thursday") {
            thursdayTextBox.click();
            thursdayTextBox.clear();
            thursdayTextBox.click();
            thursdayTextBox.sendKeys(wokTimeEffortData);
            thursdayTextBox.click();
        }else if (nameOfDay == "Friday") {
            fridayTextBox.click();
            fridayTextBox.clear();
            fridayTextBox.click();
            fridayTextBox.sendKeys(wokTimeEffortData);
            fridayTextBox.click();
        }else if (nameOfDay == "Saturday") {
            saturdayTextBox.click();
            saturdayTextBox.clear();
            saturdayTextBox.click();
            saturdayTextBox.sendKeys(wokTimeEffortData);
            saturdayTextBox.click();
        }else if (nameOfDay == "Sunday") {
            sundayTextBox.click();
            sundayTextBox.clear();
            sundayTextBox.click();
            sundayTextBox.sendKeys(wokTimeEffortData);
            sundayTextBox.click();
        }
        return this;
    }


    public HomeFactoryPage enterLeave(){
        TestApp.getInstance().waitUntilNextElementAppears(By.id("leaveButton_4_mainContentTd"),10);
        DateFormatSymbols dfs = new DateFormatSymbols();
        String weekdays[] = dfs.getWeekdays();
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        String nameOfDay = weekdays[day-1];
        TestApp.log.info("Leave added for" + nameOfDay);

        if(nameOfDay == "Monday"){
            mondayWorkDayDropdown.click();
            TestApp.getInstance().waitUntilNextElementAppears(By.id("LeavePopupRadio_TimeOff"),20);
            enterLeaveTimeRadio.click();
            leaveTypeSelectDropDown.click();
            dropdownValueVacation.click();
            okBtnLeaveTypePopUp.click();
            saveChangesBtn.click();
        } else if (nameOfDay == "Tuesday") {
            tuesdayWorkDayDropdown.click();
            TestApp.getInstance().waitUntilNextElementAppears(By.id("LeavePopupRadio_TimeOff"),20);
            enterLeaveTimeRadio.click();
            leaveTypeSelectDropDown.click();
            dropdownValueTimeOff.click();
            okBtnLeaveTypePopUp.click();
            saveChangesBtn.click();
        } else if (nameOfDay == "Wednesday") {
            wednesdayWorkDayDropdown.click();
            TestApp.getInstance().waitUntilNextElementAppears(By.id("LeavePopupRadio_TimeOff"),20);
            enterLeaveTimeRadio.click();
            leaveTypeSelectDropDown.click();
            dropdownValueSickLeave.click();
            okBtnLeaveTypePopUp.click();
            saveChangesBtn.click();
        }else if (nameOfDay == "Thursday") {
            thursdayWorkDayDropdown.click();
            TestApp.getInstance().waitUntilNextElementAppears(By.id("LeavePopupRadio_TimeOff"),20);
            enterLeaveTimeRadio.click();
            leaveTypeSelectDropDown.click();
            dropdownValueStayHome.click();
            okBtnLeaveTypePopUp.click();
            saveChangesBtn.click();
        }else if (nameOfDay == "Friday") {
            fridayWorkDayDropdown.click();
            TestApp.getInstance().waitUntilNextElementAppears(By.id("LeavePopupRadio_TimeOff"),20);
            enterLeaveTimeRadio.click();
            leaveTypeSelectDropDown.click();
            dropdownValueBusinessTrip.click();
            okBtnLeaveTypePopUp.click();
            saveChangesBtn.click();
        }else if (nameOfDay == "Saturday") {
            saveChangesBtn.click();
        }else if (nameOfDay == "Sunday") {
            saveChangesBtn.click();
        }
        return this;
    }

    public HomeFactoryPage clickOnReadyToApproveToggleAndSaveChanges(){
                notReadyTopToggle.click();
                saveChangesBtn.click();
                return this;
    }

    public ApproveTimeTrackPage clickOnApproveTimeTrackMenuLink(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//a[@href='/administration/approve_tt.do']"), 20);
        approveTimeTrackMenuLink.click();
        TestApp.log.info("Successfully navigated to the Approve Time Track page");
        return PageFactory.initElements(TestApp.getInstance().getDriver(), ApproveTimeTrackPage.class);
    }

    public String getSelectedCustomerFirstName() {
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='userNameWrapper']/span"),20);
        String[] names = selectedEmployeeName.getText().split(", ", 2);
        String FName = names[1];
        String LName = names[0];
        return FName;
    }

    public HomeFactoryPage approveTimeSheetFromDetailsAfterChangeTimeSheetData() {
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='weekApprovalStatusControlOuterContainer top ']//*[@class='changeStatusButton approveButton']"),20);
        approveButtonDetailsView.click();
        TestApp.log.info("Successfully approved the time sheet");
        //initial implicit wait until change the status element value
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            TestApp.log.info("Thread.Sleep() ERROR");
        }
        return this;
    }

    public HomeFactoryPage rejectTimeSheetFromDetailsAfterChangeTimeSheetData(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='weekApprovalStatusControlOuterContainer top ']//*[@class='changeStatusButton approveButton']"),20);
        rejectButtonDetailsView.click();
        TestApp.getInstance().waitUntilNextElementAppears(By.id("rejectWeekCommentTextArea"),20);
        rejectPopUpTitle.isDisplayed();
        TestApp.log.info("Reject pop up is opened");
        rejectCommentTextArea.sendKeys(property.getProperty("testData","RejectReason1"));
        TestApp.log.info("Successfully entered rejected reason");
        rejectPopUpButton.click();
        //initial implicit wait until change the status element value
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            TestApp.log.info("Thread.Sleep() ERROR");
        }
        return this;
    }

    public String getTimeEntryStatus(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='weekApprovalStatusControlOuterContainer top ']//*[@class='currentStatusCell statusText']"),20);
        return timeEntryStatusDetailView.getText();
    }

    public HomeFactoryPage revokeTimeSheetFromDetailsView(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@class='weekApprovalStatusControlOuterContainer top ']//*[@class='revokeLink customLink']"),20);
        revokeLinkDetailView.click();
        TestApp.log.info("Successfully revoked the time sheet");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            TestApp.log.info("Thread.Sleep() ERROR");
        }
        return this;
    }


    public LoginFactoryPage logout(){
        TestApp.getInstance().waitUntilNextElementAppears(By.id("logoutLink"),20);
        logout.click();
        return PageFactory.initElements(TestApp.getInstance().getDriver(), LoginFactoryPage.class);
    }




}
