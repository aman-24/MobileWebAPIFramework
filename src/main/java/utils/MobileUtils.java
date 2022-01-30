package utils;

import io.appium.java_client.*;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;

public class MobileUtils {
    public AppiumDriver<MobileElement> appDriver;

    public MobileUtils(AppiumDriver<MobileElement> appDriver){
        this.appDriver = appDriver;
    }

    //Up-Down Swipe Functionality
    public void swipeUpDown(int start, int end, int anchor) {
        TouchAction action = new TouchAction(appDriver);
        action.longPress(point(anchor, start)).moveTo(PointOption.point(anchor, end)).release().perform();
    }

    public void findElementByTextOnPage(String text) {
        appDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(android.widget.EditText)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))"));

    }

    public void scrollTo(String text) {
        ((FindsByAndroidUIAutomator) appDriver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))");
    }

    public void scrollToElement(String text) {
        ((FindsByAndroidUIAutomator) appDriver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).setMaxSearchSwipes(10)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))");
    }


    public void validateAndAcceptAlert(AppiumDriver<MobileElement> appDriver) {
        try {
            Alert alert = appDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            throw new RuntimeException("alert is either not displayed or it is not an alert");
        }
    }

    public void validateAndDismissAlert() {
        try {
            Alert alert = appDriver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            throw new RuntimeException("alert is either not displayed or it is not an alert");
        }
    }

    public void validateAndSendKeys(MobileElement element, String value) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.clear();
            element.sendKeys(value);
        } else throw new RuntimeException("element is either not displayed or enabled");
    }

    public void validateAndClick(MobileElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        } else throw new RuntimeException("element is either not displayed or enabled");
    }

    public String validateAndGetText(MobileElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            return element.getText();
        } else throw new RuntimeException("element is either not displayed or enabled");
    }

    public static String validateAndGetAttribute(MobileElement element, String attribute) {
        if (element.isDisplayed() && element.isEnabled()) {
            return element.getAttribute(attribute);
        } else throw new RuntimeException("element is either not displayed or enabled");
    }


    public void waitUntilVisible(MobileElement element, int timeOutInSec) {
        try {
            FluentWait<AppiumDriver> fWait = new FluentWait<AppiumDriver>(appDriver)
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
            FluentWait<AppiumDriver> fWait = new FluentWait<AppiumDriver>(appDriver)
                    .withTimeout(Duration.ofSeconds(timeOutInSec))
                    .pollingEvery(Duration.ofMillis(50))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            fWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new RuntimeException("element is either not displayed or enabled");
        }
    }
}
