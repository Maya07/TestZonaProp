package com.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class AccionesGenericas {

	WebDriver driver;

	public AccionesGenericas(WebDriver driver) {
		this.driver = driver;
	}

	private final static Logger LOGGER = Logger.getLogger("Feature class");

	public void abrirNavegador(String url) throws Exception {
		driver.get(url);
		driver.manage().window().maximize();
		LOGGER.log(Level.INFO, "Proceso exitoso");
	}

	public void cerrarBrowser() {
		driver.close();
	}

	// Presiona botón por xpath
	public void presionaBoton(String nombreBoton) throws Exception {

		String xpathBoton = reemplazar(Constantes.BOTON, Constantes.NOMBREBOTON, nombreBoton);
		LOGGER.info("Xpath armado: " + xpathBoton);
		driver.findElement(By.xpath(xpathBoton)).sendKeys(Keys.ENTER);
	}

	public void presionaBuscar() throws Exception {

		String xpathBoton = reemplazar(Constantes.BOTON, Constantes.NOMBREBOTON, "Buscar");
		LOGGER.info("Xpath armado: " + xpathBoton);
			driver.findElement(By.xpath(xpathBoton)).submit();
			LOGGER.info("Se hizo subtmit en el botón Buscar ");

		}
	
	// Configuraciones de reintentos y esperas
	public Configuraciones getConfiguraciones() {
		return getConfiguraciones();
	}


	// Completa un campo, cuyo valor dado sea igual al valor del placeholder y selecciona el texto
	public void completarCampoSelecciona(String nombreCampo, String valorCampo) throws Exception {
		LOGGER.info("Completa campo: " + nombreCampo + " con texto: " + valorCampo);
		String campo = reemplazar(Constantes.PLACEHOLDER, Constantes.NOMBRECAMPO, nombreCampo);
		driver.findElement(By.xpath(campo)).sendKeys(valorCampo);
		
		List<WebElement> linea = driver.findElements(By.xpath(Constantes.LISTADO));
		 for(WebElement elemento : linea){
	            String buscar = elemento.getText();
	                if ( buscar.contains(valorCampo)) {
	                    elemento.sendKeys(Keys.ENTER);
	                    LOGGER.info("Cliqueó el texto");
	                    break;
	                }
		 }
	}
	
	// Completa un campo, cuyo valor dado sea igual al valor del placeholder
		public void completarCampo(String nombreCampo, String valorCampo, int posicion) throws Exception {
			LOGGER.info("Completa campo: " + nombreCampo + " con texto: " + valorCampo);
			String campo = reemplazar(Constantes.PLACEHOLDER, Constantes.NOMBRECAMPO, nombreCampo);
			String xpathCampo = "(" + campo + ")" + "[" + posicion + "]";
			LOGGER.info("Xpath Armado: " + xpathCampo);
			driver.findElement(By.xpath(xpathCampo)).sendKeys(valorCampo);
		}

	// Presiona la opción de la lista de lugares mostrados
	public void presionaTextoListado(String textoListado) throws Exception {
		List<WebElement> linea = driver.findElements(By.xpath(Constantes.LISTADO));
		 for(WebElement elemento : linea){
	            String buscar = elemento.getText();
	                if ( buscar.contains(textoListado)) {
	                    elemento.sendKeys(Keys.ENTER);
	                    break;
	                }
	        }

	    }
	
	// Presiona un botón por texto posicionado según se indique
	public void presionaBotonPosicion(int posicion) {

		String xpathBotonPos = "(" +  Constantes.AVISO + ")" + "[" + posicion + "]";
		LOGGER.info("Xpath armado: " + xpathBotonPos);
        // Esperar que cargue la página con el filtro
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBotonPos)));
		driver.findElement(By.xpath(xpathBotonPos)).click();
	}
	
	// Cambia de página
	public void irPagina(String pagina){
		String xpathPagina = reemplazar(Constantes.PAGINADOR, Constantes.PAGINA, pagina);
		driver.findElement(By.xpath(xpathPagina));
		
	}
	
	
	// Selecciona una opción en el filtro Ordena por
	public void ordenarFiltros(String seleccionFiltro){

        // Esperar que cargue la página con el filtro
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-sort-filter")));
        
        //cliquea en ver mas
        driver.findElement(By.id("menu-sort-filter")).click();

        //busca el elemento de la lista que sale en el desplegable y cliquea en Caros
        List<WebElement> linea = driver.findElements(By.xpath(Constantes.ORDENFILTRO));
        for(WebElement elemento : linea){
            String buscar = elemento.getText();
            System.out.println(buscar);
            if ( buscar.contains(seleccionFiltro)) {
                elemento.click();
                System.out.println(elemento);
                break;
            }
        }
    }
	
	public void validaExisteTexto(){
		existeObjeto(Constantes.PRECIO);
		LOGGER.info("Existe el precio en la página");
	}
	
	// Selecciona las características de la propiedad
	public void seleccionarCaracteristica(String ambientes){	
		String caracteristicaXpath = reemplazar(Constantes.CARACTERISTICAS, Constantes.TEXTOCARACTERISTICAS, ambientes);
		driver.findElement(By.xpath(caracteristicaXpath)).sendKeys(Keys.ENTER);
	}
	
	// Selecciona radio
	public void seleccionaRadio(String nombreRadio, int posicion){
		String nombreRadioXpath = reemplazar(Constantes.RADIO, Constantes.NOMBRERADIO, nombreRadio);
		String nombreRadioPos = "(" + nombreRadioXpath + ")" + "[" + posicion + "]";
		driver.findElement(By.xpath(nombreRadioPos)).click();
		
	}

	/*
	 * Métodos para interactuar con los elementos
	 * -------------------------------------
	 */

	// Verifica que el objeto exista en la página
	public boolean existeObjeto(String boton) {
		try {
			driver.findElement(By.xpath(boton));
			LOGGER.info("El objeto existe.");
			return true;
		} catch (Exception excepcion) {
			LOGGER.info("El objeto no existe.");
			return false;
		}
	}

	// Espera que un elemento sea cliqueable
	public void esperaQueSeaCliqueable(By objetoCliqueable) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(objetoCliqueable));
		driver.findElement(objetoCliqueable).click();
	}

	// Reemplaza una palabra clave en el xpath proporcionado
	public String reemplazar(String xpath, String reemplazar, String reemplazo) {
		return xpath.replaceAll(reemplazar, reemplazo);
	}
	
	// Indica si el elemento buscado está presente en la página
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			LOGGER.info("El elemento consultado dejó de estar presente en la página.");
			return false;
		}
	}
	
	// Espera la carga de una página
	public void esperarCargaPagina() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
		driver.get("https://www.zonaprop.com.ar/departamentos-venta-tigre-3-ambientes.html");
		
	}
	

	// Espera que aparezca un objeto en la página por xpath
	public void waitObject(String boton) throws Exception {
		try {
			for (int intentos = 1;; intentos++) {
				if (intentos > Configuraciones.getReintentos())
					throw new Exception("No apareció el objeto esperado: " + boton);
				else if (existeObjeto(boton)) {
					return;
				}
			}
		} catch (Exception e) {
			LOGGER.info("No apareció el elemento del xpath: " + boton);
			throw e;
		}
	}

}
