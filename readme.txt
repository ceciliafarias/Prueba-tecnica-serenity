Proyecto de Automatización de Serenity BDD Screenplay para E2E de Compra
=====================================================================

Descripción
---------------

Este proyecto utiliza Serenity BDD y Screenplay para automatizar pruebas E2E de agregar productos al carrito y terminar la compra en un sitio web de comercio electrónico.

Tecnologías utilizadas
-------------------------

* Serenity BDD: framework de pruebas automatizadas para Java
* Screenplay: patrón de diseño para pruebas automatizadas
* Java: lenguaje de programación utilizado para desarrollar las pruebas
* Selenium WebDriver: herramienta para automatizar interacciones con el navegador
* Cucumber: herramienta para definir y ejecutar pruebas BDD

Estructura del proyecto
---------------------------

* `src/test/java/starter`: carpeta que contiene las clases Java
	+ `helper`: carpeta que contiene la estructura de Screenplay
	    - `abilities`: carpeta que contienen las habilidades del actor para navegar por el sistema.
        - `questions`: carpeta que contienen las preguntas que el actor le hará al sistema.
	    - `tasks`: carpeta que contienen las tareas que el actor puede hacer en el sistema.
	    - `userInterfaces`: carpeta que contienen todos los `webelements` de cada página del sistema.
	+ `stepDefinitions`: carpeta que contienen todos los pasos que el actor realiza en las características y/o escenarios
    + `CucumberTestSuite.java`: archivo que define la configuración de la suite de pruebas, 
                                incluyendo la configuración de los entornos de prueba, los navegadores, 
                                los dispositivos y otros parámetros de configuración.
* `src/main/resources`: carpeta que contiene los recursos del proyecto
	+ `features`: carpeta que contiene las características del sistema que se van a probar
		- `Purchase.feature`: archivo que define las características y escenarios para el flujo E2E de compra de productos
	+ `serenity.conf`: es un archivo de configuración para el framework de pruebas Serenity BDD. En este archivo,
	                   se definen las configuraciones para la ejecución de las pruebas, incluyendo la configuración 
	                   de los entornos de prueba, los navegadores, los dispositivos y otros parámetros de configuración.
* `pom.xml`: archivo de configuración del proyecto

Dependencias
---------------------------

El proyecto utiliza las siguientes dependencias:

* Serenity: 4.2.9
* Cucumber: 7.20.1


Cómo ejecutar las pruebas
---------------------------

1. Clona el proyecto en tu máquina local
2. Instala las dependencias del proyecto utilizando el comando `mvn clean install` de Maven
3. Ejecuta las pruebas utilizando el comando `mvn clean verify`

Comandos disponibles
---------------------------

* `mvn clean verify`: Ejecuta todas las pruebas.
* `mvn clean verify -Dheadless.mode=false`: Por defecto el proyecto ejecuta las pruebas en modo headless,
                                            para ejecutar el proyecto en modo gráfico se envía la bandera false.

Escenarios de prueba
---------------------

* Purchase product
    + Alan is in home page
    + Alan search a "iPhone" item
    + Alan add to cart the product
    + Alan search a "iMac" item
    + Alan add to cart the product
    + Alan view the shopping cart
    + Alan click in the checkout button
    + Alan choose the guest option
    + Alan fill billing detail form
    + Alan choose delivery method
    + Alan choose the payment method
    + Alan confirm the order
    + Alan see the message "Your order has been placed!" must be visible

Revisar el reporte de pruebas
------------------------------

Para revisar el reporte de pruebas, sigue los siguientes pasos:

1. Ejecuta las pruebas utilizando el comando `mvn clean verify` en la terminal.
2. Una vez que las pruebas se hayan completado, se generará un reporte en formato HTML en la carpeta `target/site/serenity`.
3. Abre el archivo `index.html` en la carpeta `target/site/serenity` en tu navegador web.
4. En el menú de navegación, selecciona la opción "Test Runs" para ver una lista de las ejecuciones de pruebas.
5. Haz clic en el nombre de la ejecución de pruebas que deseas revisar para ver los detalles de la ejecución.
6. En la página de detalles de la ejecución, se mostrarán los resultados de las pruebas, incluyendo las pruebas que fallaron y las que se completaron con éxito.
7. Haz clic en los enlaces de las pruebas fallidas para ver los detalles de los errores y hallazgos.
8. Para obtener más información sobre cómo interpretar los resultados de las pruebas, consulta la documentación oficial de Serenity BDD.

Contribuciones
-----------------

Si deseas contribuir al proyecto, por favor sigue los siguientes pasos:

1. **Crear un fork**: Crea un fork del repositorio del proyecto.
2. **Crear una rama**: Crea una rama para tu contribución.
3. **Realizar cambios**: Realiza los cambios necesarios en tu rama.
4. **Crear un pull request**: Crea un pull request para que podamos revisar tus cambios.