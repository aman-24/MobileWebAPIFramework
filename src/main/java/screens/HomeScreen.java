package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomeScreen extends MobileBaseScreen {

    @AndroidFindBy(id = "android:id/title")
    private MobileElement eleTitle;

    @AndroidFindBy(id = "io.selendroid.testapp:id/buttonTest")
    private MobileElement btnEnButton;

    @AndroidFindBy(id = "android:id/button2")
    private MobileElement btnNono;

    @AndroidFindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
    private MobileElement btnChrome;

    @AndroidFindBy(id = "io.selendroid.testapp:id/startUserRegistration")
    private MobileElement btnRegisterUser;

    @AndroidFindBy(id = "io.selendroid.testapp:id/my_text_field")
    private MobileElement txtTextField;

    @AndroidFindBy(id = "io.selendroid.testapp:id/waitingButtonTest")
    private MobileElement btnProgressbar;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement eleHeading;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"l10nCD\"]/android.widget.TextView")
    private MobileElement eleLocalizationText;


    // ------------------PAGE FACTORY--------------------------//
    public HomeScreen(AppiumDriver<MobileElement> appDriver) {
        super(appDriver);
    }

    public void verifyHomeTile(){
        String title = "selendroid-test-app";
        util.waitUntilVisible(eleTitle, 3);
        Assert.assertTrue(util.validateAndGetText(eleTitle).equals(title), "Title doesn't match");
    }

    public void clickEnButton(){
        util.validateAndClick(btnEnButton);
    }
    public void clickChromeButton(){
        util.validateAndClick(btnChrome);
    }

    public void clickNono(){
        util.waitUntilClickable(btnNono, 3);
        util.validateAndClick(btnNono);
    }

    public void isUserAtHome(boolean atHome){
        Assert.assertEquals(eleHeading.isDisplayed(), atHome, "User location doesn't match expected");
    }

    public void validatesHomeScreenElements(){
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(btnChrome.isDisplayed(), "Chrome button is not displayed");
        sa.assertTrue(btnEnButton.isDisplayed(), "EN Butoon is not displayed");
        sa.assertTrue(btnRegisterUser.isDisplayed(), "Register user button is not displayed");
        sa.assertTrue(btnProgressbar.isDisplayed(), "Progress bar button is not displayed");
        sa.assertTrue(txtTextField.isDisplayed(), "Text feild is not displayed");
        sa.assertTrue(eleLocalizationText.isDisplayed(), "Localization text is not displayed");
        sa.assertAll();
    }
}
