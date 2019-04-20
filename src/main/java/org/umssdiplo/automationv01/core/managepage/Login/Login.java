package org.umssdiplo.automationv01.core.managepage.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.offerpage.OfferPage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class Login extends BasePage {
    @FindBy(name = "username")
    private WebElement emailAddressField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-auto='login']")
    private WebElement signInButton;

    public Login fillEmailAddress(String emailAddress){
        CommonEvents.fillInputField(emailAddressField, emailAddress);
        return this;
    }

    public Login fillPassword(String password){
        CommonEvents.fillInputField(passwordField, password);
        return this;
    }

    public void clickSignInButton(){
        CommonEvents.clickWebElement(signInButton);
    }

    public OfferPage setCredentials(String emailAddress, String password) {
        fillEmailAddress(emailAddress).
        fillPassword(password).
        clickSignInButton();

        return new OfferPage();
    }
}
