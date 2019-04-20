package org.umssdiplo.automationv01.core.managepage.offerpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.logout.Logout;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

/**
 * @autor Marcelo Garay
 */
public class OfferPage extends BasePage {

    @FindBy(xpath = "//button[@data-auto='getDefaultLoan']")
    private WebElement selectButtonTopPage;

    @FindBy(xpath = "//span[@data-auto='userLoanAmount']")
    private WebElement yourLoanAmount;

    @FindBy(xpath = "//div[@data-auto='defaultMoreInfoAPR']/div")
    private WebElement arpValue;

    @FindBy(xpath = "//no-found")
    private WebElement loanTermValue;

    @FindBy(xpath = "//span[@data-auto='defaultMonthlyPayment']")
    private WebElement monthlyPaymentValue;

    @FindBy(css = "div.header-nav>label")
    private WebElement menuTopRightCorner;

    @FindBy(xpath = "//a[contains(text(), 'Sign Out')]")
    private WebElement signOutLink;

    public OfferPage(){
        CommonEvents.waitWebElementClickable(selectButtonTopPage);
    }

    public String getYourLoanAmountValue(){
        return CommonEvents.getTextContent(yourLoanAmount);
    }

    public String getARPValue(){
        return CommonEvents.getTextContent(arpValue);
    }

    public String getLoanTermValue() {
        return CommonEvents.getTextContent(loanTermValue);
    }

    public String getMonthlyPaymentValue() {
        return CommonEvents.getTextContent(monthlyPaymentValue);
    }

    public Logout clickSignOut() {
        CommonEvents.jsClickElement(menuTopRightCorner);
        CommonEvents.forceWait(300);

        CommonEvents.clickWebElement(signOutLink);

        return new Logout();
    }
}
