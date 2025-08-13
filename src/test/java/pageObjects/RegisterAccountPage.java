package pageObjects;

import baseClasses.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage {

    public RegisterAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement telephoneTextbox;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement confirmPasswordTextbox;

    @FindBy(xpath = "//b[text()='Privacy Policy']/parent::a/following-sibling::input[@type='checkbox']")
    private WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//input[@type='submit' and @value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement registerSuccessMessage;

    public void sendKeysToFirstNameTextbox(String firstName) {
        firstNameTextbox.clear();
        firstNameTextbox.sendKeys(firstName);
    }

    public void sendKeysToLastNameTextbox(String lastName) {
        lastNameTextbox.clear();
        lastNameTextbox.sendKeys(lastName);
    }

    public void sendKeysToEmailTextbox(String emailAddress) {
        emailTextbox.clear();
        emailTextbox.sendKeys(emailAddress);
    }

    public void sendKeysToTelephoneTextbox(String telephone) {
        telephoneTextbox.clear();
        telephoneTextbox.sendKeys(telephone);
    }

    public void sendKeysToPasswordTextbox(String password) {
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
    }

    public void sendKeysToConfirmPasswordTextbox(String password) {
        confirmPasswordTextbox.clear();
        confirmPasswordTextbox.sendKeys(password);
    }

    public void checkPrivacyPolicyCheckbox() {
        if (!privacyPolicyCheckbox.isSelected()) {
            privacyPolicyCheckbox.click();
        }
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getRegisterSuccessMessage() {
        return registerSuccessMessage.getText();
    }

}
