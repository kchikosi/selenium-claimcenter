package pages.fnol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePolicyStepOnePage {
    //locators by xpath
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-ScreenMode_0\"]")
    private WebElement byXPathFindPolicy;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-ScreenMode_1\"]")
    private WebElement byXPathCreatePolicy;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-ClaimLossType_0\"]")
    private WebElement byXPathClaimLossTypeAuto;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-ClaimLossType_1\"]")
    private WebElement byXPathClaimLossTypeHomeOwners;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-ClaimLossType_2\"]")
    private WebElement getByXPathClaimLossTypeOceanMarine;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-ClaimLossType_3\"]")
    private WebElement getByXPathClaimLossTypeExcessLiability;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_LossDate\"]")
    private WebElement byXPathClaimLossDate;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_lossTime\"]/div/input[1]")
    private WebElement byXPathClaimLossTime;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_lossTime\"]/div/input[2]")
    private WebElement byXPathAmPmInput;
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
    @FindBy(xpath = "//*[@id=\"gw-datePicker\"]/div[2]/div[1]")
    private WebElement byXPathDatePickerToday;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_lossTimeZone\"]/div/div/select")
    private WebElement byXPathLossTimeZone;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Type\"]/div/div/select")
    private WebElement byXPathPolicyTypePicker;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-Cancel\"]/div/div[2]")
    private WebElement byXPathCancelButton;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-Next\"]")
    private WebElement byXpathNextButton;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-lossTypeSection-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-1\"]/div[1]")
    private WebElement byXPathBasicInformationLabel;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-OriginalLegacyFile_1\"]")
    private WebElement byXPathOriginalLegacyFileNoButton;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-OriginalLegacyFile_0\"]")
    private WebElement byXPathOriginalLegacyFileYesButton;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-lossTypeSection-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-EffectiveDate_dateIcon\"]")
    private WebElement byXPathEffectiveDatePicker;
    @FindBy(xpath = "//*[@id=\"gw-datePicker\"]/div[2]/div[1]")
    private WebElement byXPathEffectiveDatePickerToday;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-lossTypeSection-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-ExpirationDate_dateIcon\"]")
    private WebElement byXPathExpirationDatePicker;
    @FindBy(xpath = "//*[@id=\"gw-datePicker\"]/div[2]/div[1]")
    private WebElement byXPathExpirationDatePickerToday;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-lossTypeSection-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name-Insured_NameMenuIcon\"]/div[1]")
    private WebElement insuredToggleSubMenu;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-lossTypeSection-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name-ClaimNewContactPickerMenuItemSet-NewContactPickerMenuItemSet_NewPerson\"]")
    private WebElement newPerson;
    /**
     * constructor
     *
     * @param driver web driver
     */
    public CreatePolicyStepOnePage(WebDriver driver) {
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public WebElement getByXPathFindPolicy() {
        return byXPathFindPolicy;
    }

    public WebElement getByXPathCreatePolicy() {
        return byXPathCreatePolicy;
    }

    public WebElement getByXPathClaimLossTypeAuto() {
        return byXPathClaimLossTypeAuto;
    }

    public WebElement getByXPathClaimLossTypeHomeOwners() {
        return byXPathClaimLossTypeHomeOwners;
    }

    public WebElement getGetByXPathClaimLossTypeOceanMarine() {
        return getByXPathClaimLossTypeOceanMarine;
    }

    public WebElement getGetByXPathClaimLossTypeExcessLiability() {
        return getByXPathClaimLossTypeExcessLiability;
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

    public WebElement getByXPathDatePickerToday() {
        return byXPathDatePickerToday;
    }

    public WebElement getByXPathLossTimeZone() {
        return byXPathLossTimeZone;
    }

    public WebElement getByXPathPolicyTypePicker() {
        return byXPathPolicyTypePicker;
    }

    public WebElement getByXPathCancelButton() {
        return byXPathCancelButton;
    }

    public WebElement getByXpathNextButton() {
        return byXpathNextButton;
    }

    public WebElement getByXPathBasicInformationLabel() {
        return byXPathBasicInformationLabel;
    }

    public WebElement getByXPathOriginalLegacyFileYesButton() {
        return byXPathOriginalLegacyFileYesButton;
    }

    public WebElement getByXPathOriginalLegacyFileNoButton() {
        return byXPathOriginalLegacyFileNoButton;
    }

    public WebElement getByXPathEffectiveDatePicker() {
        return byXPathEffectiveDatePicker;
    }

    public WebElement getByXPathEffectiveDatePickerToday() {
        return byXPathEffectiveDatePickerToday;
    }

    public WebElement getByXPathExpirationDatePicker() {
        return byXPathExpirationDatePicker;
    }

    public WebElement getByXPathExpirationDatePickerToday() {
        return byXPathExpirationDatePickerToday;
    }

    public WebElement getInsuredToggleSubMenu() {
        return insuredToggleSubMenu;
    }

    public WebElement getNewPerson() {
        return newPerson;
    }
}
