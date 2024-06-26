package pages.fnol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindOrCreatePolicyPage {
    //locators by xpath
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-ScreenMode_0\"]")
    private WebElement byXPathFindPolicyRadioButton;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-ScreenMode_1\"]")
    private WebElement byXPathCreatePolicyRadioButton;

    /**
     * constructor
     * @param driver web driver
     */
    public FindOrCreatePolicyPage(WebDriver driver) {
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public WebElement getByXPathFindPolicyRadioButton() {
        return byXPathFindPolicyRadioButton;
    }

    public WebElement getByXPathCreatePolicyRadioButton() {
        return byXPathCreatePolicyRadioButton;
    }
}
