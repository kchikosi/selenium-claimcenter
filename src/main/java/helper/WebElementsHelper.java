package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class WebElementsHelper {
    private static final Logger LOGGER = LogManager.getLogger(WebElementsHelper.class);
    private final WebDriver driver;


    public WebElementsHelper(WebDriver webDriver) {
        this.driver = webDriver;
    }

    /**
     * List all id elements visible on a given page
     *
     */
    public boolean listVisibleElements(By xpathExpression) {
        boolean result = false;
        try {
            List<WebElement> elementList = driver.findElements(xpathExpression);
            elementList
                    .forEach(s -> LOGGER.info(String.format("Visible : Id:%s Tag:%s Class:%s Text:%s",
                            s.getAttribute("id"), s.getTagName(), s.getAttribute("class").replace(" ", "NULL"), s.getText().replace(" ", "NULL"))));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
