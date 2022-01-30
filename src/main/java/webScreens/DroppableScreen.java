package webScreens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppableScreen extends WebBaseScreen{


    @FindBy(xpath = "//iframe[@class='demo-frame']")
    private WebElement frmDemoFrame;

    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement eleDraggable;

    @FindBy(xpath = "//div[@id='droppable']")
    private WebElement eleDroppable;

    @FindBy(xpath = "//p[normalize-space()='Dropped!']")
    private WebElement eleDropped;

    public DroppableScreen(WebDriver driver) {
        super(driver);
    }

    public void dragAndDrop(){
        webDriver.switchTo().frame(frmDemoFrame);
        utils.dragAndDrop(eleDraggable, eleDroppable);
        utils.waitUntilVisible(eleDropped, 3);
    }
}
