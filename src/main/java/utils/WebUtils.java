package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WebUtils {
    public WebDriver webDriver;

    public WebUtils(WebDriver driver){
        this.webDriver = driver;
    }

    public void validateAndAcceptAlert(WebDriver webDriver) {
        try {
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            throw new RuntimeException("alert is either not displayed or it is not an alert");
        }
    }

    public void validateAndDismissAlert() {
        try {
            Alert alert = webDriver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            throw new RuntimeException("alert is either not displayed or it is not an alert");
        }
    }

    public void validateAndSendKeys(WebElement element, String value) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.clear();
            element.sendKeys(value);
        } else throw new RuntimeException("element is either not displayed or enabled");
    }

    public void validateAndClick(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        } else throw new RuntimeException("element is either not displayed or enabled");
    }

    public String validateAndGetText(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            return element.getText();
        } else throw new RuntimeException("element is either not displayed or enabled");
    }

    public static String validateAndGetAttribute(WebElement element, String attribute) {
        if (element.isDisplayed() && element.isEnabled()) {
            return element.getAttribute(attribute);
        } else throw new RuntimeException("element is either not displayed or enabled");
    }


    public void waitUntilVisible(WebElement element, int timeOutInSec) {
        try {
            FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(webDriver)
                    .withTimeout(Duration.ofSeconds(timeOutInSec))
                    .pollingEvery(Duration.ofMillis(50))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            fWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            throw new RuntimeException("element is either not displayed or enabled");
        }
    }

    public void waitUntilClickable(WebElement element, int timeOutInSec) {
        try {
            FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(webDriver)
                    .withTimeout(Duration.ofSeconds(timeOutInSec))
                    .pollingEvery(Duration.ofMillis(50))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            fWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new RuntimeException("element is either not displayed or enabled");
        }
    }

    public void dragAndDrop(WebElement fromElement, WebElement toElement){
        Actions builder = new Actions(webDriver);
        Action dragAndDrop = builder.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release(toElement)
                .build();
        dragAndDrop.perform();
    }
}
