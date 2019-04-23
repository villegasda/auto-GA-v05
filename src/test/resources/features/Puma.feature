Feature: Accediendo a Adidas

  Scenario: Examen
    Given 'Adidas' page is loaded
    And Hover HOMBRE link HEADER
    And Click Futbol link sub menú
    Then Get Price Calzado de Fútbol X "$1,329"
    And Click Calzado de Fútbol X  TF
    And Select ELIGE TALLA MX
    And Click AÑADIR AL CARRITO button
    Then Verify that VIEW SHOOPING BAG is ONE "1"
    And Click VER CARRITO link
    Then Verify "CALZADO DE FÚTBOL X 18.3 TF" TF title is displayed
    Then Quantity should be "1"
    Then Price should be "$1,329.00"
    Then Total should be "$1,428.00"
