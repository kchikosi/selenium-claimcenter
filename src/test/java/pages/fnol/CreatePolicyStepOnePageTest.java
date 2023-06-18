package pages.fnol;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import helper.WebElementsHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.home.CCHomePage;
import pages.login.CCLoginPage;

import java.util.concurrent.TimeUnit;

public class CreatePolicyStepOnePageTest {
    private static final Logger LOGGER = LogManager.getLogger(FindOrCreatePolicyPageTest.class.getName());
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }

    @Test
    public void test_CreatePolicyStepOne() throws InterruptedException {
        doLoginPage();
        Actions actions;
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#DesktopActivities-DesktopActivitiesScreen-0 > div.gw-TitleBar--titles--container")));

        }
        CCHomePage homePage = new CCHomePage(driver);
        //Step one: click more options dropdown
        WebElementsHelper helper = new WebElementsHelper(driver);
        By tabBarWidget = By.xpath("//*[@id=\"TabBar\"]/div[2]");
        helper.performActionMoveToElement(tabBarWidget);

        //Step two: move options dropdown
        By moreOptions = By.xpath("//*[@id=\"TabBarWidget--more-options\"]");
        {
            waitUntilVisibilityOf(homePage.getByXPathTabBarWidget());

        }

        //Step three: click on more options
        actions = helper.moveToElement(moreOptions);
        actions.click().build().perform();
        {
            waitUntilVisibilityOf(homePage.getByXPathClaimFile());
        }

        //Step four: click claim file
        By claimFile = By.xpath("//*[@id=\"TabBar-ClaimTab\"]/div[1]/div[2]");
        helper.performActionMoveToElement(claimFile);
        {
            waitUntilVisibilityOf(homePage.getByXPathNewClaim());
        }

        //Step five: move to new claim file option
        By newClaimFile = By.xpath("//*[@id=\"TabBar-ClaimTab-ClaimTab_FNOLWizard\"]/div/div[2]");
        actions = helper.moveToElement(newClaimFile);
        Assert.assertTrue(homePage.getByXPathNewClaim().isDisplayed());
        actions.click().build().perform();


        // Step six: create unverified or unverified policy
        // Step seven: fill out Step One details
        CreatePolicyStepOnePage stepOnePage = new CreatePolicyStepOnePage(driver);
        By createPolicy = By.xpath("//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-ScreenMode_1\"]");
        actions = helper.moveToElement(createPolicy);
        actions.click().build().perform();
        //TODO: handle StaleElementReferenceException
        //Assert.assertTrue(stepOnePage.getByXPathCreatePolicy().isSelected());

        Assert.assertTrue(stepOnePage.getByXPathClaimLossTypeAuto().isSelected());
        // Step eight: loss date
        By lossDatePicker = By.xpath("//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_LossDate_dateIcon\"]");
        actions = helper.moveToElement(lossDatePicker);
        actions.click().build().perform();
        waitUntilVisibilityOf(stepOnePage.getByXPathDatePickerToday());
        By today = By.xpath("//*[@id=\"gw-datePicker\"]/div[2]/div[1]");
        actions = helper.moveToElement(today);
        actions.click().build().perform();

        // Step nine: loss time
        By lossTime = By.xpath("//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_lossTime\"]/div/input[1]");
        actions = helper.moveToElement(lossTime);
        actions.click().build().perform();
        stepOnePage.getByXPathClaimLossTime().sendKeys("12:00");

        By amPmButton = By.xpath("//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_lossTime\"]/div/input[2]");
        actions = helper.moveToElement(amPmButton);
        actions.click().build().perform();

        // Step ten: time zone select
        By timeZoneSelect = By.xpath("//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_lossTimeZone\"]/div/div/select");
        actions = helper.moveToElement(timeZoneSelect);
        actions.click().build().perform();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(stepOnePage.getByXPathLossTimeZone()));
        }
        Select timeZone = new Select(driver.findElement(timeZoneSelect));
        timeZone.selectByValue("US.Eastern");

        // Step eleven: policy number
        By policyNumber = By.xpath("//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-PolicyNumber\"]/div/input");
        helper.performActionMoveToElement(policyNumber);
        stepOnePage.getByXPathPolicyNumber().sendKeys("06182023KC");

        // Step twelve: policy type
        By policyTypeSelect = By.xpath("//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Type\"]/div/div/select");
        actions = helper.moveToElement(policyNumber);
        actions.click().build().perform();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(stepOnePage.getByXPathPolicyTypePicker()));
        }
        Select policyType = new Select(driver.findElement(policyTypeSelect));
        policyType.selectByValue("auto_per");

        // Step thirteen: basic information label should appear before next steps
        // Click on legacy Y button
        By legacyYesButton = By.xpath("//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-OriginalLegacyFile_0\"]");
        actions = helper.moveToElement(legacyYesButton);
        actions.click().build().perform();

        Thread.sleep(1000);

        By basicInfoLabel = By.xpath("//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-lossTypeSection-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-1\"]/div[1]");
        waitUntilVisibilityOf(stepOnePage.getByXPathBasicInformationLabel());

        //wait until Next button is enabled
        By nextButton = By.xpath("//*[@id=\"FNOLWizard-Next\"]");
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        }


        //Debug breakpoint
        Thread.sleep(150);
        LOGGER.trace("Completed successfully");
    }

    private void waitUntilVisibilityOf(WebElement datePickerToday) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(datePickerToday));
    }


    /**
     * private functions
     */
    private void doLoginPage() {
        CCLoginPage page = new CCLoginPage(driver);
        page.setByXPathUsername("su");
        page.setByXPathPassword("gw");
        page.byXPathClickLogin();
    }
}