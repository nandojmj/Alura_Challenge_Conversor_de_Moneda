package conversion;

import com.google.gson.annotations.SerializedName;

/**
 * Clase que representa la respuesta de la API de ExchangeRate-API.
 * Proporciona métodos para acceder a los datos de la conversión.
 */
public class ConversionResponse {

    /** El código de la moneda base en la conversión. Índices de la API de ExchangeRate-API:
     * "base_code"."target_code" "conversion_rate" "conversion_result"*/

    /** El código de la moneda origen en la conversión. */
    @SerializedName("base_code")
    private String monedaOrigen;

    /** El código de la moneda destino en la conversión. */
    @SerializedName("target_code")
    private String monedaDestino;

    /** La tasa de conversión entre la moneda base y la moneda destino. */
    @SerializedName("conversion_rate")
    private double conversionRate;

    /** El resultado de la conversión. */
    @SerializedName("conversion_result")
    private double resultado;

    /** Obtiene el código de la moneda base. */
    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    /** Establece el código de la moneda base. */
    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    /** Obtiene el código de la moneda destino. */
    public String getMonedaDestino() {
        return monedaDestino;
    }

    /** Establece el código de la moneda destino. */
    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    /** Obtiene la tasa de conversión. */
    public double getConversionRate() {
        return conversionRate;
    }

    /** Establece la tasa de conversión. */
    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    /** Obtiene el resultado de la conversión. */
    public double getResultado() {
        return resultado;
    }

    /** Establece el resultado de la conversión. */
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

//    /** Devuelve una representación de cadena de la respuesta de conversión. */
//    @Override
//    public String toString() {
//        return "ConversionResponse{" +
//                "monedaOrigen='" + monedaOrigen + '\'' +
//                ", monedaDestino='" + monedaDestino + '\'' +
//                ", conversionRate=" + conversionRate +
//                ", resultado=" + resultado +
//                '}';
//    }
}
