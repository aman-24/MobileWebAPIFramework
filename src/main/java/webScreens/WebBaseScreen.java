package webScreens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtils;

public class WebBaseScreen {

    public WebDriver webDriver;
    public WebUtils utils;

    public WebBaseScreen(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
        utils = new WebUtils(webDriver);
    }
}
