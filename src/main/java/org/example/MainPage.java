package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class MainPage extends BasePage {
    @FindBy(linkText = "Sukurti naują paskyrą")
    private WebElement linkCreateAccount;
    @FindBy(xpath = "//input[@name = 'username']")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@type ='submit']")
    private WebElement buttonLogin;
    @FindBy(css = "div span:first-of-type")
    private WebElement logoutMessage;

    @FindBy(css = "div span:last-of-type")
    private WebElement credentialsError;

    public String getCredentialsErrorMessageText() {
        return credentialsError.getText();
    }
    public String getLogoutMessageText() {
        return logoutMessage.getText();
    }
    public void typeUserName(String name) {
        inputUsername.sendKeys(name);
    }
    public void typePassword(String password) {
        inputPassword.sendKeys(password);
    }
    public void goToCreateAnAccount() {
        linkCreateAccount.click();
    }

    public void clickLogin() {
        buttonLogin.click();
    }
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
    }
}