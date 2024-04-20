import conversion.Conversion;
import menu.MenuHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal que inicia el Convertidor de Monedas.
 */

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("\n************************************************************");
        System.out.println("Bienvenidos al Convertidor de Monedas- Challenge Backend ONE.");
        try {
            Conversion conversion = new Conversion(); // Crear una instancia de Conversion
           do {
                MenuHandler.mostrarMenu();
                int opcion = lectura.nextInt();
                MenuHandler.ejecutarOpcion(opcion, conversion, lectura); // Pasar Conversion y Scanner
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número válido.");
        } finally {
            lectura.close();
        }
    }
}
