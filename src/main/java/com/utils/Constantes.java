package com.utils;

public class Constantes {

	// Configuración 
	public static final String driverWeb = "webdriver.chrome.driver";
	public static final String pathDriverWeb = "C:\\var\\jenkins_home\\bin\\chromedriver.exe";
	public static final String DATOENTRADACUCUMBER = "\\s*\"([^\"]*)\"\\s*";
	
	// xpaths botón
	public static final String BOTON = "//button[contains(text(), 'NOMBREBOTON')]";
	public static final String NOMBREBOTON = "NOMBREBOTON";
	
	// xpaths campo
	public static final String PLACEHOLDER = "//input[contains(@placeholder, 'NOMBRECAMPO')]";
	public static final String NOMBRECAMPO = "NOMBRECAMPO";
	
	// xpaths texto listado
	public static final String TEXTOLISTADO = "//li/a[@class='dropdown-item']/span";
	public static final String LISTADO = "//*[@id='homeTypeahead']//li//a";
	
	// xpath selección en filtro
	public static final String ORDENFILTRO = "//ul[@id='menu-sort-filter']//li";
	public static final String SELECCIONFILTRO = "SELECCIONFILTRO";
	
	// xpath aviso
	public static final String AVISO = "//div[@class='posting-heading']";
	
	// xpath características de la propiedad
	public static final String CARACTERISTICAS = "//button[@applied_label='TEXTOCARACTERISTICAS']";
	public static final String TEXTOCARACTERISTICAS = "TEXTOCARACTERISTICAS";
	
	// xpath selección Radio
	public static final String RADIO = "//div[@class='input-wrapper options']/label/input[@applied_label='NOMBRERADIO']";
	public static final String NOMBRERADIO = "NOMBRERADIO";
	
	// xpath Paginador
	public static final String PAGINADOR = "//div[@class='paging']/ul/li/a[contains(., PAGINA)]";
	public static final String PAGINA = "PAGINA";
	
	// Xpath Precio
	public static final String PRECIO = "//div[@class='price-items']";
	
	
}
