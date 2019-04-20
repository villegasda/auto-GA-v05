package org.umssdiplo.automationv01.core.apirequests;

import com.google.gson.JsonObject;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @autor Marcelo Garay
 */
public class ManageCredify extends ManageResponses {

    /**
     * Manage the response
     *
     * @param resp
     */
    public ManageCredify(Response resp) {
        super(resp);
    }

    public int getStatesCount() {
        return getPathRequestAsArrayList("states").size();
    }


    /**
     * Get label of State when find its min age
     * @param minAge
     * @return name of state
     */
    public String findLabelByMinAge(int minAge) {
        ArrayList states = getPathRequestAsArrayList("states");

        for (Object itemsState : states) {
            HashMap<String, Object> data = (HashMap<String, Object>) itemsState;
            int minAgeActual = Integer.parseInt(data.get("minAge").toString());
            if(minAgeActual == minAge){
                return data.get("label").toString();
            }
        }
        return null;
    }

    public boolean isOnlyOneStateHas19MinAge(int minAge) {
        ArrayList states = getPathRequestAsArrayList("states");

        int numberMatches = 0;
        for (Object itemsState : states) {
            HashMap<String, Object> data = (HashMap<String, Object>) itemsState;
            int minAgeActual = Integer.parseInt(data.get("minAge").toString());
            if(minAgeActual == minAge){
                numberMatches ++;
            }
        }

        return (numberMatches == 1);
    }

    public boolean isTheStateWithMinLoanAmountRequirement(String labelState, double minLoanAmountExpected) {
        ArrayList states = getPathRequestAsArrayList("states");

        double minLoanAmountActual = -1;

        for (Object itemsState : states) {
            HashMap<String, Object> data = (HashMap<String, Object>) itemsState;
            String labelStateActual = data.get("label").toString();

            if(labelStateActual.equals(labelState)){
                minLoanAmountActual = Double.parseDouble(data.get("minLoanAmount").toString());
                break;
            }
        }
        return minLoanAmountActual==minLoanAmountExpected;
    }
}
