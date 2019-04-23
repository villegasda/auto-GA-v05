package org.umssdiplo.automationv01.core.managepage.Puma;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;


public class Producto extends BasePage {
    @FindBy(css = "a[href=\"/hombre\"]")
    private WebElement linkHombre;
    @FindBy(css = "a[href=\"/calzado_de_futbol-hombre\"]")
    private WebElement linkTenis;

    @FindBy(xpath = "//span[@class='gl-price__value gl-price__value--sale']")
    private WebElement precio;
    @FindBy(xpath = "//div[@class='gl-dropdown gl-dropdown--no-max-height']//button[@class='gl-dropdown__select label dropdown-select']")
    private WebElement selectTalla;
    @FindBy(css = "button[title=\"MX 9.5\"]")
    private WebElement btnMx9_5;
    @FindBy(xpath = "//div[@class='gl-dropdown gl-dropdown--small']//button[@class='gl-dropdown__select label dropdown-select']")
    private WebElement cantidad;
    @FindBy(xpath = "//button[@class='gl-cta gl-cta--primary gl-cta--full-width btn-bag']")
    private WebElement btnCarrito;
    @FindBy(xpath = "//a[@class='gl-cta gl-cta--primary gl-cta--full-width gl-vspacing-s']")
    private WebElement btnVerCarrito;

    @FindBy(css = "span[data-auto-id=\"add-to-bag-product-info-qty\"]")
    private WebElement selectCantidad;

    @FindBy(xpath = "//a[@class='name']")
    private WebElement titleCalzadoDeFutbol;
    @FindBy(css = "a[class=\"ffSelectButton\"]\n")
    private WebElement cantidaDebeSer;
    @FindBy(css = "div[data-ci-test-id=\"orderTotalProductsDeliveryValue\"]")
    private WebElement precioTotalP;
    @FindBy(css = "div[data-ci-test-id=\"orderTotalCartValue\"]")
    private WebElement precioEnTotalP;

    public void hoverMenu(){
        CommonEvents.hoverMenus(linkHombre);
    }
    public void clickFutbolLink() {
        CommonEvents.clickButton(linkTenis);
    }
    public void clickPrecio(){
        CommonEvents.forceWait(1000);
        CommonEvents.clickButton(precio);
    }
    public String getCantidadDebeSer(){
        return cantidaDebeSer.getText();
    }
    public void elegirTalla(){
        CommonEvents.clickButton(selectTalla);
        CommonEvents.clickButton(btnMx9_5);
    }
    public void clickAñadirCarrito(){
        CommonEvents.clickButton(btnCarrito);
    }
    public void clickVerCarrito(){
        CommonEvents.clickButton(btnVerCarrito);
    }
    public String getTitleCalzado(){
        return titleCalzadoDeFutbol.getText();
    }
    public String getPrecioProducto(){
        return precioTotalP.getText();
    }
    public String getPrecioTotalEnvio(){
        return precioEnTotalP.getText();
    }
    public String getPrecio(){
        return precio.getText();
    }
    public String getSelectCantidad(){
        return selectCantidad.getText().substring(10,11);
    }
}
