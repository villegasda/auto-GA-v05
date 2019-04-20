package org.umssdiplo.automationv01.core.managepage.creditcard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.offerpage.OfferPage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

/**
 * @autor Marcelo Garay
 */
public class CreditCard extends BasePage {

    @FindBy(name = "borrowerFirstName")
    private WebElement firstNameField;

    @FindBy(name = "borrowerLastName")
    private WebElement lastNameField;

    @FindBy(name = "borrowerStreet")
    private WebElement homeAddressField;

    @FindBy(name = "borrowerCity")
    private WebElement cityField;

    @FindBy(name = "borrowerState")
    private WebElement stateField;

    @FindBy(name = "borrowerZipCode")
    private WebElement zipCodeField;

    @FindBy(name = "borrowerDateOfBirth")
    private WebElement dateOfBirthField;

    @FindBy(name = "borrowerIncome")
    private WebElement individualAnnualIncomeField;

    @FindBy(name = "borrowerAdditionalIncome")
    private WebElement additionalAnnualIncomeField;

    @FindBy(name = "username")
    private WebElement emailAddressField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "div.sc-hwwEjo.sc-kPVwWT.kPmyvl")
    private WebElement termOfUseCheckbox;

    @FindBy(xpath = "//button[@data-auto='submitPersonalInfo']")
    private WebElement checkYourRateButton;

    public CreditCard() {
        CommonEvents.waitWebElementClickable(termOfUseCheckbox);
    }

    public CreditCard fillFirstName(String firstName){
        CommonEvents.fillInputField(firstNameField, firstName);
        return this;
    }

    public CreditCard fillLastName(String lastName){
        CommonEvents.fillInputField(lastNameField, lastName);
        return this;
    }

    public CreditCard fillHomeAddress(String homeAddress) {
        CommonEvents.fillInputField(homeAddressField, homeAddress);
        return this;
    }

    public CreditCard fillCity(String city){
        CommonEvents.fillInputField(cityField, city);
        return this;
    }

    public CreditCard fillState(String state){
        CommonEvents.fillInputField(stateField, state);
        return this;
    }

    public CreditCard fillZipCode(String zipCode){
        CommonEvents.fillInputField(zipCodeField, zipCode);
        return this;
    }

    public CreditCard fillDateOfBirth(String dateOfBirth){
        CommonEvents.fillInputField(dateOfBirthField, dateOfBirth);
        return this;
    }

    public CreditCard fillIndividualAnnualIncome(String income){
        CommonEvents.fillInputField(individualAnnualIncomeField, income);
        return this;
    }

    public CreditCard fillAdditionalAnnualIncome(String additional){
        CommonEvents.fillInputField(additionalAnnualIncomeField, additional);
        return this;
    }

    public CreditCard fillEmailAddress(String email){
        CommonEvents.fillInputField(emailAddressField, email);
        return this;
    }

    public CreditCard fillPassword(String password){
        CommonEvents.fillInputField(passwordField, password);
        return this;
    }

    public CreditCard checkTermOfUse(){
        CommonEvents.jsClickElement(termOfUseCheckbox);
        CommonEvents.forceWait(600);
        return this;
    }

    public OfferPage clickCheckYourRateButton(){
        CommonEvents.clickWebElement(checkYourRateButton);
        return new OfferPage();
    }
}
