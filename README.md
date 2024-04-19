# Open Challenge Backend ONE - Conversor de Monedas
 ***ONE | Fase 3 - Especialización Back-End  G6 Alura - Oracle Next Education***

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/aluralatam.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/oracleone.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/java.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/intellij.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/maven.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/git.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/apiexchange.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/json.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/postman.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/trello.svg) 

En este Challenge Conversor de Monedas de la Especialización Back-End  G6 Alura - Oracle Next Education. Se realizaran solicitudes a una API de tasas de cambio, manipular datos JSON y, finalmente, a filtrar y mostrar las monedas de interés para realizar la conversion. 
Los pasos solicitados para completar este desafío:

1.	Configuración del Ambiente Java;
2.	Creación del Proyecto;
3.	Consumo de la API;
4.	Análisis de la Respuesta JSON;
5.	Filtro de Monedas;
6.	Exhibición de Resultados a los usuarios;
   
&nbsp;

> [!NOTE]
> En este Challenge solicitan primero crear el repositorio del proyecto en GitHub.  
> El siguiente material te ayudará con esta actividad: [Git - Configurando Git por primera vez](https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Configurando-Git-por-primera-vez) y [Como subir mi proyecto en GitHub](https://www.youtube.com/watch?v=bhKkeOMysuw)  

&nbsp;

### 1. Configurando el entorno Java  
![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/java.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/intellij.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/git.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/json.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/postman.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/trello.svg) 

En esta primera fase, nos piden que se lleve acabo la instalación y configuración del entorno de desarrollo Java para nuestro desafío de construcción del Conversor de Monedas. Asegúrate de contar con los siguientes programas, archivos y versiones:
- IntelliJ IDEA Community Edition
- JDK 
- JSON en Java y la librería Gson
- Git y GitHub 
- Postman
- Trello

&nbsp;

### 2.Conociendo la API para traer datos
![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/apiexchange.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/configentorno.svg)

En este paso crucial, es fundamental comprender mejor la API de tasas de cambio a utilizar, revisar su documentación y aprender cómo obtener la clave de API. Esta clave es esencial para realizar solicitudes y obtener datos actualizados. Asegúrate de seguir cuidadosamente las instrucciones proporcionadas por la API Exchange Rate-API.

> [!NOTE]
> Para este challenge se utilizo la siguiente API: 
> [Exchange Rate-API](https://www.exchangerate-api.com/), debe registrase para obtener su clave API.

Ejemplo:

```
// Setting URL
String url_str = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD";

```

### 3. Importando la biblioteca Gson en IntelliJ IDEA  
![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/intellij.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/json.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/configentorno.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/maven.svg)

Para importar la biblioteca Gson en IntelliJ, sigue estos pasos:
1.	Abre tu proyecto en IntelliJ.
2.	Haz clic derecho sobre la carpeta del proyecto en el panel izquierdo.
3.	Selecciona "Open Module Settings" en el menú contextual.
4.	En la ventana que se abre, ve a la pestaña "Dependencies".
5.	Haz clic en el signo "+" en la esquina inferior izquierda y elige "Library".
6.	Busca "gson" en el cuadro de búsqueda.
7.	Selecciona la versión de Gson que desees utilizar.
8.	Haz clic en "OK" para cerrar la ventana.
&nbsp;
> [!IMPORTANT]
> Para descargar la biblioteca Gson, debemos ir a Maven Repository en Google. Buscamos Gson y seleccionamos la primera opción. La version descargada para este challenge es la 2.10.1.  [MVN Repository Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)

&nbsp;

### 4. Construyendo el Cliente para Solicitudes (HttpClient)  
![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/intellij.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/consumoapi.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/java.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/httpclient.svg)

Se utilizo la clase HttpClient para realizar solicitudes a la API de tasas de cambio y obtener datos esenciales. El uso de HttpClient en Java facilita la conexión y la obtención de respuestas de manera eficiente.

> [!NOTE]
>  Es necesario obtener su clave API para agregarla al codigo:  
> [Exchange Rate API](https://www.exchangerate-api.com/)
> [Documentacion Exchange Rate API Java ](https://www.exchangerate-api.com/docs/java-currency-api)

***Fragmento de codigo ejemplo utilizado en la Class ""Conversion.java", en YOUR-API-KEY se utiliza la llave solicitada:***
```java
// Método para realizar la conversión
    public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
        // Realizar la conversión
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d50362c2646d99e082d99a42/pair/"
                + codMonOrigen + "/" + codMonDestino + "/" + monto);
        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

         // Resto del código omitido...
```

&nbsp;

### 5. Construyendo la Solicitud (HttpRequest)
![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/intellij.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/consumoapi.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/java.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/httprequest.svg)

Uso de la clase HttpRequest para configurar y personalizar nuestras solicitudes a la API de tasas de cambio. La clase HttpRequest en Java nos brinda un control detallado sobre los parámetros de nuestras solicitudes.

> [!NOTE]
>  Es necesario obtener su clave API para agragarla al codigo: 
> [Exchange Rate API](https://www.exchangerate-api.com/)
> [Documentacion Exchange Rate API Java ](https://www.exchangerate-api.com/docs/java-currency-api)

***Fragmento de codigo utilizado en la Class Conversion.java:***
```java
 public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
       // Resto del código omitido...

        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construir la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        // Resto del código omitido...
```

&nbsp;

### 6. Construyendo la la Respuesta (HttpResponse)
![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/intellij.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/consumoapi.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/java.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/httpresponse.svg)

En esta parte se solicito el uso de la interfaz HttpResponse para gestionar las respuestas recibidas de la API. La interfaz HttpResponse en Java ofrece una estructura que permite acceder y analizar los diferentes elementos de una respuesta HTTP. Al entender cómo trabajar con esta interfaz, podrás extraer información significativa de las respuestas, como códigos de estado, encabezados y el cuerpo de la respuesta, que normalmente se presenta en formato JSON.

&nbsp;

***Fragmento de codigo utilizado en la Class Conversion.java, se  crea la variable para almacenar la respuesta de la solicitud. Enviar la solicitud HTTP y recibir la respuesta:***
```java
 public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
       // Resto del código omitido...

         // Variable para almacenar la respuesta de la solicitud
        HttpResponse<String> response = null;
        try {
            // Enviar la solicitud HTTP y recibir la respuesta
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            // Capturar excepciones de E/S o interrupciones y lanzar una RuntimeException
            throw new RuntimeException(e);
        }

       // Crear un JsonReader y configurarlo para aceptar JSON no válido
        JsonReader reader = new JsonReader(new StringReader(response.body()));
        reader.setLenient(true);

        // Resto del código omitido...
```

&nbsp;

### 7.	Analizando la respuesta en formato JSON
![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/intellij.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/consumoapi.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/json.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/java.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/postman.svg) 

En esta parte de  nuestro Challenge se nos solicito el análisis de la respuesta JSON utilizando la biblioteca Gson en Java. La manipulación de datos JSON es esencial, ya que la mayoría de las respuestas de las API se presentan en este formato.  Se nos recomendo el uso de herramientas como Postman, para facilitar el análisis de los datos que se obtendrán de la API. Con la biblioteca Gson, puedes realizar el mapeo eficiente de los datos JSON a objetos Java, facilitando así la extracción y manipulación de la información necesaria.

> [!IMPORTANT]
> Recordar utilizar la biblioteca Gson. Para descargar la biblioteca Gson, debemos ir a Maven Repository en Google. Buscamos Gson y seleccionamos la primera opción. La version descargada para este challenge es la 2.10.1.  [MVN Repository Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)

***Fragmento de codigo utilizado en la Class Conversion.java, se  crea un JsonReader y se configura para aceptar JSON no valido:***
```java
 public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
       // Resto del código omitido...

            // Crear un JsonReader y configurarlo para aceptar JSON no válido 
        JsonReader reader = new JsonReader(new StringReader(response.body()));
        reader.setLenient(true);

        try {
            // Analizar la respuesta JSON
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            ConversionResponse conversionResponse = gson.fromJson(reader, ConversionResponse.class);

        // Resto del código omitido...
```

&nbsp;

### 8. Filtrando las monedas
![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/intellij.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/consumoapi.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/json.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/java.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/postman.svg) 

En la octava fase de nuestro Challenge, nos pidieron el proceso de filtrar las monedas utilizando la biblioteca Gson en Java.
Para acceder a datos específicos, como los valores de las diferentes monedas, es esencial comprender cómo navegar por la estructura JSON de la respuesta de la API. En el desafio se nos solicito utilizar estos codigos de monedas  a convertir:

1.	ARS - Peso argentino
2.	BOB - Boliviano boliviano
3.	BRL - Real brasileño
4.	CLP - Peso chileno
5.	COP - Peso colombiano
6.	USD - Dólar estadounidense

Para esto se creo una Class clase MenuHandler.java por los siguientes motivos: 
1. Separación de responsabilidades: La clase MenuHandler se encarga específicamente de manejar la interacción con el usuario a través del menú y ejecutar las opciones seleccionadas. Esto mantiene la clase principal más enfocada en la lógica principal del programa.
2. Facilita la reutilización y mantenimiento del código: Al separar la lógica del menú en una clase separada, se hace más fácil reutilizarla en otros contextos o modificarla sin afectar la lógica principal del programa.
3. Mejora la legibilidad y organización del código: Dividir el código en clases más pequeñas y específicas ayuda a que sea más fácil de entender y mantener. Cada clase tiene una responsabilidad clara y se puede entender por sí sola sin necesidad de revisar todo el código.
En resumen, separar la lógica del menú en la clase MenuHandler ayuda a mantener el código más organizado, modular y fácil de mantener, además de mejorar la legibilidad y la reutilización del código.



> [!IMPORTANT]
> Recordar utilizar la biblioteca Gson. Para descargar la biblioteca Gson, debemos ir a Maven Repository en Google. Buscamos Gson y seleccionamos la primera opción. La version descargada para este challenge es la 2.10.1.  [MVN Repository Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)

***Fragmento de codigo utilizado en la Class MenuHandler.java:***
```java
 public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {

 // Resto del código omitido...
            public class MenuHandler {
    // Método para mostrar el menú de opciones
    public static void mostrarMenu() {
        System.out.println("\n**************************");
        System.out.println("""
                1-Convertir de USD (dólar) a ARS (peso Argentino).
                2-Convertir de ARS (peso Argentino) a USD (dólar).
                3-Convertir de USD (dólar) a BOB (peso Boliviano).
                4-Convertir de BOB (peso Boliviano) a USD (dólar).

 // Resto del código omitido...

// Método para ejecutar la opción seleccionada por el usuario
    public static void ejecutarOpcion(int opcion) {
        Conversion c = new Conversion(); // Instancia de la clase Conversion para realizar conversiones
        Scanner lectura = new Scanner(System.in); // Objeto Scanner para leer la entrada del usuario

        switch (opcion) {
            case 1:
                convertirMoneda("USD", "ARS", c, lectura); // Convertir de USD a ARS
                break;
            case 2:
                convertirMoneda("ARS", "USD", c, lectura); // Convertir de ARS a USD
                break;
            case 3:
                convertirMoneda("USD", "BOB", c, lectura); // Convertir de USD a BOB
                break;
            case 4:
                convertirMoneda("BOB", "USD", c, lectura); // Convertir de BOB a USD
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

&nbsp;

### 9. Convirtiendo Valores
![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/intellij.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/consumoapi.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/json.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/java.svg) ![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/postman.svg) 

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
