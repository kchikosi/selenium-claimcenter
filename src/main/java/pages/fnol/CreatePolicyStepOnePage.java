package pages.fnol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePolicyStepOnePage {
    private static final String loginPageUrl = "http://localhost:8080/cc/ClaimCenter.do";
    //locators by xpath
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-ScreenMode_0\"]")
    private WebElement byXPathFindPolicy;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-ScreenMode_1\"]")
    private WebElement byXPathCreatePolicy;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-ClaimLossType_0\"]")
    private WebElement byXPathClaimLossType;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_LossDate\"]")
    private WebElement byXPathClaimLossDate;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_lossTime\"]/div/input[1]")
    private WebElement byXPathClaimLossTime;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_lossTime\"]/div/input[2]")
    private WebElement byXPathAmPmInput;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_lossTimeZone\"]/div/div/select")
    private WebElement byXPathTimeZoneSelect;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-PolicyNumber\"]/div/input")
    private WebElement byXPathPolicyNumber;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Type\"]/div/div/select")
    private WebElement byXPathPolicyTypeSelect;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-OriginalLegacyFile_0\"]")
    private WebElement byXPathOriginalLegacyFileYesRadioButton;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-OriginalLegacyFile_1\"]")
    private WebElement byXPathOriginalLegacyFileNoRadioButton;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-Cancel\"]/div/div[2]")
    private WebElement byXPathCancel;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-Cancel\"]/div/div[2]")
    private WebElement byXPathNext;


    /**
     * constructor
     * @param driver web driver
     */
    public CreatePolicyStepOnePage(WebDriver driver) {
        driver.get(loginPageUrl);
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public WebElement getByXPathFindPolicy() {
        return byXPathFindPolicy;
    }

    public WebElement getByXPathCreatePolicy() {
        return byXPathCreatePolicy;
    }

    public WebElement getByXPathClaimLossType() {
        return byXPathClaimLossType;
    }

    public WebElement getByXPathClaimLossDate() {
        return byXPathClaimLossDate;
    }

    public WebElement getByXPathClaimLossTime() {
        return byXPathClaimLossTime;
    }

    public WebElement getByXPathAmPmInput() {
        return byXPathAmPmInput;
    }

    public WebElement getByXPathTimeZoneSelect() {
        return byXPathTimeZoneSelect;
    }

    public WebElement getByXPathPolicyNumber() {
        return byXPathPolicyNumber;
    }

    public WebElement getByXPathPolicyTypeSelect() {
        return byXPathPolicyTypeSelect;
    }

    public WebElement getByXPathOriginalLegacyFileYesRadioButton() {
        return byXPathOriginalLegacyFileYesRadioButton;
    }

    public WebElement getByXPathOriginalLegacyFileNoRadioButton() {
        return byXPathOriginalLegacyFileNoRadioButton;
    }

    public WebElement getByXPathCancel() {
        return byXPathCancel;
    }

    public WebElement getByXPathNext() {
        return byXPathNext;
    }
}
