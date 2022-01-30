package mobileScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MobileUtils;

public class MobileBaseScreen {

    public AppiumDriver<MobileElement> appDriver;
    public MobileUtils util;

    public MobileBaseScreen(AppiumDriver<MobileElement> appDriver) {
        this.appDriver = appDriver;
        util = new MobileUtils(appDriver);
        PageFactory.initElements(new AppiumFieldDecorator(appDriver), this);
    }
}
