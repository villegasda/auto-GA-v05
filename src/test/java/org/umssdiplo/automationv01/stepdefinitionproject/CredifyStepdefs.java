package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.apirequests.*;
import org.umssdiplo.automationv01.core.customrestassure.HandleRequest;

import java.util.Formatter;

/**
 * @autor Marcelo Garay
 */
public class CredifyStepdefs {
    private Response response;
    private ManageCredify credify;

    @Given("^GET CreateApi endpoint is configured$")
    public void getCreateApiEndpointIsConfigured() throws Throwable {
        response = HandleRequest.get();
    }

    @Then("^the status code should be (\\d+)$")
    public void theStatusCodeShouldBe(int statucCodeExpected) throws Throwable {
        Assert.assertEquals(response.getStatusCode(), statucCodeExpected);
    }

    @And("^validate total states count is \"([^\"]*)\"$")
    public void validateTotalStatesCountIs(int statesCountExpected) throws Throwable {
        credify = new ManageCredify(response);
        StringBuilder outBuilder = new StringBuilder();
        Formatter message = new Formatter(outBuilder);
        message.format("STATES count validation failed. ");
        message.format("Status Code:[%s] ", response.getStatusCode());
        message.format("Status Line:[%s] ", response.getStatusLine());

        Assert.assertEquals(credify.getStatesCount(), statesCountExpected, message.toString());
    }

    @Then("^Validate only one state has a min age of (\\d+)$")
    public void validateOnlyOneStateHasAMinAgeOf(int minAge) throws Throwable {
        boolean isOnlyOneStateHas19MinAge = credify.isOnlyOneStateHas19MinAge(minAge);

        Assert.assertTrue(isOnlyOneStateHas19MinAge, "More than one state has 19 on MIN AGE.");
    }

    @When("^Validate that \"([^\"]*)\" should be the 'label' of the state that has a min age of (\\d+)$")
    public void validateThatShouldBeTheLabelOfTheStateThatHasAMinAgeOf(String labelStateExpected, int minAge) throws Throwable {
        String labelStateActual = credify.findLabelByMinAge(minAge);
        Assert.assertEquals(labelStateActual, labelStateExpected, "Label State when its minAge is 19 is not equals. ");
    }

    @And("^Validate that \"([^\"]*)\" is the only state with min loan amount requirement of \\$(\\d+)$")
    public void validateThatIsTheOnlyStateWithMinLoanAmountRequirementOf$(String labelState, double minLoanAmount) throws Throwable {
        boolean isTheStateWithMinLoanAmountRequirement = credify.isTheStateWithMinLoanAmountRequirement(labelState, minLoanAmount);

        Assert.assertTrue(isTheStateWithMinLoanAmountRequirement, labelState.concat("is not with MIN LOAD AMOUNT required. "));
    }
}
