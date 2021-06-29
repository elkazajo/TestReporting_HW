package com.epam.marlen.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FolderPage extends Page {
    @FindBy(xpath = "//div[@class=\"new-folder-btn__button-wrapper\"]")
    WebElement newFolderCreator;

    @FindBy(xpath = "//input[@data-com.epam.marlen.test-id=\"name\"]")
    WebElement newFolderNamingForm;

    @FindBy(xpath = "//button[@data-com.epam.marlen.test-id=\"submit\"]")
    WebElement createNewFolderButton;

    @FindBy(xpath = "//div[@class=\"nav__folder-name__txt\" and text()=\"Test Folder\"]")
    WebElement createdFolder;

    @FindBy(xpath = "//a[@href=\"/tomyself/\"]")
    WebElement sentToMySelf;

    @FindBy(xpath = "//a[@tabindex=\"-1\"][1]")
    WebElement letter;

    @FindBy(xpath = "//div[@class=\"layer__submit-button\"]")
    WebElement folderDeleteButton;

    @FindBy(xpath = "//span[text()=\"Удалить папку\"]")
    WebElement deleteAtContext;

    Actions actions = new Actions(getDriver());

    public FolderPage(WebDriver driver) {
        super(driver);
    }

    public FolderPage clickToCreateNewFolder() {
        waitForElementPresence(newFolderCreator);
        actions.click(newFolderCreator).build().perform();
        return this;
    }

    public FolderPage nameNewFolder(String name) {
        waitForElementPresence(newFolderNamingForm);
        actions.click(newFolderNamingForm).build().perform();
        actions.sendKeys(name).build().perform();
        return this;
    }

    public FolderPage createNewFolder() {
        actions.click(createNewFolderButton).build().perform();
        return this;
    }

    public FolderPage openSentToMySelf() {
        actions.click(sentToMySelf).build().perform();
        return this;
    }

    public FolderPage dragLetterToNewFolder() {
        int x = 52;
        int y = 330;
        waitForElementPresence(letter);
        actions.click(letter).build().perform();
        actions.dragAndDropBy(letter,x, y).build().perform();
        return this;
    }

    public FolderPage deleteFolder() {
        waitForElementPresence(createdFolder);
        actions.contextClick(createdFolder).perform();
        waitForElementPresence(deleteAtContext);
        deleteAtContext.click();
        waitForElementPresence(folderDeleteButton);
        actions.click(folderDeleteButton).build().perform();
        return this;
    }

    public boolean isFolderDeleted() {
        return isElementPresent(createdFolder);
    }
}
