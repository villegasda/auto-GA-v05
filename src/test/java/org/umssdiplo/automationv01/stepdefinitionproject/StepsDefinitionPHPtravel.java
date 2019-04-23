package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.Puma.Producto;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionPHPtravel {
    private Login login;
    private Producto producto;

    @Given("^'PHP travel' page is loaded$")
    public void phpTravelPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^set my credentials on 'Login' page$")
    public void setMyCredentialsOnLoginPage() throws Throwable {
        login.setCredentials();
    }

   /* @Given("^Cargar pagina$")
    public void cargarPagina() {
        producto = LoadPage.productoPage();
    }

    @And("^Cargar la pagina de puma para ver el producto$")
    public void cargarLaPaginaDePumaParaVerElProducto() {
        producto.cargarDatos();
    }

    @And("^Verificar que la cantidad sea \"([^\"]*)\" antes de añadir al carrito$")
    public void verificarQueLaCantidadSeaAntesDeAñadirAlCarrito(String esperado) throws Throwable {
        String actual = producto.getCantidad();
        Assert.assertEquals(actual,esperado);
        producto.continuarCarga();
    }

*//*    @Then("^verificar \"([^\"]*)\" del primer calzado$")
    public void verificarDelPrimerCalzado(String esperado) throws Throwable {
        CommonEvents.forceWait(2000);
        String actual = producto.getPrecio();
        Assert.assertEquals(actual,esperado);
    }*/
}
