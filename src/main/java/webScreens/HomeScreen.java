package webScreens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen extends WebBaseScreen{

    @FindBy(css = "a[href='https://jqueryui.com/demos/']")
    private WebElement lnkDemos;

    @FindBy(xpath = "//aside[@class='widget']//a[normalize-space()='Draggable']")
    private WebElement lnkDraggable;

    @FindBy(xpath = "//a[normalize-space()='Droppable']")
    private WebElement lnkDroppable;

    public HomeScreen(WebDriver driver) {
        super(driver);
    }

    public void clickDemos(){
    utils.validateAndClick(lnkDemos);
    }

    public void clickDraggable(){
        utils.validateAndClick(lnkDraggable);
    }

    public void clickDroppable(){
        utils.validateAndClick(lnkDroppable);
    }
}
