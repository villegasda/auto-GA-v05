package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionPHPtravel {
    private Login login;

    @Given("^'SisSecurity' page is loaded$")
    public void phpTravelPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^set my credentials on 'Login' page$")
    public void setMyCredentialsOnLoginPage() throws Throwable {
        login.setCredentials();
        login.eliminarRegistro("abc");
    }

    @And("^click 'Registrar Maquinaria' tab in 'Header' page$")
    public void clickRegistrarMaquinariaTabInHeaderPage() throws Throwable {
//        login.clickRegistrarMaquinariTab();
    }

    @And("^fill \"([^\"]*)\" nombre maquinaria campo en 'Formulario Maquina' form$")
    public void fillNombreMaquinariaCampoEnFormularioMaquinaForm(String nombreMaquinaria) throws Throwable {

    }

    @Then("^verificar que \"([^\"]*)\" esta desplago en 'Lista de Maquinarias' tabla$")
    public void verificarQueEstaDesplagoEnListaDeMaquinariasTabla(String nombreMaquinariaExperado) throws Throwable {
//        String nombreMaquinariaActual = nombreObjectoTable.getNombreTableInsertada();
//
//        Assert.assertEquals(nombreMaquinariaActual, nombreMaquinariaExperado);
    }

    @And("^fill 'Form Registrar Maquinaria' from json data \"([^\"]*)\" en 'Formulario Maquina' form$")
    public void fillFormRegistrarMaquinariaFromJsonDataEnFormularioMaquinaForm(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
