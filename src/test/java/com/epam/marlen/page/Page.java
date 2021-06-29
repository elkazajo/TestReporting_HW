package com.epam.marlen.page;

import com.epam.marlen.report.MyLogs;
import org.apache.logging.log4j.core.util.FileUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class Page {
    private final WebDriver driver;
    private static final long TIMEOUT_IN_SECONDS = 10;
    private static final long MILLIS = 500;
    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public void waitForElementPresence(WebElement element) {
        new WebDriverWait(driver, TIMEOUT_IN_SECONDS).pollingEvery(Duration.ofMillis(MILLIS)).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid green'", element);
    }

    protected void unHighlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
    }

    protected void takeScreenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtil.copyFile(screenshot, copy);
            MyLogs.info("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
            MyLogs.error("Failed to make screenshot");
        }
    }
}
