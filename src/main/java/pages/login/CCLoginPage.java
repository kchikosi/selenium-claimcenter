package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *  Policy Center Page Object encapsulates Login page
 */
public class CCLoginPage {
    private static final String loginPageUrl = "http://localhost:8080/cc/ClaimCenter.do";

    //locators by xpath
    @FindBy(xpath = "//div[@id='Login-LoginScreen-LoginDV-username']/div/input")
    private WebElement byXPathUsername;
    @FindBy(xpath = "//div[@id='Login-LoginScreen-LoginDV-password']/div/input")
    private WebElement byXPathPassword;
    @FindBy(xpath = "//*[@id='Login-LoginScreen-LoginDV-submit']/div")
    private WebElement byXPathSubmitButton;

    public CCLoginPage(WebDriver driver) {
        driver.get(loginPageUrl);
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public void setByXPathPassword(String password) {
        this.byXPathPassword.clear();
        this.byXPathPassword.sendKeys(password);
    }

    public void setByXPathUsername(String username) {
        this.byXPathUsername.clear();
        this.byXPathUsername.sendKeys(username);
    }

    public void byXPathClickLogin() {this.byXPathSubmitButton.click();}

}
