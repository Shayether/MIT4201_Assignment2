package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class TestApp {

    public WebDriver driver;

    public static Logger log = LogManager.getLogger();

    public static TestApp myObj;

    //create propertyFileReader page object to access the getproperty method
    PropertyFileReader property = new PropertyFileReader();

    //return TestApp object instance
    public static TestApp getInstance(){
        if(myObj == null)
        {
            myObj = new TestApp();
            return myObj;
        }
        else
        {
            return myObj;
        }
    }

    //get the selenium driver (page factory model)
    public WebDriver getDriver(){
        return driver;
    }

    //when selenium opens the browsers it will automatically set the web driver
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    //when selenium opens the browsers it will automatically set the test app instance to access details
    public static void setMyObj(TestApp myObj){
        TestApp.myObj = myObj;
    }

    //open web browser automatically
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", getChromeDriverFilePath());

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    private String getChromeDriverFilePath(){
        URL res = getClass().getClassLoader().getResource("chromedriver.exe");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }


    //Open the site
    public void navigateToURL(){
        // String url = "https://demo.actitime.com/login.do";

        String url =property.getProperty("config","url");
        driver.get(url);
    }

    //close browser
    public void closeBrowser(){
        driver.quit();
    }

    //wait method to wait until the element visible
    public WebElement waitUntilNextElementAppears(By locator, int timeout){
        WebElement element = new WebDriverWait(TestApp.getInstance().getDriver(), timeout ).until
                (ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }


    //send texts to the web element
    public void setText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }


    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    public void captureScreenshots(String fileName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) TestApp.getInstance().getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./screenshots/"+fileName+".jpg");
        try {
            FileUtils.copyFile(sourceFile, destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");





    }


}
