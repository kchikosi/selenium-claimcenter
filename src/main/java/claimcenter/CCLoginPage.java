package claimcenter;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CCLoginPage {
    public static void doLogin() throws IOException, InterruptedException {
        EnvironmentManager.initWebDriver();
        WebDriver driver = RunEnvironment.getWebDriver();
        pages.login.CCLoginPage loginPage = new pages.login.CCLoginPage(driver);
        loginPage.setByXPathUsername("su");
        loginPage.setByXPathPassword("gw");
        loginPage.byXPathClickLogin();
        Thread.sleep(5000);
    }
}
