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

    // Método toString para representación de cadena
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Construye y retorna una cadena que representa este registro de conversión
        return conversion.getMonedaOrigen() + " " + conversion.getMonedaDestino() + " " + conversion.getMonto() + " " + conversion.getResultado() + " " + timestamp.format(formatter);
    }
}
