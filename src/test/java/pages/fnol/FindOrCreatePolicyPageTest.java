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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.home.CCHomePage;
import pages.login.CCLoginPage;

import java.util.concurrent.TimeUnit;

public class FindOrCreatePolicyPageTest {
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

    /**
     * test create new FNOL
     * note that this test ends at step 1, search or create policy
     */
    @Test
    public void test_CreateNewClaim() throws InterruptedException {
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
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(homePage.getByXPathTabBarWidget()));

        }
        //Step three: click on more options
        actions = helper.moveToElement(moreOptions);
        actions.click().build().perform();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(homePage.getByXPathClaimFile()));
        }
        //Step four: click claim file
        By claimFile = By.xpath("//*[@id=\"TabBar-ClaimTab\"]/div[1]/div[2]");
        helper.performActionMoveToElement(claimFile);
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(homePage.getByXPathNewClaim()));
        }
        //Step five: move to new claim file option
        By newClaimFile = By.xpath("//*[@id=\"TabBar-ClaimTab-ClaimTab_FNOLWizard\"]/div/div[2]");
        actions = helper.moveToElement(newClaimFile);
        if (homePage.getByXPathNewClaim().isDisplayed()) {
            actions.click().build().perform();
        } else {
            LOGGER.error("Element not displayed");
        }
        Thread.sleep(150);
        LOGGER.trace("Completed successfully");
    }

    /**
     * End to end create an FNOL from an unverified policy
     */
    @Test
    public void test_CreateUnverifiedPolicy() throws InterruptedException {
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
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(homePage.getByXPathTabBarWidget()));

        }

        //Step three: click on more options
        actions = helper.moveToElement(moreOptions);
        actions.click().build().perform();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(homePage.getByXPathClaimFile()));
        }

        //Step four: click claim file
        By claimFile = By.xpath("//*[@id=\"TabBar-ClaimTab\"]/div[1]/div[2]");
        helper.performActionMoveToElement(claimFile);
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(homePage.getByXPathNewClaim()));
        }

        //Step five: move to new claim file option
        By newClaimFile = By.xpath("//*[@id=\"TabBar-ClaimTab-ClaimTab_FNOLWizard\"]/div/div[2]");
        actions = helper.moveToElement(newClaimFile);
        Assert.assertTrue(homePage.getByXPathNewClaim().isDisplayed());
        actions.click().build().perform();


        //Step six: create unverified or unverified policy
        // FIXME: 6/13/2023 asking to reload page
        FindOrCreatePolicyPage findOrCreatePolicyPage = new FindOrCreatePolicyPage(driver);
        By createPolicy = By.xpath("//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-ScreenMode_1\"]");
        actions = helper.moveToElement(createPolicy);
        Assert.assertTrue(findOrCreatePolicyPage.getByXPathCreatePolicyRadioButton().isDisplayed());
        actions.click().build().perform();

        Thread.sleep(150);
        LOGGER.trace("Completed successfully");
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