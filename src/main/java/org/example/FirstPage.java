package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends BasePage {
    @FindBy(linkText = "Skaičiuotuvas")
    private WebElement headerTextLink;

    @FindBy(css = "form~a")
    private WebElement logoutLink;

    public String getHeaderText() {
        return headerTextLink.getText();
    }

    public String getLogoutText() {
        return logoutLink.getText();
    }
    public void clickLogoutLink(){
        logoutLink.click();
    }

    public FirstPage(WebDriver driver) {
        super(driver);
    }
}
