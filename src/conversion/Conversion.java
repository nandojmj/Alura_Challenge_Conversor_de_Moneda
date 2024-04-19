package conversion;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    // Método para realizar la conversión
    public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
        // Realizar la conversión
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d50362c2646d99e082d99a42/pair/"
                + codMonOrigen + "/" + codMonDestino + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Crear un JsonReader y configurarlo para aceptar JSON malformado
        JsonReader reader = new JsonReader(new StringReader(response.body()));
        reader.setLenient(true);

        try {
            // Parsear la respuesta JSON
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            ConversionResponse conversionResponse = gson.fromJson(reader, ConversionResponse.class);

            // Crear un nuevo objeto Conversion con los datos de la respuesta
            Conversion conversion = new Conversion(conversionResponse.getMonedaOrigen(), conversionResponse.getMonedaDestino(), monto);
            conversion.setResultado(conversionResponse.getResultado());

            // Crear un nuevo registro de conversión con la marca de tiempo actual
            RegistroConversion registroConversion = new RegistroConversion(conversion);

            // Leer el contenido actual del archivo registros_data_time.json
            RegistroConversion[] historial;
            try (Reader fileReader = new FileReader("registros_data_time.json")) {
                historial = gson.fromJson(fileReader, RegistroConversion[].class);
            } catch (FileNotFoundException e) {
                historial = new RegistroConversion[0]; // Si el archivo no existe, inicializamos el historial como un array vacío
            } catch (IOException e) {
                e.printStackTrace();
                return null; // Manejamos otros errores de lectura de archivo retornando null
            }

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
}
