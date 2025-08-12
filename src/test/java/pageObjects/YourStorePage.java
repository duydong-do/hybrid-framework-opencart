package pageObjects;

import baseClasses.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourStorePage extends BasePage {

    public YourStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='My Account']//span[text()='My Account']")
    private WebElement myAccountHeaderDropdown;

    @FindBy(xpath = "//a[@title='My Account']/following-sibling::ul//a[text()='Register']")
    private WebElement registerOption;

    public void clickMyAccountHeaderDropdown() {
        myAccountHeaderDropdown.click();
    }

    public void clickRegisterOption() {
        registerOption.click();
    }

}
