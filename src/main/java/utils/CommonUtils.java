package utils;

import base.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CommonUtils {
    public static AppiumDriver<MobileElement> appDriver;
    public static WebDriver webDriver;
    DesiredCapabilities capabilities = new DesiredCapabilities();


    /**
     * Setting the Desired Capabilities for Requesting the automation server
     */
    public void launchMobileDriver() throws Exception {

        AppiumServer.start();
        switch (ConfigProperties.platform.toLowerCase()) {
            case "android":
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigProperties.platform);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigProperties.deviceName);
                capabilities.setCapability(MobileCapabilityType.NO_RESET, ConfigProperties.noReset);
//                capabilities.setCapability(MobileCapabilityType.APP, ConfigProperties.androidApp);
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ConfigProperties.activityName);
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ConfigProperties.packageName);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigProperties.platformVersion);
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
                capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

                appDriver = new AndroidDriver(AppiumServer.getAppiumUrl(), capabilities);
                break;
            default:
                throw new Exception("Platform not available");
        }
        appDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void launchWebDriver() throws Exception {
        switch (ConfigProperties.browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", ConfigProperties.chromeDriverLocation);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                webDriver = new ChromeDriver(options);
                break;

            default:
                throw new Exception("Browser not found");
        }
    }

}
