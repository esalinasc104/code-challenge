# code-challenge
Proyecto de respuesta al ejercicio de TaskEasy

## SOLUCION PROPUESTA
La forma de resolver el ejercicio fue elaborar un Web Service REST con Spring Boot. Simulando la existencia de una Repository de Base de datos, una Array de datos ingresados de forma manual, de acuerdo a los valores indicados en el correo. Para consumir este Web Service se detallan abajo la forma de hacerlo. Ademas se incluyo un ejemplo de como pueden consumirse estos endpoint usando Angular. Si bien, la aplicacion por ser de forma "ejemplificativa" no tiene incluido los temas de seguridad por token o el uso de una base de datos como tal.

## DATOS PARA EJECUTAR
1. Clonar el proyecto
2. Abrir en Intellij o Eclipse o STS el proyecto
3. Bajar las dependencias de Maven
4. Ejecutar el archivo CodechallengeApplication.java mediante el IDE
5. Abrir en el navegador: http://localhost:8080

## DATOS PARA EJECUTAR - OPCION 2
1. Clonar el proyecto
2. Abrir en Intellij o Eclipse o STS el proyecto
3. Bajar las dependencias de Maven
5. Ejecutar maven package
6. Dentro del proyecto abra una nueva carpeta de titulo target y dentro un archivo de nombre codechallenge-0.0.1-SNAPSHOT.jar
7. Ejecutar dentro de la terminal
7.1 Colocarse en el directorio de la carpeta target del proyecto
7.2 Ejecutar la linea: java -jar codechallenge-0.0.1-SNAPSHOT.jar
5. Abrir en el navegador: http://localhost:8080



## MANEJO DE WEB SERVICE:
Teniendo corriendo la aplicacion o el proyecto y usando POSTMAN o cualquier ide de consumo REST:
### 1. OBTENER TODOS LOS EMPLEADOS CONFIGURADOS:
1.1 Hacer una peticion a la url: http://localhost:8080/api/employees
Este regresara en formato JSON todos los empleados y las reuniones por cada uno de ellos.

### 2. OBTENER LOS EMPLEADOS FILTRADOS DE ACUERDO A LOS PARAMETROS DEL EJERCICIO
2.1 Hacer una peticion a la url: http://localhost:8080/api/employees/schedule/8/17/0/3
Este regresara en formato JSON todos los horarios entre las 8 y las 17 horas, sin considerar el almuerzo y teniendo por parametros 3 empleados como minimo, para considerar disponible el horario.

#### ACLARACION
En la peticion anterior, los ultimos valores: 8/17/0/3: corresponden a los parametros de consultar, de acuerdo a lo siguiente:
8 - hora de inicio de jornada
17 - hora de fin de jornada
0 - Bandera que determina si se considera o no la hora de 12:00 a 1:00pm para reunion. En caso querer que si se considere enviar 1.
3 - Cantidad de empleados como minimo para considerar DISPONIBLE el horario.

Todos estos valores pueden ser modificados en el endpoint para poder hacer dinamica la consulta. Para esto tambien existe una interfaz grafica la cual detallo a continuacion el como usarla.



## MANEJO MEDIANTE LA INTERFAZ GRAFICA
1. Abrir en el navegador la aplicacion la cual deberia de correr en: http://localhost:8080
2. En el formulario que se muestra ingresar:
2.1 La hora de inicio y la hora de fin de la jornada, por defecto es 8 y 17 respectivamente
2.2 Elegir entre si desea considerar la hora de almuerzo como valida para reuniones o no. Por defecto es No
2.3 Elegir la cantidad de empleados limite para considerarse "DISPONIBLE" el horario. Por defecto es 3
Cada uno de estos valores iniciara por defecto, de cuardo a lo indicado en el correo.
3. Hacer clic en "Consultar empleados"
4. En la zona inferior vera la tabla con todos los horarios y empleados que pueden considerar como disponibles
