package com.actiplans.demo;

import org.bouncycastle.util.test.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyFileReader;
import utils.TestApp;

public class LoginFactoryPage {

    PropertyFileReader property = new PropertyFileReader();

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(name = "pwd")
    private WebElement password;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id= 'welcomeScreenLightbox_content']")
    private WebElement welcomeScreenPopUp;

    @FindBy(id = "//*[@class= 'product-pop-up__content']")
    private WebElement welcomeScreenPopUp2;

    @FindBy(xpath = "//*[@id= 'closeProjectLightBoxBtn']")
    private WebElement welcomeScreenCloseBtn;


    public HomeFactoryPage loginAsAdmin(){
        TestApp.getInstance().waitUntilNextElementAppears(By.id("username"),20);
        String username = property.getProperty("user","adminusername");
        userName.sendKeys(username);
        TestApp.getInstance().waitUntilNextElementAppears(By.name("pwd"),20);
        String passwordData = property.getProperty("user","adminpassword");
        password.sendKeys(passwordData);
        loginButton.click();
        boolean popUpDisplay = TestApp.getInstance().isElementPresent(By.xpath("//*[@id= 'welcomeScreenLightbox_content']"));
        if(popUpDisplay == true)
            welcomeScreenCloseBtn.click();
        TestApp.getInstance().waitUntilNextElementAppears(By.id("logoutLink"),20);
        TestApp.log.info("Successfully login as Admin");
        return PageFactory.initElements(TestApp.getInstance().getDriver(), HomeFactoryPage.class);

    }

    public HomeFactoryPage loginAsEmployee(){
        TestApp.getInstance().waitUntilNextElementAppears(By.id("username"),20);
        String username = property.getProperty("user","employeeusername");
        userName.sendKeys(username);
        TestApp.getInstance().waitUntilNextElementAppears(By.name("pwd"),20);
        String passwordData = property.getProperty("user","employeepassword");
        password.sendKeys(passwordData);
        loginButton.click();
        boolean popUpDisplay = TestApp.getInstance().isElementPresent(By.xpath("//*[@id= 'welcomeScreenLightbox_content']"));

        if(popUpDisplay == true)
            welcomeScreenCloseBtn.click();
        TestApp.getInstance().waitUntilNextElementAppears(By.id("logoutLink"),20);
        return PageFactory.initElements(TestApp.getInstance().getDriver(), HomeFactoryPage.class);

    }





}
