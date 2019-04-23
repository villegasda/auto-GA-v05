package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Puma.Producto;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionAdidas {
    private Producto producto;
    @Given("^'Adidas' page is loaded$")
    public void adidasPageIsLoaded() throws Throwable {
        producto = LoadPage.productoPage();
    }

    @And("^Hover HOMBRE link HEADER$")
    public void hoverHOMBRELinkHEADER() throws Throwable {
        producto.hoverMenu();
    }

    @And("^Click Futbol link sub menú$")
    public void clickFutbolLinkSubMenú() throws Throwable {
        producto.clickFutbolLink();
    }

    @Then("^Get Price Calzado de Fútbol X \"([^\"]*)\"$")
    public void getPriceCalzadoDeFútbolX(String esperado) throws Throwable {
        String actual = producto.getPrecio();
        Assert.assertEquals(actual,esperado);
    }

    @And("^Click Calzado de Fútbol X  TF$")
    public void clickCalzadoDeFútbolXTF() throws Throwable {
        producto.clickPrecio();
    }

    @And("^Select ELIGE TALLA MX$")
    public void selectELIGETALLAMX() throws Throwable {
        producto.elegirTalla();
    }

    @And("^Click AÑADIR AL CARRITO button$")
    public void clickAÑADIRALCARRITOButton() throws Throwable {
        producto.clickAñadirCarrito();
    }

    @Then("^Verify that VIEW SHOOPING BAG is ONE \"([^\"]*)\"$")
    public void verifyThatVIEWSHOOPINGBAGIsONE(String esperado) throws Throwable {
        String actual = producto.getSelectCantidad();
        Assert.assertEquals(actual,esperado);
    }

    @And("^Click VER CARRITO link$")
    public void clickVERCARRITOLink() throws Throwable {
        producto.clickVerCarrito();
    }

    @Then("^Verify \"([^\"]*)\" TF title is displayed$")
    public void verifyTFTitleIsDisplayed(String esperado) throws Throwable {
        String actual = producto.getTitleCalzado();
        Assert.assertEquals(actual,esperado);
    }

    @Then("^Price should be \"([^\"]*)\"$")
    public void priceShouldBe(String esperado) throws Throwable {
        String actual = producto.getPrecioProducto();
        Assert.assertEquals(actual,esperado);
    }

    @Then("^Total should be \"([^\"]*)\"$")
    public void totalShouldBe(String esperado) throws Throwable {
        String actual = producto.getPrecioTotalEnvio();
        Assert.assertEquals(actual,esperado);
    }

    @Then("^Quantity should be \"([^\"]*)\"$")
    public void quantityShouldBe(String esperado) throws Throwable {
        String actual = producto.getCantidadDebeSer();
        Assert.assertEquals(actual,esperado);
    }
}
