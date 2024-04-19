package conversion;

import com.google.gson.annotations.SerializedName;

public class ConversionResponse {
    // Atributos
    @SerializedName("base_code") // Nombre del campo en el JSON
    private String monedaOrigen; // Moneda de origen de la conversión

    @SerializedName("target_code") // Nombre del campo en el JSON
    private String monedaDestino; // Moneda de destino de la conversión

    @SerializedName("conversion_result") // Nombre del campo en el JSON
    private double resultado; // Resultado de la conversión

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
