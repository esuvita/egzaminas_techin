package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{
    @FindBy(id = "username")
    private WebElement inputUserName;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(id = "passwordConfirm")
    private WebElement inputConfirmPassword;
    @FindBy(xpath = "//button[@type ='submit']")
    private WebElement buttonCreateAnAccount;
    @FindBy(id = "passwordConfirm.errors")
    private WebElement passwordErrorMessage;

    public void typeUserName(String name) {
        inputUserName.sendKeys(name);
    }
    public void typePassword(String password) {
        inputPassword.sendKeys(password);
    }
    public void confirmPassword(String password) {
        inputConfirmPassword.sendKeys(password);
    }
    public void clickSubmit() {
        buttonCreateAnAccount.click();
    }
    public String getPasswordErrorText() {
        return passwordErrorMessage.getText();
    }
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }
}
