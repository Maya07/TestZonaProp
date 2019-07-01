package com.utils;

import org.openqa.selenium.WebDriver;

public class Configuraciones {
	
	private static int reintentos = 1;
	private static int tiempoMax = 20;
	private static int tiempoMin = 15;
	
	public static int getReintentos() {
		return reintentos;
	}
	public static void setReintentos(int reintentos) {
		Configuraciones.reintentos = reintentos;
	}
	public static int getTiempoMax() {
		return tiempoMax;
	}
	public static void setTiempoMax(int tiempoMax) {
		Configuraciones.tiempoMax = tiempoMax;
	}
	public static int getTiempoMin() {
		return tiempoMin;
	}
	public static void setTiempoMin(int tiempoMin) {
		Configuraciones.tiempoMin = tiempoMin;
	}
	
	

}
