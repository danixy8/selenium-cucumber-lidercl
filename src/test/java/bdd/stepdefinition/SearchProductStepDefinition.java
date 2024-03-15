package bdd.stepdefinition;

import bdd.webdriver.DOM;
import bdd.step.SearchProductStep;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SearchProductStepDefinition {

    private final SearchProductStep searchProductStep;
    private static DOM dom;

    // Constructor u otro método donde inicializas searchProductStep
    public SearchProductStepDefinition() {
        this.searchProductStep = new SearchProductStep(); // inicialización
        if (dom == null) {
            dom = new DOM();
        }
    }

    private Scenario scenario;

//    @Before
//    private void beforeScenario(Scenario scenario){
//    }

    @After
    public void afterScenario(Scenario scenario){
        this.scenario = scenario;
        dom.takeScreenShot(scenario);
        dom.quitDriver();
    }

//    @BeforeStep
//    public void beforeEachStep(Scenario scenario){
//        this.scenario = scenario;
//        dom.takeScreenShot(scenario);
//    }

    @AfterStep
    public void afterEachStep(Scenario scenario){
        this.scenario = scenario;
        dom.takeScreenShot(scenario);
    }

    @Given("ingreso a la pagina web de Lider CL {string}")
    public void ingresoALaPaginaWebDeLiderCL(String url) {
        searchProductStep.stepLaunchBrowser(url);
    }

    @When("ingreso el texto {string}")
    public void ingresoElTexto(String txtProduct) {
        searchProductStep.stepClickOnSearch();
        searchProductStep.stepTypeProductName(txtProduct);
    }

    @And("le doy click al boton buscar")
    public void leDoyClickAlBotonBuscar() {
        searchProductStep.stepClickOnSearchBtn();
    }

    @Then("valido que me muestre el valor {string}")
    public void validoQueMeMuestreElValor(String txtExpectedResult) {
        Assertions.assertTrue(searchProductStep.stepValidateResult().toLowerCase().contains(txtExpectedResult), "El texto no contiene la palabra '" + txtExpectedResult + "'");
    }

}
