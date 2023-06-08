package ide;

import claimcenter.CCLoginPage;
import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UnverifiedPolicyFNOLTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() throws IOException {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void unverifiedPolicyFNOL() throws IOException, InterruptedException {
        CCLoginPage.doLogin();
        driver.get("http://localhost:8080/cc/ClaimCenter.do");
        driver.manage().window().setSize(new Dimension(1936, 900));
        driver.findElement(By.xpath("//div[@id=\'TabBar-ClaimTab\']/div[3]/div")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\'gw-icon gw-icon--expand\']")));
        }
        driver.findElement(By.xpath("//*[@id=\"TabBar-ClaimTab\"]/div[3]")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"TabBar-ClaimTab-ClaimTab_FNOLWizard\"]/div")));
        }
        driver.findElement(By.xpath("//*[@id=\"TabBar-ClaimTab-ClaimTab_FNOLWizard\"]/div")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"TabBar-ClaimTab-ClaimTab_FNOLWizard\"]/div/div[2]")));
        }
        driver.findElement(By.xpath("//div[@id=\'TabBar-ClaimTab-ClaimTab_FNOLWizard\']/div/div[2]")).click();
    }
}
