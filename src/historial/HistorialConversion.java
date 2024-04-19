package historial;

import conversion.RegistroConversion; // Importa la clase RegistroConversion del paquete conversion
import java.util.ArrayList; // Importa la clase ArrayList del paquete java.util
import java.util.List; // Importa la interfaz List del paquete java.util

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