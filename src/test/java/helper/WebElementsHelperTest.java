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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.home.CCHomePage;
import pages.home.CCHomePageTest;
import pages.login.CCLoginPage;

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
    public void test_listVisibleElementsOnLoginPage() {
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
     * @throws InterruptedException
     */
    @Test
    public void testMouseOverElement() throws InterruptedException {
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

}