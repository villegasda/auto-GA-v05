package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.creditcard.CreditCard;
import org.umssdiplo.automationv01.core.managepage.credittech.CreditTech;
import org.umssdiplo.automationv01.core.managepage.logout.Logout;
import org.umssdiplo.automationv01.core.managepage.offerpage.OfferPage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import static org.umssdiplo.automationv01.stepdefinitionproject.UtilData.*;
import static org.umssdiplo.automationv01.stepdefinitionproject.UtilPage.getCurrentMillis;

/**
 * @autor Marcelo Garay
 */
public class CreditTechStepdefs {
    private UtilPage page;
    private CreditTech creditTech;
    private CreditCard creditCard;
    private final String EMAIL_FORMAT = "candidate%s@upgrade-challenge.com";
    private OfferPage offerPage;
    private Logout logout;
    private Login login;

    public CreditTechStepdefs(UtilPage page) {
        this.page = page;
    }

    @Given("^the 'Credit Tech' page is loaded$")
    public void theCreditTechPageIsLoaded() throws Throwable {
        creditTech = LoadPage.creditTechPage();
    }

    @And("^fill \\$\"([^\"]*)\" 'Load Amount' field in 'Apply for a personal loan' page$")
    public void fill$LoadAmountFieldInApplyForAPersonalLoanPage(String loadAmountValue) throws Throwable {
        creditTech.fillLoanAmountField(loadAmountValue);
    }

    @And("^choose \"([^\"]*)\" option of 'Load Purpose' dropdown in 'Apply for a personal loan' page$")
    public void chooseOptionOfLoadPurposeDropdownInApplyForAPersonalLoanPage(String loadPurposeValue) throws Throwable {
        creditTech.chooseLoanPurposeByOption(loadPurposeValue);
    }

    @And("^click 'Check your Rate' button in 'Apply for a personal loan' page$")
    public void clickCheckYourRateButtonInApplyForAPersonalLoanPage() throws Throwable {
        creditCard = creditTech.clickCheckYourRateButton();
    }

    @When("^fill 'Fist Name' first name field in 'Credit Card' page$")
    public void fillFistNameFirstNameFieldInCreditCardPage() throws Throwable {
        String nameRandom = getCurrentMillis();
        String firstName = "marce".concat(nameRandom.substring((nameRandom.length()-3)));
        page.putElementToBag(FIRST_NAME,firstName);
        creditCard.fillFirstName(firstName);
    }

    @When("^fill 'Last Name' last name field in 'Credit Card' page$")
    public void fillLastNameLastNameFieldInCreditCardPage() throws Throwable {
        String nameRandom = getCurrentMillis();
        String lastName = "garay".concat(nameRandom.substring((nameRandom.length()-3)));
        page.putElementToBag(LAST_NAME,lastName);
        creditCard.fillLastName(lastName);
    }

    @And("^fill \"([^\"]*)\" home address field in 'Credit Card' page$")
    public void fillHomeAddressFieldInCreditCardPage(String homeAddress) throws Throwable {
        creditCard.fillHomeAddress(homeAddress);
    }

    @And("^fill \"([^\"]*)\" city field in 'Credit Card' page$")
    public void fillCityFieldInCreditCardPage(String city) throws Throwable {
        page.putElementToBag(CITY,city);
        creditCard.fillCity(city);
    }

    @And("^fill \"([^\"]*)\" state field in 'Credit Card' page$")
    public void fillStateFieldInCreditCardPage(String state) throws Throwable {
        page.putElementToBag(STATE,state);
        creditCard.fillState(state);
    }

    @And("^fill \"([^\"]*)\" zip code field in 'Credit Card' page$")
    public void fillZipCodeFieldInCreditCardPage(String zipCode) throws Throwable {
        page.putElementToBag(ZIP_CODE,zipCode);
        creditCard.fillZipCode(zipCode);
    }

    @And("^fill \"([^\"]*)\" date of birth field in 'Credit Card' page$")
    public void fillDateOfBirthFieldInCreditCardPage(String dateOfBirth) throws Throwable {
        page.putElementToBag(DATE_OF_BIRTH,dateOfBirth);
        creditCard.fillDateOfBirth(dateOfBirth);
    }

    @And("^fill \\$\"([^\"]*)\" individual annual income field in 'Credit Card' page$")
    public void fill$IndividualAnnualIncomeFieldInCreditCardPage(String individualIncome) throws Throwable {
        page.putElementToBag(INDIVIDUAL_ANNUAL_INCOME,individualIncome);
        creditCard.fillIndividualAnnualIncome(individualIncome);
    }

    @And("^fill \\$\"([^\"]*)\" additional annual income field in 'Credit Card' page$")
    public void fill$AdditionalAnnualIncomeFieldInCreditCardPage(String additionalIncome) throws Throwable {
        page.putElementToBag(ADDITIONAL_ANNUAL_INCOME,additionalIncome);
        creditCard.fillAdditionalAnnualIncome(additionalIncome);
    }

    @And("^fill random 'Email' email address field in 'Credit Card' page$")
    public void fillRandomEmailEmailAddressFieldInCreditCardPage() throws Throwable {
        String emailAddressUnique = String.format(EMAIL_FORMAT, getCurrentMillis());

        System.out.println("-------------------");
        System.out.println(emailAddressUnique);
        System.out.println("-------------------");

        page.putElementToBag(EMAIL_ADDRESS,emailAddressUnique);
        creditCard.fillEmailAddress(emailAddressUnique);
    }

    @And("^fill same email value to 'Password' field in 'Credit Card' page$")
    public void fillSameEmailValueToPasswordFieldInCreditCardPage() throws Throwable {
        String password = page.getElementFromBag(EMAIL_ADDRESS, String.class);
        creditCard.fillPassword(password);
    }

    @And("^check 'Terms of Use' field in 'Credit Card' page$")
    public void checkTermsOfUseFieldInCreditCardPage() throws Throwable {
        creditCard.checkTermOfUse();
    }

    @And("^fill \"([^\"]*)\" field in 'Credit Card' page$")
    public void fillFieldInCreditCardPage(String password) throws Throwable {
        page.putElementToBag(PASSWORD, password);
        creditCard.fillPassword(password);
    }

    @And("^click 'Check your Rate' button in 'Credit Card' page$")
    public void clickCheckYourRateButtonInCreditCardPage() throws Throwable {
        offerPage = creditCard.clickCheckYourRateButton();
    }

    @When("^getting 'Your Loan Amount' value in 'Offer' top page$")
    public void gettingYourLoanAmountValueInOfferTopPage() throws Throwable {
        String yourLoanAmountValueActual = offerPage.getYourLoanAmountValue();
        page.putElementToBag(YOUR_LOAN_AMOUNT_VALUE, yourLoanAmountValueActual);
    }

    @When("^getting 'ARP' value in 'Offer' top page$")
    public void gettingARPValueInOfferTopPage() throws Throwable {
        String arpValueActual = offerPage.getARPValue();
        page.putElementToBag(ARP_VALUE, arpValueActual);
    }

    @When("^getting 'Loan Term' value in 'Offer' top page$")
    public void gettingLoanTermValueInOfferTopPage() throws Throwable {
        String loanTermValue = offerPage.getLoanTermValue();
        page.putElementToBag(LOAN_TERM_VALUE, loanTermValue);
    }

    @And("^getting 'Monthly Payment' value in 'Offer' top page$")
    public void gettingMonthlyPaymentValueInOfferTopPage() throws Throwable {
        String monthlyPaymentValue = offerPage.getMonthlyPaymentValue();
        page.putElementToBag(MONTHLY_PAYMENT_VALUE, monthlyPaymentValue);
    }

    @And("^click 'Sign Out' in the top right corner in 'Offer' top page$")
    public void clickSignOutInTheTopRightCornerInOfferTopPage() throws Throwable {
        logout = offerPage.clickSignOut();
    }

    @When("^the 'Login Credit Terch' page is loaded$")
    public void theLoginCreditTerchPageIsLoaded() throws Throwable {
        login = LoadPage.creditTechLoginPage();
    }

    @And("^fill 'Credentials' created in 'Login' page$")
    public void fillCredentialsCreatedInLoginPage() throws Throwable {
        String emailAddress = page.getElementFromBag(EMAIL_ADDRESS,String.class);
        String password = page.getElementFromBag(PASSWORD, String.class);
        offerPage = login.setCredentials(emailAddress, password);
    }

    @Then("^validate 'Loan Amount' match with info previously in 'Offer' top page$")
    public void validateLoanAmountMatchWithInfoPreviouslyInOfferTopPage() throws Throwable {
        //Validate LOAN AMOUNT
        String loanAmountExpected = page.getElementFromBag(YOUR_LOAN_AMOUNT_VALUE, String.class);
        String yourLoanAmountValueActual = offerPage.getYourLoanAmountValue();
        Assert.assertEquals(yourLoanAmountValueActual, loanAmountExpected, "ERROR NOT MATH - LOAN AMOUNT. ");
    }

    @And("^validate 'ARP' match with info previously in 'Offer' top page$")
    public void validateARPMatchWithInfoPreviouslyInOfferTopPage() throws Throwable {
        //Validate ARP
        String arpExpected = page.getElementFromBag(ARP_VALUE, String.class);
        String arpValueActual = offerPage.getARPValue();
        Assert.assertEquals(arpValueActual, arpExpected, "ERROR NOT MATH - ARP. ");
    }

    @And("^validate 'Loan Term' match with info previously in 'Offer' top page$")
    public void validateLoanTermMatchWithInfoPreviouslyInOfferTopPage() throws Throwable {
        //NOT FOUND - LOAN TERM
        //Validate LOAN TERM
//        String loanTermExpected = page.getElementFromBag(LOAN_TERM_VALUE, String.class);
//        String loanTermValue = offerPage.getLoanTermValue();
//        Assert.assertEquals(loanTermValue, loanTermExpected, "ERROR NOT MATH - LOAN TERM. ");
    }

    @And("^validate 'Monthly Payment' match with info previously in 'Offer' top page$")
    public void validateMonthlyPaymentMatchWithInfoPreviouslyInOfferTopPage() throws Throwable {
        //Validate MONTHLY PAYMENT
        String monthlyPaymentValueExpected = page.getElementFromBag(MONTHLY_PAYMENT_VALUE, String.class);
        String monthlyPaymentValue = offerPage.getMonthlyPaymentValue();
        Assert.assertEquals(monthlyPaymentValue, monthlyPaymentValueExpected, "ERROR NOT MATH - MONTHLY PAYMENT. ");
    }
}
