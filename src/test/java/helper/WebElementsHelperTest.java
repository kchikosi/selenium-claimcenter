package helper;

import environment.EnvironmentManager;
import environment.RunEnvironment;
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
import pages.home.CCHomePageTest;
import pages.login.CCLoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebElementsHelperTest {
    private static final Logger LOGGER = LogManager.getLogger(CCHomePageTest.class.getName());
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
    public void test_listVisibleElementsOnLoginPage() throws IOException, InterruptedException {
        CCLoginPage page = new CCLoginPage(driver);
        page.setByXPathUsername("su");
        page.setByXPathPassword("gw");
        page.byXPathClickLogin();
        WebElementsHelper helper = new WebElementsHelper(driver);
        By xPath = By.xpath("//*[@id]");
        boolean result = helper.listVisibleElements(xPath);
        Assert.assertTrue(result);
    }

    /**
     * Test mouse over
     *
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void testMouseOverElement() throws IOException, InterruptedException {
        CCLoginPage page = new CCLoginPage(driver);
        page.setByXPathUsername("su");
        page.setByXPathPassword("gw");
        page.byXPathClickLogin();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#DesktopActivities-DesktopActivitiesScreen-0 > div.gw-TitleBar--titles--container")));

        }
        CCHomePage homePage = new CCHomePage(driver);
        WebElementsHelper helper = new WebElementsHelper(driver);
        By by = By.xpath("//*[@id=\"TabBar\"]/div[2]");
        helper.performActionMoveToElement(by);
        Thread.sleep(100);
    }

    /**
     * test create new FNOL
     */
    //TODO: move to new test class
    @Test
    public void test_CreateNewClaim() {
        Actions actions;
        CCLoginPage page = new CCLoginPage(driver);
        page.setByXPathUsername("su");
        page.setByXPathPassword("gw");
        page.byXPathClickLogin();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#DesktopActivities-DesktopActivitiesScreen-0 > div.gw-TitleBar--titles--container")));

        }
        CCHomePage homePage = new CCHomePage(driver);
        //Step one: click more options dropdown
        WebElementsHelper helper = new WebElementsHelper(driver);
        By tabBarWidget = By.xpath("//*[@id=\"TabBar\"]/div[2]");
        helper.performActionMoveToElement(tabBarWidget);
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(homePage.getByXPathTabBarWidget()));

        }
        //Step two: move options dropdown
        By moreOptions = By.xpath("//*[@id=\"TabBarWidget--more-options\"]");
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(homePage.getByXPathTabBarWidget()));

        }
        //Step three: click on more options
        actions = helper.moveToElement(moreOptions, driver);
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
        actions = helper.moveToElement(newClaimFile, driver);
        if (homePage.getByXPathNewClaim().isDisplayed()) {
            actions.click().build().perform();
        } else {
            LOGGER.error("Element not displayed");
        }
        LOGGER.trace("Completed successfully");
    }

}