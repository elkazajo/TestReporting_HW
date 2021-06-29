package com.epam.marlen.page;

import com.epam.marlen.report.MyLogs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    private static final String MAIL_URL = "https://mail.ru/";

    @FindBy(xpath = "//input[@name=\"login\"]")
    WebElement loginInputForm;

    @FindBy(xpath = "//button[@data-testid=\"enter-password\"]")
    WebElement loginButton;

    @FindBy(xpath = "//input[@data-testid=\"password-input\"]")
    WebElement passwordInputForm;

    @FindBy(xpath = "//button[@data-testid=\"login-to-mail\"]")
    WebElement enterButton;

    @FindBy(xpath = "//a[@href=\"/compose/\"]")
    WebElement composeLetter;

    Actions actions = new Actions(getDriver());

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputUserName(String userName) {
        MyLogs.info("Clicking on username form");
        highlightElement(loginInputForm);
        actions.click(loginInputForm).build().perform();
        takeScreenshot();
        MyLogs.info("Typing username: " + userName);
        actions.sendKeys(userName).build().perform();
        takeScreenshot();
        unHighlightElement(loginInputForm);
        return this;
    }

    public LoginPage enterPasswordButton() {
        MyLogs.info("Clicking enter password button");
        highlightElement(enterButton);
        takeScreenshot();
        unHighlightElement(enterButton);
        actions.click(enterButton).build().perform();
        return this;
    }

    public LoginPage inputPassword(String userPassword) {
        waitForElementPresence(passwordInputForm);
        MyLogs.info("Clicking on password form");
        highlightElement(passwordInputForm);
        actions.click(passwordInputForm).build().perform();
        takeScreenshot();
        MyLogs.info("Entering password: " + userPassword);
        actions.sendKeys(userPassword).build().perform();
        takeScreenshot();
        unHighlightElement(passwordInputForm);
        return this;
    }

    public LoginPage clickLoginButton() {
        MyLogs.info("Clicking log in button");
        highlightElement(loginButton);
        actions.click(loginButton).build().perform();
        takeScreenshot();
        unHighlightElement(loginButton);
        return this;
    }

    public boolean verifyLoginSuccess() {
        waitForElementPresence(composeLetter);
        MyLogs.info("Checking if the Compose Letter button is visible");
        highlightElement(composeLetter);
        takeScreenshot();
        unHighlightElement(composeLetter);
        return isElementPresent(composeLetter);
    }

    public LoginPage openPage() {
        MyLogs.info("Navigating to " + MAIL_URL);
        getDriver().get(MAIL_URL);
        getDriver().manage().window().maximize();
        return this;
    }

    public LoginPage kill() {
        getDriver().quit();
        return this;
    }
}
