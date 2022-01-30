package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MobileUtil;

public class MobileBaseScreen {

    public AppiumDriver<MobileElement> appDriver;
    public MobileUtil util;

    public MobileBaseScreen(AppiumDriver<MobileElement> appDriver) {
        this.appDriver = appDriver;
        util = new MobileUtil(appDriver);
        PageFactory.initElements(new AppiumFieldDecorator(appDriver), this);
    }
}
