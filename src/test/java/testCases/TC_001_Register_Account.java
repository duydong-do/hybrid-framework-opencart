package testCases;

import baseClasses.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegisterAccountPage;
import pageObjects.YourStorePage;

public class TC_001_Register_Account extends BaseTest {


    @Test
    public void TC_01_Register_By_Valid_Data() {
        logger.info("Open 'Your Store' page");
        YourStorePage yourStorePage = new YourStorePage(driver);

        logger.info("Click 'My Account' header dropdown");
        yourStorePage.clickMyAccountHeaderDropdown();

        logger.info("Click 'Register' option");
        yourStorePage.clickRegisterOption();

        logger.info("Navigate to 'Register Account' page");
        RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);

        logger.info("Providing customer details");
        registerAccountPage.sendKeysToFirstNameTextbox("Dong");
        registerAccountPage.sendKeysToLastNameTextbox("Do");
        registerAccountPage.sendKeysToEmailTextbox("dong.sdet" + getRandomNumber() + "@gmail.com");
        registerAccountPage.sendKeysToTelephoneTextbox("0123456789");
        registerAccountPage.sendKeysToPasswordTextbox("SeJava4@");
        registerAccountPage.sendKeysToConfirmPasswordTextbox("SeJava4@");

        logger.info("Check 'Privacy Policy' checkbox");
        registerAccountPage.checkPrivacyPolicyCheckbox();

        logger.info("Click 'Continue' button");
        registerAccountPage.clickContinueButton();

        logger.info("Verify expected message");
        // Assert.assertEquals(registerAccountPage.getRegisterSuccessMessage(), "Your Account Has Been Created!");
        if (registerAccountPage.getRegisterSuccessMessage().equals("Your Account Has Been Created!")) {
            logger.info("---------- PASSED ----------");
            Assert.assertTrue(true);
        } else {
            logger.info("---------- FAILED ----------");
            Assert.fail();
        }
    }

}
