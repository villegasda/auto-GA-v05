package org.umssdiplo.automationv01.stepdefinitionproject;

import java.util.HashMap;

/**
 * @autor Marcelo Garay
 */
public class UtilPage {

    private HashMap<String, Object> elementBag = new HashMap<>();

    public <T> T getElementFromBag(String keyName, Class<T> objectClass) {
//        logger.info("Get element {} from the Bag", keyName);
        T response = (T) elementBag.get(keyName);
        if (response == null)
            return (T) keyName;
        else
            return response;
    }

    public void putElementToBag(String key, Object value) {
//        logger.info("Put element {} to bag using key {}.", value, key);
        this.elementBag.put(key, value);
    }

    public static String getCurrentMillis() {
        return String.valueOf(System.currentTimeMillis());
    }
}
