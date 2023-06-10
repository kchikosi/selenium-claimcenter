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
    //*[@id="TabBar"]/div[2] - this is the guy
    @FindBy(xpath = "//*[@id=\"TabBarWidget--more-options\"]")
    private WebElement moreOptions;
    @FindBy(xpath = "//*[@id=\"TabBar-ClaimTab\"]/div[1]/div[2]")
    private WebElement byXPathClaimFile;


    public CCHomePage(WebDriver driver) {
        driver.get(loginPageUrl);
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public WebElement getMoreOptions() {
        return moreOptions;
    }

    public WebElement getByXPathClaimFile() {
        return byXPathClaimFile;
    }
}
