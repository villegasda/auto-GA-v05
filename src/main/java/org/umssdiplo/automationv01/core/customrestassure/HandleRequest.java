package org.umssdiplo.automationv01.core.customrestassure;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static io.restassured.RestAssured.given;

/**
 * Handle Request
 * @author <a href="mailto:luis.marcelo.garay@gmail.com">Marcelo Garay</a>
 * @version 1.0
 */
public class HandleRequest {

    private static RequestSpecification REQUEST = Credify.getInstance().getRequestSpecification(); // .getRequestSpecification();

    /**
     * Build the Get method request
     *
     * @return the response body
     */
    public static Response get() throws UnsupportedEncodingException, CloneNotSupportedException, NoSuchAlgorithmException {
        return given().spec(REQUEST)
                .when()
                .get();
    }

    /**
     * This method perform a POST request based in a end point and body parameters.
     *
     * @param endpoint is the specified end point.
     * @param body     is the body content.
     * @return a response object.
     */
    public static Response post(final String endpoint, final String body) {
        return given()
                .spec(REQUEST)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(endpoint);
    }

    public static Response post(String endpoint) {
        return given()
                .spec(REQUEST)
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint);
    }
}
