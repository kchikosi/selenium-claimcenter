package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * utilities
 */
public class JavaScriptUtil {
    private static final Logger logger = LogManager.getLogger(JavaScriptUtil.class.getName());

    public static void jsSafeClick(WebElement webElement, WebDriver webDriver) {
        WebDriverWait driverWait = new WebDriverWait(webDriver, 5);
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
        try {
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                logger.info("Clicking on element using JavaScript click");
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", webElement);
            } else {
                logger.info("Unable to click on element");
            }
        } catch (StaleElementReferenceException elementReferenceException) {
            System.out.println("Element is not attached to the page document " + elementReferenceException.getStackTrace());
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Element was not found in DOM " + noSuchElementException.getStackTrace());
        } catch (Exception exception) {
            System.out.println("Unable to click on element " + exception.getStackTrace());
        }
    }
}
