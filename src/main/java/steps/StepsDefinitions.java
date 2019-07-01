package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utils.AccionesGenericas;
import com.utils.Constantes;



public class StepsDefinitions {	
	
	private final static Logger LOGGER = Logger.getLogger("Feature class");
	
	WebDriver driver;
	AccionesGenericas accionesGenericas;

	@Before
	public void ingresarPagina() {
		System.setProperty(Constantes.driverWeb, Constantes.pathDriverWeb);
		driver = new ChromeDriver();
		accionesGenericas = new AccionesGenericas(driver);
		
	}
	
	@After
	public void finalizarEscenario() {
		try {
			accionesGenericas.cerrarBrowser();
		} catch (Exception e) {
			LOGGER.log(Level.INFO, "Proceso exitoso");
		}
	}

	@Given("^Ingresa a la página " + Constantes.DATOENTRADACUCUMBER + "$")
	public void ingresarEnPagina(String url) throws Exception {
		accionesGenericas.abrirNavegador(url);
		LOGGER.log(Level.INFO, "Proceso exitoso");
		}
	
	@Then("^Presiona Botón " + Constantes.DATOENTRADACUCUMBER + "$")
	public void presionaBoton(String nombreBoton) throws Exception {
		accionesGenericas.presionaBoton(nombreBoton);
		LOGGER.log(Level.INFO, "Presionó el botón: " + nombreBoton);
		}
	
	@Then("^Completa campo " + Constantes.DATOENTRADACUCUMBER + "y selecciona texto " + Constantes.DATOENTRADACUCUMBER + "$")
	public void completarCampoSelecciona(String nombreCampo, String valorCampo) throws Exception {
		accionesGenericas.completarCampoSelecciona(nombreCampo, valorCampo);
		LOGGER.info("Se completó el campo: " + nombreCampo + "con el texto: " + valorCampo);
		}
	
	@Then("^Completa campo " + Constantes.DATOENTRADACUCUMBER + "con texto " + Constantes.DATOENTRADACUCUMBER + 
			"en posición" + Constantes.DATOENTRADACUCUMBER +"$")
	public void completarCampo(String nombreCampo, String valorCampo, int posicion) throws Exception {
		accionesGenericas.completarCampo(nombreCampo, valorCampo, posicion);
		LOGGER.log(Level.INFO, "Se completó el campo: " + nombreCampo + "con el texto: " + valorCampo
				+ " en posición " + posicion);
		}
	
	@Then("^Seleccionar característica: " + Constantes.DATOENTRADACUCUMBER + "$")
	public void seleccionarCaracteristica(String caracteristica) throws Exception {
		accionesGenericas.seleccionarCaracteristica(caracteristica);
		LOGGER.log(Level.INFO, "Se seleccionó la cantidad de ambientes: " + caracteristica);
		}
	
	@Then("^Ordena resultados por: " + Constantes.DATOENTRADACUCUMBER + "$")
	public void ordenarResultados(String orden) throws Exception {
		accionesGenericas.ordenarFiltros(orden);
		LOGGER.log(Level.INFO, "Se ordenaron los resultados por: "+ orden);
		}
	
	@When("^Espera que cargue la página$")
	public void esperarCargaPagina() throws Exception {
		accionesGenericas.esperarCargaPagina();
		LOGGER.log(Level.INFO, "Se cargó la página: ");
		}

	@When("^Presiona aviso en posición" + Constantes.DATOENTRADACUCUMBER + "$")
	public void presionaBotonPosicion(int posicion) throws Exception {
		accionesGenericas.presionaBotonPosicion(posicion);
		LOGGER.log(Level.INFO, "Se presionó el aviso en posición: " + posicion);
		}
	
	@Then("^Selecciona radio: " + Constantes.DATOENTRADACUCUMBER + "en posición "+ Constantes.DATOENTRADACUCUMBER + "$")
	public void seleccionaRadio(String nombreOpcion, int posicion) throws Exception {
		accionesGenericas.seleccionaRadio(nombreOpcion, posicion);
		LOGGER.log(Level.INFO, "Se seleccionó el radio " + nombreOpcion + "en posición " + posicion);
		}
	
	@When("^Presiona botón Buscar$")
	public void presionaBuscar() throws Exception {
		accionesGenericas.presionaBuscar();
		LOGGER.log(Level.INFO, "Se seleccionó el radio ");
		}
	
	@When("^Cambiar a la página: " + Constantes.DATOENTRADACUCUMBER + "$")
	public void irPagina(String pagina) throws Exception {
		accionesGenericas.irPagina(pagina);
		LOGGER.log(Level.INFO, "Se cambió a la página ");
		}
	
	@Then("^Verifica que exista el precio$")
	public void validaExisteTexto() throws Exception {
		accionesGenericas.validaExisteTexto();
		LOGGER.log(Level.INFO, "Se cambió a la página ");
		}
}
