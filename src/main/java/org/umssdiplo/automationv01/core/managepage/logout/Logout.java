package org.umssdiplo.automationv01.core.managepage.logout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

/**
 * @autor Marcelo Garay
 */
public class Logout extends BasePage {

    @FindBy(xpath = "//h1[contains(text(), \"You've been successfully logged out.\")]")
    private WebElement loggedOutMessage;

    public Logout() {
        CommonEvents.waitWebElementIsVisible(loggedOutMessage);
    }
}
