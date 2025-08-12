package testCases;

import baseClasses.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegisterAccountPage;
import pageObjects.YourStorePage;

public class TC_001_Register_Account extends BaseTest {


    @Test
    public void TC_01_Register_By_Valid_Data() {
        YourStorePage yourStorePage = new YourStorePage(driver);
        yourStorePage.clickMyAccountHeaderDropdown();
        yourStorePage.clickRegisterOption();

        RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
        registerAccountPage.sendKeysToFirstNameTextbox("Dong");
        registerAccountPage.sendKeysToLastNameTextbox("Do");
        registerAccountPage.sendKeysToEmailTextbox("dong.sdet" + getRandomNumber() + "@gmail.com");
        registerAccountPage.sendKeysToTelephoneTextbox("0123456789");
        registerAccountPage.sendKeysToPasswordTextbox("SeJava4@");
        registerAccountPage.sendKeysToConfirmPasswordTextbox("SeJava4@");
        registerAccountPage.checkPrivacyPolicyCheckbox();
        registerAccountPage.clickContinueButton();
        Assert.assertTrue(registerAccountPage.isRegisterSuccessMessageDisplayed());
    }

}
