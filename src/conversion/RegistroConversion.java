package conversion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un registro de conversión.
 */
public class RegistroConversion {
    // Atributos
    private Conversion conversion; // Representa la conversión realizada
    private LocalDateTime timestamp; // Marca de tiempo de la conversión

    /**
     * Constructor de RegistroConversion.
     * @param conversion La conversión que se está registrando.
     */
    public RegistroConversion(Conversion conversion) {
        this.conversion = conversion;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Obtiene la conversión asociada con este registro.
     * @return La conversión asociada.
     */
    // Getters y setters
    public Conversion getConversion() {
        return conversion;
    }

    /**
     * Establece la conversión asociada con este registro.
     * @param conversion La conversión a establecer.
     */
    public void setConversion(Conversion conversion) {
        this.conversion = conversion;
    }

    /**
     * Obtiene la marca de tiempo de la conversión.
     * @return La marca de tiempo.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Establece la marca de tiempo de la conversión.
     * @param timestamp La marca de tiempo a establecer.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Genera una representación en cadena del registro de conversión.
     * @return La representación en cadena del registro de conversión.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Registro de Conversión: {" +
                "\n  Moneda de Origen: " + conversion.getMonedaOrigen() +
                "\n  Moneda de Destino: " + conversion.getMonedaDestino() +
                "\n  Monto: " + conversion.getMonto() +
                "\n  Conversion Rate: " + conversion.getConversionRate() +
                "\n  Resultado: " + conversion.getResultado() +
                "\n  Marca de Tiempo: " + timestamp.format(formatter) +
                "\n}";
    }
}
