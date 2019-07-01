Feature: Búsqueda y filtro ZonaProp

@proyecto
  Scenario: Buscar casas en alquiler por zona
    Given Ingresa a la página "https://www.zonaprop.com.ar/"
    Then Presiona Botón "Alquilar"
    Then Completa campo "Buscá por ubicación o palabra clave" y selecciona texto "Tigre"
    When Presiona botón Buscar
	When Espera que cargue la página
	Then Completa campo " Desde" con texto "1000" en posición "1"
	Then Completa campo " Hasta" con texto "35000" en posición "1"
	Then Seleccionar característica: "3 Ambientes"
	Then Ordena resultados por: "Caros"
	When Cambiar a la página: "2"
	When Presiona aviso en posición "4"
	Then Verifica que exista el precio