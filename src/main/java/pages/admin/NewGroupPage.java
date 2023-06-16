package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewGroupPage {
    @FindBy(css = ".gw-focus .gw-shortcutKey")
    public WebElement actions;
    @FindBy(xpath = "//div[@id='Admin-AdminMenuActions-AdminMenuActions_NewGroup']/div/div[2]")
    public WebElement newGroup;

    public NewGroupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
