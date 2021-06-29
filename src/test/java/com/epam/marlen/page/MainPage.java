package com.epam.marlen.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {
    @FindBy(xpath = "//a[@href=\"/compose/\"]")
    WebElement composeLetter;

    @FindBy(xpath = "//input[@tabindex=\"100\"]")
    WebElement addresseeInputXpath;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(getDriver());

    public MainPage clickToComposeLetter() {
        waitForElementPresence(composeLetter);
        actions.click(composeLetter).build().perform();
        return this;
    }

    public boolean isLetterOpen() {
        waitForElementPresence(addresseeInputXpath);
        return isElementPresent(addresseeInputXpath);
    }
}
