package pages.home;

import claimcenter.CCLoginPage;
import environment.EnvironmentManager;
import environment.RunEnvironment;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.JavaScriptUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CCHomePageTest extends TestCase {
    private static final Logger LOGGER = LogManager.getLogger(CCHomePageTest.class.getName());
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        EnvironmentManager.shutDownDriver();
    }

    @Test
    public void test_MoreOptionsDropDown() throws IOException, InterruptedException {
        CCLoginPage.doLogin();
        CCHomePage homePage = new CCHomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"gw-center-tab-bar\"]")));
        JavaScriptUtil.jsSafeClick(homePage.getCenterTabBar(), driver);
        LOGGER.info("Center tab " +  homePage.getCenterTabBar().getAttribute("id") );

    }
}