package menu;

import conversion.Conversion;
import conversion.RegistroConversion;

import java.util.Scanner;

public class MenuHandler {
    // Método para mostrar el menú de opciones
    public static void mostrarMenu() {
        System.out.println("\n**************************");
        System.out.println("""
                1-Convertir de USD (dólar) => a ARS (peso Argentino).
                2-Convertir de ARS (peso Argentino) => a USD (dólar).
                3-Convertir de USD (dólar) => a BOB (peso Boliviano).
                4-Convertir de BOB (peso Boliviano) => a USD (dólar).
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
            case 2:
                convertirMoneda("ARS", "USD", c, lectura); // Convertir de ARS a USD
                break;
            case 3:
                convertirMoneda("USD", "BOB", c, lectura); // Convertir de USD a BOB
                break;
            case 4:
                convertirMoneda("BOB", "USD", c, lectura); // Convertir de BOB a USD
                break;
            case 5:
                convertirMoneda("USD", "COP", c, lectura); // Convertir de USD a COP
                break;
            case 6:
                convertirMoneda("COP", "USD", c, lectura); // Convertir de COP a USD
                break;
            case 7:
                // Aquí puedes agregar la lógica para elegir monedas personalizadas
                break;
            case 8:
                System.out.println("Gracias por usar el convertidor. ¡Hasta luego!"); // Mensaje de despedida
                System.exit(0); // Finaliza el programa
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida del menú."); // Mensaje de opción inválida
        }
    }

    // Método privado para realizar la conversión de moneda
    private static void convertirMoneda(String monedaBase, String monedaDestino, Conversion c, Scanner lectura) {
        System.out.println("Ingrese el monto a convertir:"); // Solicita al usuario ingresar el monto a convertir
        int monto = lectura.nextInt(); // Lee el monto ingresado por el usuario
        RegistroConversion registro = c.convertir(monedaBase, monedaDestino, monto); // Realiza la conversión
        if (registro != null) {
            // Muestra el resultado de la conversión
            System.out.println(monto + " " + monedaBase + " = " + registro.getConversion().getResultado() + " " + monedaDestino);
        } else {
            System.out.println("Ha ocurrido un error al convertir la moneda."); // Mensaje de error en caso de que la conversión falle
        }
    }
}

