package com.test.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //====================================  elements ================================================

    @FindBy(id = "inputEmail")
    WebElement username;

    @FindBy(id = "inputPassword")
    WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
    WebElement signInButton;


    //==================================== methods ================================================

    public String usernameIsRequired(){
        return password.getAttribute("required");
    }

    public String passwordIsRequired(){
        return password.getAttribute("required");
    }

    public void login(String username, String password) throws InterruptedException {
        this.username.sendKeys(username);
        Thread.sleep(1000);
        this.password.sendKeys(password);
        Thread.sleep(1000);
        signInButton.click();
    }


}
