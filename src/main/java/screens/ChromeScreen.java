package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChromeScreen extends MobileBaseScreen {

    @AndroidFindBy(xpath= "//android.webkit.WebView/android.webkit.WebView/android.widget.TextView")
    private MobileElement eleHelloText;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.EditText")
    private MobileElement txtName;


    // ------------------PAGE FACTORY--------------------------//
    public ChromeScreen(AppiumDriver<MobileElement> appDriver) {
        super(appDriver);
    }

    public void enterName(String name){
        util.validateAndSendKeys(txtName, name);
    }

}
