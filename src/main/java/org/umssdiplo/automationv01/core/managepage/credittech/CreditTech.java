package org.umssdiplo.automationv01.core.managepage.credittech;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.creditcard.CreditCard;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

/**
 * @autor Marcelo Garay
 */
public class CreditTech extends BasePage {

    @FindBy(name = "desiredAmount")
    private WebElement loadAmountField;

    @FindBy(css = "select.sc-dVhcbM.iHtznt")
    private WebElement loadPurposeField;

    @FindBy(xpath = "//button[@data-auto= 'CheckYourRate']")
    private WebElement checkYourRateButton;

    public CreditTech() {
        CommonEvents.waitWebElementClickable(checkYourRateButton);
    }

    public CreditTech fillLoanAmountField(String value){
        CommonEvents.fillInputField(loadAmountField, value);
        return this;
    }

    public CreditTech chooseLoanPurposeByOption(String optionValue){
        CommonEvents.chooseDropDownByTextVisible(loadPurposeField, optionValue);
        return this;
    }

    public CreditCard clickCheckYourRateButton(){
        CommonEvents.clickWebElement(checkYourRateButton);
        return new CreditCard();
    }

}
