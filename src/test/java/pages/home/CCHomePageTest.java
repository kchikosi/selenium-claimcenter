package pages.home;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import util.JavaScriptUtil;

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
    public void test_HomePageIsOpened() {

    }

}