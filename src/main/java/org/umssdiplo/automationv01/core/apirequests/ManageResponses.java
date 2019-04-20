package org.umssdiplo.automationv01.core.apirequests;

import io.restassured.response.Response;

import java.util.ArrayList;

/**
 * @autor Marcelo Garay
 */
public class ManageResponses {
    /**
     * Response where it will be kept the request
     */
    protected Response resp;

    /**
     * Manage the response
     *
     * @param resp
     */
    public ManageResponses(Response resp) {
        this.resp = resp;
    }

    /**
     * Gets the Array as List
     *
     * @return Array list of path requested
     */
    protected ArrayList getPathRequestAsArrayList(String path) {
        ArrayList result = new ArrayList();
        boolean status = ValidateCodeStatus(resp);
        if (status) {
            result = resp.jsonPath().get(path);
        }

        return result;
    }

    /**
     * Validated the code status
     *
     * @param response
     * @return
     */
    protected boolean ValidateCodeStatus(Response response) {
        boolean result = false;
        if (response.getStatusCode() == 200) {
            result = true;
        } else {
            System.out.println("Http Status: " + response.getStatusCode() + " - Status Line: " + response.getStatusLine());
        }

        return result;
    }
}
