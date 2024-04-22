# Open Challenge Backend ONE - Conversor de Monedas
 ***ONE | Fase 3 - Especialización Back-End  G6 Alura - Oracle Next Education***

[![Alura Latam](https://img.shields.io/badge/Alura-Latam-blue?style=flat)](https://www.aluracursos.com/)
[![Static Badge](https://img.shields.io/badge/ONE-Oracle_Next_Education-orange?style=flat&logo=oracle&logoColor=orange)](https://www.oracle.com/co/education/oracle-next-education/) [![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) [![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api)
[![Static Badge](https://img.shields.io/badge/test-status-%23009929?logo=github)](#)
[![Static Badge](https://img.shields.io/badge/license-MIT-blue)](*)

Este es un desafío de la Especialización __Back-End G6 Alura - Oracle Next Education.__ Consiste en desarrollar un Conversor de Monedas en lenguaje Java, donde se realizarán solicitudes a una API de tasas de cambio para manipular datos JSON. Finalmente, se debe filtrar y mostrar las monedas de interés para realizar la conversión de monedas o divisas de diferentes países.

Los pasos solicitados para completar este desafío:

1.  Configurando el entorno Java
2.	Conociendo la API para traer datos
3.	Importando la biblioteca Gson en IntelliJ IDEA 
4.	Construyendo el Cliente para Solicitudes (HttpClient)
5.	Construyendo la Solicitud (HttpRequest)
6.	Construyendo la la Respuesta (HttpResponse)
7.	Analizando la respuesta en formato JSON
8.	Filtrando las monedas
9.	Convirtiendo Valores
10. Interactuando con el usuario
11. Adicionales
   
&nbsp;

> [!NOTE]
> En este Challenge solicitan primero crear el repositorio del proyecto en GitHub.  
> El siguiente material te ayudará con esta actividad: [Git - Configurando Git por primera vez](https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Configurando-Git-por-primera-vez) y [Como subir mi proyecto en GitHub](https://www.youtube.com/watch?v=bhKkeOMysuw)  

&nbsp;

### 1. Configurando el entorno Java  

[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api) 
[![Static Badge](https://img.shields.io/badge/JSON--In--Java--20220320-JAR-blue)](*) 
[![Static Badge](https://img.shields.io/badge/Git-Github-blue?style=flat&logo=GitHub)](https://github.com/)
[![Static Badge](https://img.shields.io/badge/Postman-gray?style=flat&logo=Postman&logoColor=orange)](https://www.postman.com/)
[![Static Badge](https://img.shields.io/badge/app-Trello-%231466c3?style=flat&logo=trello)](https://trello.com/)

En esta primera fase, nos piden que se lleve acabo la instalación y configuración del entorno de desarrollo Java para nuestro desafío de construcción del Conversor de Monedas. Asegúrate de contar con los siguientes programas, archivos, versiones y app necesarias:
- IntelliJ IDEA Community Edition
- JDK 
- JSON en Java y la librería Gson
- Git y GitHub 
- Postman
- Trello

&nbsp;

### 2. Conociendo la API para traer datos
[![Static Badge](https://img.shields.io/badge/Configuracion_del_entorno-%230067ff?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api) 

En este paso crucial, es fundamental comprender mejor la API de tasas de cambio a utilizar, revisar su documentación y aprender cómo obtener la clave de API. Esta clave es esencial para realizar solicitudes y obtener datos actualizados. Asegúrate de seguir cuidadosamente las instrucciones proporcionadas por la API Exchange Rate-API.

> [!NOTE]
> Para este challenge se utilizo la siguiente API: 
> [Exchange Rate-API](https://www.exchangerate-api.com/), debe registrarse para obtener su clave API (YOUR-API-KEY).

Interactuando con la API, encontramos como se realizan las consultas, 
Ejemplo: USD a COP, Dolares EEUU a Pesos Colombianos y un monto a convertir de 1000USD

```java
// Setting URL
https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair//USD/COP/1000
```
al realizar la consulta  en la API nos arroja lo siguiente:
```java
// 20240421181021
// https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair//USD/COP/1000
{
  "result": "success",
  "documentation": "https://www.exchangerate-api.com/docs",
  "terms_of_use": "https://www.exchangerate-api.com/terms",
  "time_last_update_unix": 1713657602,
  "time_last_update_utc": "Sun, 21 Apr 2024 00:00:02 +0000",
  "time_next_update_unix": 1713744002,
  "time_next_update_utc": "Mon, 22 Apr 2024 00:00:02 +0000",
  "base_code": "USD",
  "target_code": "COP",
  "conversion_rate": 3906.1426,
  "conversion_result": 3906142.6
}
```
y observamos los key que nos sirven para nuestro proyecto: 
```java
  "base_code": "USD" (MONEDA ORIGEN)
  "target_code": "COP" (MONEDA DESTINO)
  "conversion_rate": 3906.1426, (TASA DE CONVERSION) a esa fecha.
  "conversion_result": 3906142.6 (RESULTADO DE LA CONVERSION)
```
Asi que identificamos que con los campos __`base_code`, `target_code`, `conversion_rate`__, y __`conversion_result`__ podemos interactuar con la API Exchange Rate y obtener esos datos para nuestro conversor.

&nbsp;
*En esta captura de pantalla se muestra la interacción con el software Postman.*
![ ![Screenshot interactuando y probando los key con la aplicacion Postman]](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/ExchangePostman.png) 

&nbsp;

### 3. Importando la biblioteca Gson en IntelliJ IDEA  
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/Configuracion_del_entorno-%230067ff?style=flat)](#) 
[![Static Badge](https://img.shields.io/badge/JSON--In--Java--2.10.1-JAR-blue)](*) 

Para importar la biblioteca Gson en IntelliJ, sigue estos pasos:
1.	Abre tu proyecto en IntelliJ.
2.	Haz clic derecho sobre la carpeta del proyecto en el panel izquierdo.
3.	Selecciona "Open Module Settings" en el menú contextual.
4.	En la ventana que se abre, ve a la pestaña "Dependencies".
5.	Haz clic en el signo "+" en la esquina inferior izquierda y elige "Library".
6.	Busca "gson" en el cuadro de búsqueda.
7.	Selecciona la versión de Gson que desees utilizar, previamente descargada.
8.	Haz clic en "OK" para cerrar la ventana.
&nbsp;
> [!IMPORTANT]
> Para descargar la biblioteca Gson, debemos ir a Maven Repository en Google. Buscamos Gson y seleccionamos la primera opción. La version descargada para este challenge es la 2.10.1.  [MVN Repository Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)

&nbsp;
*En esta captura de pantalla se muestra la interacción con el software Postman.*
![ ![Screenshot interactuando y probando los key con la aplicacion Postman]](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/ExchangePostman.png)

&nbsp;

### 4. Construyendo el Cliente para Solicitudes (HttpClient)  
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Http-Client-%23ff1a00?style=flat)](#)

Se utilizo la clase HttpClient para realizar solicitudes a la API de tasas de cambio y obtener datos esenciales. El uso de HttpClient en Java facilita la conexión y la obtención de respuestas de manera eficiente.

> [!NOTE]
>  Es necesario obtener su clave API para agregarla al codigo:  
> [Exchange Rate API](https://www.exchangerate-api.com/)
> [Documentacion Exchange Rate API Java ](https://www.exchangerate-api.com/docs/java-currency-api)
&nbsp;

*Fragmento de codigo ejemplo utilizado en la Class ""Conversion.java", en YOUR-API-KEY se utiliza la llave solicitada:*
```java
// Método para realizar la conversión
     public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
        // Construir la URI para la solicitud a la API
        URI direccion_API = URI.create("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/"
                + codMonOrigen + "/" + codMonDestino + "/" + monto);
        // Crear cliente y solicitud HTTP
        HttpClient client = HttpClient.newHttpClient();
         // Resto del código omitido...
```
&nbsp;

### 5. Construyendo la Solicitud (HttpRequest)

[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Http-Request-%23f7a40c?style=flat)](#)

Uso de la clase HttpRequest para configurar y personalizar nuestras solicitudes a la API de tasas de cambio. La clase HttpRequest en Java nos brinda un control detallado sobre los parámetros de nuestras solicitudes.

*Fragmento de codigo utilizado en la Class Conversion.java:*
```java
 public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
       // Resto del código omitido...

           // Crear cliente y solicitud HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion_API)
                .build();
       // Resto del código omitido...
```

&nbsp;

### 6. Construyendo la la Respuesta (HttpResponse)

[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Http-Response-green?style=flat)](#)

En esta parte se solicito el uso de la interfaz HttpResponse para gestionar las respuestas recibidas de la API. La interfaz HttpResponse en Java ofrece una estructura que permite acceder y analizar los diferentes elementos de una respuesta HTTP. Al entender cómo trabajar con esta interfaz, podrás extraer información significativa de las respuestas, como códigos de estado, encabezados y el cuerpo de la respuesta, que normalmente se presenta en formato JSON.

&nbsp;

*Fragmento de codigo donde se crea la variable para almacenar la respuesta de la solicitud. Enviar la solicitud HTTP y recibir la respuesta:*
```java
 public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
       // Resto del código omitido...

         // Variable para almacenar la respuesta de la solicitud
           HttpResponse<String> response;
        try {
            // Realizar la solicitud HTTP
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Resto del código omitido...
```

&nbsp;

### 7.	Analizando la respuesta en formato JSON
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api)
[![Static Badge](https://img.shields.io/badge/Postman-gray?style=flat&logo=Postman&logoColor=orange)](https://www.postman.com/)


En esta parte de  nuestro Challenge se nos solicito el análisis de la respuesta JSON utilizando la biblioteca Gson en Java. La manipulación de datos JSON es esencial, ya que la mayoría de las respuestas de las API se presentan en este formato.  Se nos recomendo el uso de herramientas como Postman, para facilitar el análisis de los datos que se obtendrán de la API. Con la biblioteca Gson, puedes realizar el mapeo eficiente de los datos JSON a objetos Java, facilitando así la extracción y manipulación de la información necesaria.

> [!IMPORTANT]
> Recordar utilizar la biblioteca Gson. Para descargar la biblioteca Gson, debemos ir a Maven Repository en Google. Buscamos Gson y seleccionamos la primera opción. La version descargada para este challenge es la 2.10.1.  [MVN Repository Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)

*Fragmento de codigo utilizado en la Class Conversion.java, se  crea un JsonReader y se configura para aceptar JSON no valido:*
```java
 public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
       // Resto del código omitido...
// Leer el JSON de la respuesta
        try (JsonReader reader = new JsonReader(new StringReader(response.body()))) {
            reader.setLenient(true);

            // Configurar Gson para deserializar la respuesta
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();
        // Resto del código omitido...
```

&nbsp;

### 8. Filtrando las monedas
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api)
[![Static Badge](https://img.shields.io/badge/Postman-gray?style=flat&logo=Postman&logoColor=orange)](https://www.postman.com/)

En la octava fase de nuestro Challenge, nos pidieron el proceso de filtrar las monedas utilizando la biblioteca Gson en Java.
Para acceder a datos específicos, como los valores de las diferentes monedas, es esencial comprender cómo navegar por la estructura JSON de la respuesta de la API. En el desafio se nos solicito utilizar estos codigos de monedas  a convertir:

1.	ARS - Peso argentino
2.	BOB - Boliviano boliviano
3.	BRL - Real brasileño
4.	CLP - Peso chileno
5.	COP - Peso colombiano
6.	USD - Dólar estadounidense

  Como ya tenemos los campos identificados __`base_code`, `target_code`, `conversion_rate`__, y __`conversion_result`__  ahora podemos interactuar con la API Exchange Rate y obtener esos datos para nuestro conversor.

*Fragmento de codigo utilizado en la Class MenuHandler.java:*
```java
 // Resto del código omitido...
 public class MenuHandler {
    // Método para mostrar el menú de opciones
    public static void mostrarMenu() {
        System.out.println("************************************************************");
        System.out.println("""
                1- Convertir de USD (dólar) a ARS (peso argentino).
                2- Convertir de ARS (peso argentino) a USD (dólar).
                3- Convertir de USD (dólar) a BOB (peso boliviano).
                4- Convertir de BOB (peso boliviano) a USD (dólar).
                5- Convertir de USD (dólar) a COP (peso colombiano).
                6- Convertir de COP (peso colombiano) a USD (dólar).
                7- Elegir otras monedas para convertir.
                8- Salir
                Elija una opción:
                """);
    }

   // Método para ejecutar la opción seleccionada por el usuario
    public static void ejecutarOpcion(int opcion, Conversion c, Scanner lectura) {
        switch (opcion) {
            case 1:
                convertirMoneda("USD", "ARS", c, lectura); // Convertir de USD a ARS
                break;
            case 2:
 // Resto del código omitido...
            case 8:
                System.out.println("Gracias por utilizar el convertidor de monedas"); // Mensaje de despedida
                System.exit(0); // Finaliza el programa
            default:
                System.out.println("Opción digitada inválida. Por favor, seleccione una opción válida del menú."); 
        }
    }

// Método privado para realizar la conversión de moneda
    private static void convertirMoneda(String monedaBase, String monedaDestino, Conversion c, Scanner lectura) {
        System.out.println("Ingrese el monto a convertir:"); // Solicita al usuario ingresar el monto a convertir
        int monto = lectura.nextInt(); // Lee el monto ingresado por el usuario
        RegistroConversion registro = c.convertir(monedaBase, monedaDestino, monto); // Realiza la conversión
        mostrarResultado(registro, monedaBase, monedaDestino);
    }
        // Resto del código omitido...
```

&nbsp;

### 9. Convirtiendo Valores
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api)

En esta novena fase, se nos pidio  las conversiones entre las monedas. Se crearon tres clases en el package Conversion:

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/packageconversion.JPG) 

1. **Class Conversion:** La clase `Conversion` se utiliza para realizar conversiones de moneda utilizando una API externa y gestionar el historial de conversiones. Aquí está un resumen de su propósito y uso:

      a. Atributos: La clase tiene atributos que representan los datos necesarios para realizar una conversión de moneda:
         - `monedaOrigen`: Representa la moneda de origen de la conversión.
         - `monedaDestino`: Representa la moneda de destino de la conversión.
         - `monto`: Representa el monto a convertir.
         - `resultado`: Representa el resultado de la conversión.
      
      b. Método `convertir`: Este método realiza la conversión de moneda utilizando una API externa. Utiliza un cliente HTTP para enviar una solicitud a la API, recibe la           respuesta en formato JSON, la parsea y extrae los datos necesarios utilizando la biblioteca Gson. Luego, crea un objeto `Conversion` con los datos obtenidos y              lo guarda en el historial de conversiones.
      
      c. Adaptador personalizado para `LocalDateTime`: La clase incluye un adaptador personalizado para serializar y deserializar objetos `LocalDateTime`. Esto se                  utiliza para formatear adecuadamente las fechas y horas al guardar y recuperar el historial de conversiones (`class HistorialConversion`).

En resumen, la clase `Conversion` se utiliza como una interfaz para realizar conversiones de moneda utilizando una API externa, gestionando el historial de conversiones y proporcionando métodos para acceder y modificar los datos relacionados con la conversión.

&nbsp;

***Fragmento de codigo utilizado en la `Class Conversion.java`:***
```java
 // Resto del código omitido...
 public class Conversion {
    // Atributos para la conversión
    @SerializedName("Moneda_Origen")
    private String monedaOrigen;
    @SerializedName("Moneda_Destino")
    private String monedaDestino;
    private double monto; // Cambiar el tipo de dato a double
    @SerializedName("Resultado_Conversion")
    private double resultado;

    // Constructor por defecto
    public Conversion() {
    }

    // Constructor con parámetros
    public Conversion(String monedaOrigen, String monedaDestino, double monto) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.monto = monto;
    }

    // Getters y setters
 // Resto del código omitido...

 
```
&nbsp;

 
2. **Class ConversionResponse**: se utiliza para representar los datos de respuesta de una conversión de moneda obtenida de la API externa. Aquí está un resumen de su propósito y uso:

      a. Atributos: La clase tiene tres atributos que representan los datos de la conversión:
       - `monedaOrigen`: Representa la moneda de origen de la conversión.
       - `monedaDestino`: Representa la moneda de destino de la conversión.
       - `resultado`: Representa el resultado de la conversión.
      
      b. Anotaciones de SerializedName: Las anotaciones `@SerializedName` se utilizan para especificar el nombre de los campos en el JSON que se utilizarán para mapear los          datos a los atributos de la clase. Esto es útil cuando los nombres de los campos en el JSON no coinciden con los nombres de los atributos en la clase.
      
      c. Getters y setters: Se proporcionan métodos para acceder y modificar los atributos de la clase.
      
      d. Método toString: Se sobrescribe el método `toString` para proporcionar una representación de cadena de la clase. Esto es útil para imprimir fácilmente los objetos             de tipo  `ConversionResponse` en forma legible para los humanos.

En resumen, la clase `ConversionResponse` se utiliza como un contenedor de datos para representar la respuesta de una conversión de moneda, facilitando el procesamiento y manipulación de estos datos en el código del programa.

&nbsp;


***Fragmento de codigo utilizado en la `Class ConversionResponse.java`:***
```java
 // Resto del código omitido...
     // Getters y setters
    public String getMonedaOrigen() {
        return monedaOrigen; // Retorna la moneda de origen
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen; // Establece la moneda de origen
    }

    public String getMonedaDestino() {
        return monedaDestino; // Retorna la moneda de destino
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino; // Establece la moneda de destino
    }

    public double getResultado() {
        return resultado; // Retorna el resultado de la conversión
    }

    public void setResultado(double resultado) {
        this.resultado = resultado; // Establece el resultado de la conversión
    }

    // Método toString para representación de cadena
    @Override
    public String toString() {
        // Retorna una cadena que representa este objeto ConversionResponse
        return "conversion.ConversionResponse{" +
                "origen='" + monedaOrigen + '\'' + // Moneda de origen
                ", destino='" + monedaDestino + '\'' + // Moneda de destino
                ", resultado=" + resultado + // Resultado de la conversión
                '}';
    }
}
 
```
&nbsp;


3. **Class RegistroConversion**: La clase `RegistroConversion` se utiliza para representar un registro de conversión, que incluye los detalles de la conversión realizada y la marca de tiempo en la que se realizó. Aquí está un resumen de su propósito y uso:

      a. Atributos: La clase tiene dos atributos:
       - `conversion`: Representa el objeto de conversión asociado a este registro.
       - `timestamp`: Representa la marca de tiempo del registro, indicando cuándo se realizó la conversión.

      b. Anotaciones de SerializedName: Las anotaciones `@SerializedName` se utilizan para especificar el nombre de los campos en el JSON que se utilizarán para mapear los          datos a los atributos de la clase. Esto es útil cuando los nombres de los campos en el JSON no coinciden con los nombres de los atributos en la clase.
      
      c. Getters y setters: Se proporcionan métodos para acceder y modificar los atributos de la clase.
      
      d. Método toString: Se sobrescribe el método `toString` para proporcionar una representación de cadena de la clase. Esto es útil para imprimir fácilmente los objetos             de tipo  `ConversionResponse` en forma legible para los humanos.

En resumen, la clase `ConversionResponse` se utiliza como un contenedor de datos para representar la respuesta de una conversión de moneda, facilitando el procesamiento y manipulación de estos datos en el código del programa.

&nbsp;

&nbsp;

***Fragmento de codigo utilizado en la `Class RegistroConversion.java`:***
```java
 package conversion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

 public class RegistroConversion {
    // Atributos
    private Conversion conversion; // Objeto de conversión asociado a este registro
    private LocalDateTime timestamp; // Marca de tiempo del registro

    // Constructor
    public RegistroConversion(Conversion conversion) {
        this.conversion = conversion; // Asigna el objeto de conversión proporcionado
        this.timestamp = LocalDateTime.now(); // Establece la marca de tiempo actual
    }

    // Getters y setters
    public Conversion getConversion() {
        return conversion; // Retorna el objeto de conversión asociado a este registro
    }

    public void setConversion(Conversion conversion) {
        this.conversion = conversion; // Establece el objeto de conversión asociado a este registro
    }

    public LocalDateTime getTimestamp() {
        return timestamp; // Retorna la marca de tiempo del registro
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp; // Establece la marca de tiempo del registro
    }
 // Resto del código omitido...

 
```
&nbsp;



### 10. Interactuando con el usuario
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)


En esta etapa del desafío, se solicito  la interacción con el usuario, implementando una interfaz textual a través de la consola que presenta opciones de conversión de monedas. La estructura incluirá un menú dentro de un bucle de repetición, permitiendo al usuario seleccionar opciones numéricas y proporcionar datos para la conversión, utilizando la  `clase Scanner` para capturar la entrada del usuario.

Al final, el programa mostrará el valor convertido según la elección del usuario. Además, es fundamental realizar pruebas exhaustivas para garantizar el correcto funcionamiento del programa, simulando diversas situaciones y recorridos para identificar y corregir posibles errores.


***Fragmento de codigo utilizado en la Class MenuHandler.java:***
```java
 // Resto del código omitido...

// Método para ejecutar la opción seleccionada por el usuario
    public class MenuHandler {
    // Método para mostrar el menú de opciones
    public static void mostrarMenu() {
        System.out.println("\n**************************");
        System.out.println("""
                1-Convertir de USD (dólar) a ARS (peso Argentino).
                2-Convertir de ARS (peso Argentino) a USD (dólar).
                3-Convertir de USD (dólar) a BOB (peso Boliviano).
                4-Convertir de BOB (peso Boliviano) a USD (dólar).
                5-Convertir de USD (dólar) => a COP (peso Colombiano).
                6-Convertir de COP (peso Colombiano) => a USD (dólar).
                7-Elegir las monedas que desea convertir.
                8-Salir
                Elija una opción: """);
    }

    // Método para ejecutar la opción seleccionada por el usuario
    public static void ejecutarOpcion(int opcion) {
        Conversion c = new Conversion(); // Instancia de la clase Conversion para realizar conversiones
        Scanner lectura = new Scanner(System.in); // Objeto Scanner para leer la entrada del usuario

        switch (opcion) {
            case 1:
                convertirMoneda("USD", "ARS", c, lectura); // Convertir de USD a ARS
                break;

             // Resto del código omitido...

            case 8:
                System.out.println("Gracias por utilizar el convertidor de monedas"); // Mensaje de despedida
                System.exit(0); // Finaliza el programa
            default:
                System.out.println("Opción digitada inválida. Por favor, seleccione una opción válida del menú."); // Mensaje de opción inválida
        }
    }

        // Resto del código omitido...
```




## **ADICIONALES:**

A.	Hacer un README
Uno de los pasos más importantes al participar en una selección de trabajo es resolver un desafío propuesto por la empresa con la información de la resolución, y generalmente esto debe estar en el README. ¿Y qué es el README? Es un archivo con extensión .md y es un documento con la descripción del proyecto. Este mismo archivo que se esta leyendo fue el resultado.

B.	Extra (Opcional)

•	Historial de Conversiones: Agregar la capacidad de rastrear y mostrar el historial de las últimas conversiones realizadas, brindando a los usuarios una visión completa de sus actividades.

Se crea la clase `HistorialConversion.java`, que proporciona una estructura para almacenar registros de conversiones. Aquí está un resumen de lo que hace:

   - Importa las clases RegistroConversion del paquete conversion, ArrayList y List del paquete java.util.
   - Tiene un campo privado llamado historial que es una lista de objetos de tipo RegistroConversion. Esta lista almacena los registros de conversiones.
   - Tiene un constructor por defecto que inicializa el campo historial como una nueva instancia de ArrayList, lo que garantiza que esté lista para almacenar los registros.
   - Proporciona un getter (getHistorial) para obtener el historial de conversiones.
   - Proporciona un setter (setHistorial) para establecer el historial de conversiones con una lista proporcionada.
   - Proporciona un método (addRegistro) para agregar un nuevo registro al historial de conversiones. Este método añade el registro proporcionado a la lista historial.
   
   En resumen, esta clase encapsula la funcionalidad relacionada con el historial de conversiones, proporcionando métodos para acceder, modificar y agregar registros de conversiones a una lista interna.


***Captura de pantalla de la ejecucion del proyecto mostrando resultados de conversion y se observa el contenido en el archivo `registros_data_time.json` en formato json, donde se registran y actualizan las consultas realizadas, incluyendo información sobre qué monedas se convirtieron y en qué fecha para cumplir con la parte adicional de este challenge:***

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/registro_pruebaejecucion.JPG) 


***Fragmento de codigo utilizado en la Class `HistorialConversion.java`:***

```java
 // Resto del código omitido...

public class HistorialConversion {
    private List<RegistroConversion> historial; // Lista para almacenar registros de conversión

    // Constructor por defecto
    public HistorialConversion() {
        this.historial = new ArrayList<>(); // Inicializa la lista como un nuevo ArrayList
    }

    // Getter para obtener el historial de conversiones
    public List<RegistroConversion> getHistorial() {
        return historial; // Retorna la lista de historial de conversiones
    }

    // Setter para establecer el historial de conversiones
    public void setHistorial(List<RegistroConversion> historial) {
        this.historial = historial; // Establece el historial de conversiones con la lista proporcionada
    }

    // Método para agregar un nuevo registro al historial de conversiones
    public void addRegistro(RegistroConversion registro) {
        this.historial.add(registro); // Agrega el registro proporcionado a la lista de historial
    }
}
        // Resto del código omitido...
```


C.	Soporte para Más Monedas: Se amplía la lista de monedas disponibles para la elección, permitiendo a los usuarios convertir entre una variedad aún mayor de opciones monetarias.

***Fragmento de codigo utilizado en la Class `MenuHandler.java` para seleccionar otras monedas que se desea convertir. En el menu principal la opcion 7 nos lleva a `7-Elegir otro tipo de monedas a convertir.:` cumpliendo con la opcion adicional del challenge de Soporte para Más Monedas ***
```java
// Resto del código omitido...
 public class MenuHandler {
    // Método para mostrar el menú de opciones
    public static void mostrarMenu() {
        System.out.println("\n***********************************");
        System.out.println("""

       // Resto del código omitido...
                5-Convertir de USD (dólar) a COP (peso Colombiano).
                6-Convertir de COP (peso Colombiano) a USD (dólar).
                7-Elegir otro tipo de monedas a convertir.
                8-Salir
                Elija una opción: """);
    }

    // Método para ejecutar la opción seleccionada por el usuario
    public static void ejecutarOpcion(int opcion) {
        Conversion c = new Conversion(); // Instancia de la clase Conversion para realizar conversiones
        Scanner lectura = new Scanner(System.in); // Objeto Scanner para leer la entrada del usuario

        switch (opcion) {
            case 1:
                convertirMoneda("USD", "ARS", c, lectura); // Convertir de USD a ARS
                break;

 // Resto del código omitido...

           case 6:
                System.out.println("Ingrese el monto a convertir");
                monto = lectura.nextInt();
                base = "COP";
                fin = "USD";
                System.out.println(monto + " " + base + c.convertir(base, fin, monto));
                break;
            case 7:
                String monedaBase = """
                        Lista de códigos de moneda junto con los países correspondientes para su opcion de convertir:
                        1. **AFN**: Afganistán
                        2. **ALL**: Albania
                        3. **DZD**: Argelia
                        4. **USD**: Samoa Americana
                        5. **EUR**: Andorra
                        6. **AOA**: Angola
                        7. **XCD**: Anguila
                        8. **XCD**: Antigua y Barbuda
                        9. **ARS**: Argentina
                        10. **AMD**: Armenia
                        11. **AWG**: Aruba
// Resto del código omitido...

                        71. **ETB**: Etiopía
                        72. **EUR**: Unión Europea
                        73. **FKP**: Islas Malvinas (Falkland)
                        74. **DKK**: Islas Feroe
                        75. **FJD**: Fiyi
                        76. **EUR**: Finlandia
                         Elija un codigo de la moneda que quiera converir.
                        """;
                System.out.println(monedaBase);
                base = lectura.next();

                System.out.println("Ingrese el monto que desea convertir");
                monto = lectura.nextInt();

```

&nbsp;

•	Registros con Marca de Tiempo: Utiliza las funciones de la biblioteca java.time para crear registros que registren las conversiones realizadas, incluyendo información sobre qué monedas se convirtieron y en qué momento.

En esta clase se declara una matriz de objetos de tipo RegistroConversion llamada historial. Este array almacenará los registros de conversiones leídos desde el archivo JSON. Se intenta abrir el archivo "registros_data_time.json" para lectura utilizando un FileReader dentro de un bloque try-with-resources. Si el archivo existe, se utiliza el objeto gson para deserializar el contenido del archivo en la matriz historial. Si el archivo no existe, se captura la excepción FileNotFoundException y se inicializa historial como un array vacío.

Si ocurre algún error de lectura durante la apertura del archivo, se imprimirá la traza de la pila y se devolverá null.

Se crea una nueva matriz llamada nuevoHistorial con una longitud un elemento mayor que la longitud de la matriz historial. Se copian todos los elementos de historial a nuevoHistorial utilizando System.arraycopy, y luego se agrega el nuevo registro de conversión (registroConversion) al final de nuevoHistorial.

Se intenta abrir el archivo "registros_data_time.json" para escritura utilizando un FileWriter dentro de un bloque try-with-resources. Se utiliza el objeto gson para serializar el contenido de nuevoHistorial y escribirlo en el archivo JSON.

Si ocurre algún error durante la escritura en el archivo, se imprimirá la traza de la pila.


***Fragmento de codigo utilizado en la Class `RegistroConversion.java` donde se crea  `registros_data_time.json` en formato json, donde se registran y actualizan las consultas realizadas, incluyendo información sobre qué monedas se convirtieron y en qué fecha para cumplir con la parte adicional de este challenge:***
```java
 // Resto del código omitido...

 // Agregar el nuevo registro de conversión al historial
            RegistroConversion[] nuevoHistorial = new RegistroConversion[historial.length + 1];
            System.arraycopy(historial, 0, nuevoHistorial, 0, historial.length);
            nuevoHistorial[historial.length] = registroConversion;

            // Escribir el historial completo en el archivo JSON
            try (FileWriter fileWriter = new FileWriter("registros_data_time.json")) {
                gson.toJson(nuevoHistorial, fileWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return registroConversion;
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Adaptador personalizado para LocalDateTime
    static class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
        private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public JsonElement serialize(LocalDateTime src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(formatter.format(src));
        }

        @Override
        public LocalDateTime deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return LocalDateTime.parse(json.getAsString(), formatter);
        }
    }
             // Resto del código omitido...

```


***Fragmento del registro del archivo `registros_data_time.json` en formato json, donde se registran y actualizan las consultas realizadas, incluyendo información sobre qué monedas se convirtieron y en qué fecha para cumplir con la parte adicional de este challenge:***
```java
 // Resto del código omitido...

{
    "conversion": {
      "Moneda_Origen": "USD",
      "Moneda_Destino": "COP",
      "monto": 7690.0,
      "Resultado_Conversion": 3.0014249946E7
    },
    "timestamp": "2024-04-19 18:19:49"
  },
  {
    "conversion": {
      "Moneda_Origen": "ARS",
      "Moneda_Destino": "USD",
      "monto": 1200.0,
      "Resultado_Conversion": 1.3872
    },
    "timestamp": "2024-04-19 18:19:57"
  },
  {
    "conversion": {
      "Moneda_Origen": "USD",
      "Moneda_Destino": "COP",
      "monto": 1000.0,
      "Resultado_Conversion": 3903023.4
    },
    "timestamp": "2024-04-19 18:40:24"
  }
             // Resto del código omitido...

```


> [!IMPORTANT]
> Recordar utilizar la biblioteca Gson. Para descargar la biblioteca Gson, debemos ir a Maven Repository en Google. Buscamos Gson y seleccionamos la primera opción. La version descargada para este challenge es la 2.10.1.  [MVN Repository Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)


## Documentation

Documentation is available on the [Open MCT website](https://nasa.github.io/openmct/documentation/).

### Examples

The clearest examples for developing Open MCT plugins are in the
[tutorials](https://github.com/nasa/openmct-tutorial) provided in
our documentation.

> [!NOTE]
> We want Open MCT to be as easy to use, install, run, and develop for as
> possible, and your feedback will help us get there! 
> Feedback can be provided via [GitHub issues](https://github.com/nasa/openmct/issues/new/choose), 
> [Starting a GitHub Discussion](https://github.com/nasa/openmct/discussions), 
> or by emailing us at [arc-dl-openmct@mail.nasa.gov](mailto:arc-dl-openmct@mail.nasa.gov).

## Developing Applications With Open MCT

For more on developing with Open MCT, see our documentation for a guide on [Developing Applications with Open MCT](./API.md#starting-an-open-mct-application).

## Compatibility

This is a fast moving project and we do our best to test and support the widest possible range of browsers, operating systems, and nodejs APIs. We have a published list of support available in our package.json's `browserslist` key.

The project uses `nvm` to ensure the node and npm version used, is coherent in all projects. Install nvm (non-windows), [here](https://github.com/nvm-sh/nvm) or the windows equivalent [here](https://github.com/coreybutler/nvm-windows)

If you encounter an issue with a particular browser, OS, or nodejs API, please file a [GitHub issue](https://github.com/nasa/openmct/issues/new/choose)

## Plugins

Open MCT can be extended via plugins that make calls to the Open MCT API. A plugin is a group 
of software components (including source code and resources such as images and HTML templates)
that is intended to be added or removed as a single unit.

As well as providing an extension mechanism, most of the core Open MCT codebase is also 
written as plugins.

For information on writing plugins, please see [our API documentation](./API.md#plugins).

## Tests

Our automated test coverage comes in the form of unit, e2e, visual, performance, and security tests. 

### Unit Tests
Unit Tests are written for [Jasmine](https://jasmine.github.io/api/edge/global)
and run by [Karma](http://karma-runner.github.io). To run:

`npm test`

The test suite is configured to load any scripts ending with `Spec.js` found
in the `src` hierarchy. Full configuration details are found in
`karma.conf.js`. By convention, unit test scripts should be located
alongside the units that they test; for example, `src/foo/Bar.js` would be
tested by `src/foo/BarSpec.js`.

### e2e, Visual, and Performance tests
The e2e, Visual, and Performance tests are written for playwright and run by playwright's new test runner [@playwright/test](https://playwright.dev/). 

To run the e2e tests which are part of every commit:

`npm run test:e2e:stable`

To run the visual test suite:

`npm run test:e2e:visual`

To run the performance tests:

`npm run test:perf`

The test suite is configured to all tests located in `e2e/tests/` ending in `*.e2e.spec.js`. For more about the e2e test suite, please see the [README](./e2e/README.md)

### Security Tests
Each commit is analyzed for known security vulnerabilities using [CodeQL](https://codeql.github.com/docs/codeql-language-guides/codeql-library-for-javascript/). The list of CWE coverage items is available in the [CodeQL docs](https://codeql.github.com/codeql-query-help/javascript-cwe/). The CodeQL workflow is specified in the [CodeQL analysis file](./.github/workflows/codeql-analysis.yml) and the custom [CodeQL config](./.github/codeql/codeql-config.yml).

### Test Reporting and Code Coverage

Each test suite generates a report in CircleCI. For a complete overview of testing functionality, please see our [Circle CI Test Insights Dashboard](https://app.circleci.com/insights/github/nasa/openmct/workflows/the-nightly/overview?branch=master&reporting-window=last-30-days)

Our code coverage is generated during the runtime of our unit, e2e, and visual tests. The combination of those reports is published to [codecov.io](https://app.codecov.io/gh/nasa/openmct/)

For more on the specifics of our code coverage setup, [see](TESTING.md#code-coverage)

# Glossary

Certain terms are used throughout Open MCT with consistent meanings
or conventions. Any deviations from the below are issues and should be
addressed (either by updating this glossary or changing code to reflect
correct usage.) Other developer documentation, particularly in-line
documentation, may presume an understanding of these terms.

* _plugin_: A plugin is a removable, reusable grouping of software elements.
  The application is composed of plugins.
* _composition_: In the context of a domain object, this refers to the set of
  other domain objects that compose or are contained by that object. A domain
  object's composition is the set of domain objects that should appear
  immediately beneath it in a tree hierarchy. A domain object's composition is
  described in its model as an array of id's; its composition capability
  provides a means to retrieve the actual domain object instances associated
  with these identifiers asynchronously.
* _description_: When used as an object property, this refers to the human-readable
  description of a thing; usually a single sentence or short paragraph.
  (Most often used in the context of extensions, domain
  object models, or other similar application-specific objects.)
* _domain object_: A meaningful object to the user; a distinct thing in
  the work support by Open MCT. Anything that appears in the left-hand
  tree is a domain object.
* _identifier_: A tuple consisting of a namespace and a key, which together uniquely
  identifies a domain object.
* _model_: The persistent state associated with a domain object. A domain
  object's model is a JavaScript object which can be converted to JSON
  without losing information (that is, it contains no methods.)
* _name_: When used as an object property, this refers to the human-readable
  name for a thing. (Most often used in the context of extensions, domain
  object models, or other similar application-specific objects.)
* _navigation_: Refers to the current state of the application with respect
  to the user's expressed interest in a specific domain object; e.g. when
  a user clicks on a domain object in the tree, they are _navigating_ to
  it, and it is thereafter considered the _navigated_ object (until the
  user makes another such choice.)
* _namespace_: A name used to identify a persistence store. A running open MCT 
application could potentially use multiple persistence stores, with the
## Instalación.
Clona el repositorio o descarga los archivos del proyecto. Importa el proyecto en tu entorno de desarrollo Java preferido. Compila y ejecuta la aplicación.
## Contribuciones.
Este proyecto se desarrolló como parte del curso impartido por Alura Latam y auspiciado por Oracle en su plan de desarrollo Next Education. permitiendo visualizar el avance del participante demostrando sus habilidades y conocimiento adquirido en el area de programacion POO, y el uso del lenguaje JAVA.



## Open MCT v2.0.0
Support for our legacy bundle-based API, and the libraries that it was built on (like Angular 1.x), have now been removed entirely from this repository.

For now if you have an Open MCT application that makes use of the legacy API, [a plugin](https://github.com/nasa/openmct-legacy-plugin) is provided that bootstraps the legacy bundling mechanism and API. This plugin will not be maintained over the long term however, and the legacy support plugin will not be tested for compatibility with future versions of Open MCT. It is provided for convenience only.

### How do I know if I am using legacy API?
You might still be using legacy API if your source code

* Contains files named bundle.js, or bundle.json,
* Makes calls to `openmct.$injector()`, or `openmct.$angular`,
* Makes calls to `openmct.legacyRegistry`, `openmct.legacyExtension`, or `openmct.legacyBundle`.


### What should I do if I am using legacy API?
Please refer to [the modern Open MCT API](https://nasa.github.io/openmct/documentation/). Post any questions to the [Discussions section](https://github.com/nasa/openmct/discussions) of the Open MCT GitHub repository.

## Related Repos

> [!NOTE]
> Although Open MCT functions as a standalone project, it is primarily an extensible framework intended to be used as a dependency with users' own plugins and packaging. Furthermore, Open MCT is intended to be used with an HTTP server such as Apache or Nginx. A great example of hosting Open MCT with Apache is `openmct-quickstart` and can be found in the table below.

| Repository | Description |
| --- | --- |
| [openmct-tutorial](https://github.com/nasa/openmct-tutorial) | A great place for beginners to learn how to use and extend Open MCT. |
| [openmct-quickstart](https://github.com/scottbell/openmct-quickstart) | A working example of Open MCT integrated with Apache HTTP server, YAMCS telemetry, and Couch DB for persistence.
| [Open MCT YAMCS Plugin](https://github.com/akhenry/openmct-yamcs) | Plugin for integrating YAMCS telemetry and command server with Open MCT. |
| [openmct-performance](https://github.com/unlikelyzero/openmct-performance) | Resources for performance testing Open MCT. |
| [openmct-as-a-dependency](https://github.com/unlikelyzero/openmct-as-a-dependency) | An advanced guide for users on how to build, develop, and test Open MCT when it's used as a dependency. |
