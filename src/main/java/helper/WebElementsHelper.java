package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class WebElementsHelper {
    private static final Logger LOGGER = LogManager.getLogger(WebElementsHelper.class);
    private final WebDriver driver;

    public WebElementsHelper(WebDriver webDriver) {
        this.driver = webDriver;
    }

    /**
     * List all id elements visible on a given page
     */
    public boolean listVisibleElements(By xpath) {
        boolean result = false;
        try {
            List<WebElement> elementList = driver.findElements(xpath);
            elementList
                    .forEach(s -> LOGGER.info(String.format("Visible : Id:%s Tag:%s Class:%s Text:%s",
                            s.getAttribute("id"), s.getTagName(), s.getAttribute("class"), s.getText())));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void performActionMoveToElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public Actions moveToElement(By by, WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        return actions;
    }
}
