package com.test.nhs.stepdefinitions;

import com.test.nhs.utils.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class Hook {


    //    public WebDriver driver;
    WebDriver driver = DriverHelper.getDriver();

    //make sure you import it from io.cucumber.java.
    @Before
    public void beforeScenario (){
        //System.out.println("before scenario");
//        driver.navigate().to(ConfigReader.readProperty("nhs_url"));

        //we can move these lines of code to DriverHelper
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();//for fresh start(testing)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //make sure you import it from io.cucumber.java.
    @After
    public void afterScenario(Scenario scenario){
        //System.out.println("after scenario");

        Date currentDate = new Date();
        String screenshotFileName = currentDate.toString().replace(" ", "-")
                .replace(":", "-");
        if(scenario.isFailed()){
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile, new File("src/test/java/screenshot/" + screenshotFileName + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        //for screenshots we can also use:
//       BrowserUtils.getScreenShot(driver,"nhs");


        DriverHelper.tearDown();
    }



}
