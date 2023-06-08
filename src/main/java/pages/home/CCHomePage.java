package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Policy Center Page Object encapsulates Login page
 */
public class CCHomePage {
    private static final String loginPageUrl = "http://localhost:8080/cc/ClaimCenter.do";


    /**
     * We will use the helper {@link helper.WebElementsHelper} to determine the xpath for the elements
     */
    //locators by xpath

    @FindBy(xpath = "//*[@id=\"gw-center-tab-bar\"]")
    private WebElement centerTabBar;

    @FindBy(xpath = "//*[@id=\"TabBarWidget--more-options\"]/div[1]")
    private WebElement moreOptions;

//    private WebElement byClassNameClaimOptions;
//    private WebElement byXPathClaimOptions;
//    private WebElement byXPathNewClaim;


    public CCHomePage(WebDriver driver) {
        driver.get(loginPageUrl);
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public WebElement getCenterTabBar() {
        return centerTabBar;
    }

    public WebElement getMoreOptions() {
        return moreOptions;
    }
}
