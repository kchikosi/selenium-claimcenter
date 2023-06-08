package pages.admin;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.login.CCLoginPage;

import java.util.concurrent.TimeUnit;

public class NewGroupPageTest {
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
    public void addGroup() throws InterruptedException {
        login();
        NewGroupPage groupPage = new NewGroupPage(driver);
        groupPage.actions.click();
        groupPage.newGroup.click();
        Thread.sleep(5000);
    }

    private void login() throws InterruptedException {
        CCLoginPage ccLoginPage = new CCLoginPage(driver);
        ccLoginPage.setByXPathUsername("su");
        ccLoginPage.setByXPathPassword("gw");
        ccLoginPage.byXPathClickLogin();
        Thread.sleep(5000);
    }
}