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
import pages.home.CCHomePageTest;

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
    public void test_listVisibleElements() {
        WebElementsHelper helper = new WebElementsHelper(driver);
        By xPath = By.xpath("//*[@id]");
        boolean result = helper.listVisibleElements(xPath);
        Assert.assertTrue(result);
    }
}