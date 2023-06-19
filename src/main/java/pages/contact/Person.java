package pages.contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Person {
    //locators by xpath
    @FindBy(xpath = "//*[@id=\"NewContactPopup-ContactDetail2Screen-ttlBar\"]/div[1]/div")
    private WebElement pageTitle;
    @FindBy(xpath = "//*[@id=\"NewContactPopup-__crumb__\"]")
    private WebElement returnToStepOne;
    //TODO: add xpath for OK and Cancel button clicks
    @FindBy(xpath = "//*[@id=\"NewContactPopup-ContactDetail2Screen-ContactBasicsDV_tb-ex_ContactDetail2ToolbarButtonSet-Update\"]/div")
    private WebElement okButton;
    @FindBy(xpath = "//*[@id=\"NewContactPopup-ContactDetail2Screen-ContactBasicsDV_tb-ex_ContactDetail2ToolbarButtonSet-ex_ContactDetailCancelButton\"]/div")
    private WebElement cancelButton;

    /**
     * constructor
     * @param driver the driver
     */
    public Person(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getReturnToStepOne() {
        return returnToStepOne;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }
}
