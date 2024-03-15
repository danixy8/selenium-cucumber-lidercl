
Feature: Buscar Producto

  @PRUEBA1
  Scenario: Buscar producto de Oreo para Selenium
    Given ingreso a la pagina web de Lider CL "https://www.lider.cl/supermercado?gad_source=1&gclid=CjwKCAiAloavBhBOEiwAbtAJO3VxyrL5cADGqnF-vvVUQMTAWhZU4_igFM1j4VO4qA1GWRea2APHcxoCYzkQAvD_BwE"
    When ingreso el texto "Oreo"
    And le doy click al boton buscar
    Then valido que me muestre el valor "oreo"

#  Scenario: Buscar producto por fecha
#    Given ingreso a la pagina web de Lider CL
#    When ingreso el texto "Oreo"
#    And le doy click al boton buscar
#    Then valido que me muestre el valor "Resultados"
#
#  Scenario: Buscar producto por recomendacion
#    Given ingreso a la pagina web de Lider CL
#    When ingreso el texto "Oreo"
#    And le doy click al boton buscar
#    Then valido que me muestre el valor "Resultados"
