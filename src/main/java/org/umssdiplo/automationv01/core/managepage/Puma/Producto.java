package org.umssdiplo.automationv01.core.managepage.Puma;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;


public class Producto extends BasePage {
    Actions actions = new Actions(webDriver);
    @FindBy(css = "a[href=\"/hombre\"]")
    private WebElement linkHombre;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/div[2]/div/div/div/ul[1]/li[1]/ul/li[1]/div/div/a")
    private WebElement linkTenis;

    @FindBy(css = "a[href=\"/calzado-futbol-hombre\"]")
    private WebElement linkCalzadoHombre;

    public void cargarDatos(){
        actions.moveToElement(linkHombre);
        CommonEvents.clickButton(linkTenis);
        CommonEvents.clickButton(linkCalzadoHombre);

    }
}
