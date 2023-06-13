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
    @FindBy(xpath = "//*[@id=\"TabBarWidget--more-options\"]")
    private WebElement byXPathMoreOptions;
    @FindBy(xpath = "//*[@id=\"TabBar-ClaimTab\"]/div[1]/div[2]")
    private WebElement byXPathClaimFile;
    @FindBy(className = "gw-TitleBar--title")
    private WebElement byCssPageTitle;
    @FindBy(xpath = "//*[@id=\"TabBar\"]/div[2]")
    private WebElement byXPathTabBarWidget;
    @FindBy(xpath = "//*[@id=\"TabBar-ClaimTab-ClaimTab_FNOLWizard\"]/div/div[2]")
    private WebElement byXPathNewClaim;

    public CCHomePage(WebDriver driver) {
        driver.get(loginPageUrl);
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public WebElement getByXPathClaimFile() {
        return byXPathClaimFile;
    }

    public WebElement getByXPathTabBarWidget() {
        return byXPathTabBarWidget;
    }

    public WebElement getByXPathNewClaim() {
        return byXPathNewClaim;
    }

}
