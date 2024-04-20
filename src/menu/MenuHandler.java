package menu;

import conversion.Conversion;
import conversion.RegistroConversion;

import java.util.InputMismatchException;
import java.util.Scanner;

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
                Elija una opción: """);

    }

    // Método para ejecutar la opción seleccionada por el usuario
    public static void ejecutarOpcion(int opcion, Conversion c, Scanner lectura) {
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
                elegirOtrasMonedas(c, lectura); // Llama al método para elegir otras monedas a convertir
                break;
            case 8:
                System.out.println("¡Gracias por usar el convertidor! ¡Hasta luego!"); // Mensaje de despedida
                System.exit(0); // Finaliza el programa
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida del menú."); // Mensaje de opción inválida
                break;
        }
    }

    // Método privado para realizar la conversión de moneda
    private static void convertirMoneda(String monedaBase, String monedaDestino, Conversion c, Scanner lectura) {
        System.out.println("Ingrese el monto a convertir:"); // Solicita al usuario ingresar el monto a convertir
        int monto = lectura.nextInt(); // Lee el monto ingresado por el usuario
        RegistroConversion registro = c.convertir(monedaBase, monedaDestino, monto); // Realiza la conversión
        mostrarResultado(registro, monedaBase, monedaDestino);
    }

    // Método para elegir otras monedas a convertir
    private static void elegirOtrasMonedas(Conversion c, Scanner lectura) {
        try {
            System.out.println("""
        A continuación, te presento una lista completa de códigos de moneda junto con los países correspondientes:
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
                        12. **AUD**: Australia
                        13. **EUR**: Austria
                        14. **AZN**: Azerbaiyán
                        15. **BSD**: Bahamas
                        16. **BHD**: Bahréin
                        17. **BDT**: Bangladés
                        18. **BBD**: Barbados
                        19. **BYN**: Bielorrusia
                        20. **EUR**: Bélgica
                        21. **BZD**: Belice
                        22. **XOF**: Benín
                        23. **BMD**: Bermudas
                        24. **BTN**: Bután
                        25. **BOB**: Bolivia
                        26. **BOV**: Bolivia (Mvdol)
                        27. **BAM**: Bosnia y Herzegovina
                        28. **BWP**: Botsuana
                        29. **BRL**: Brasil
                        30. **USD**: Territorio Británico del Océano Índico
                        31. **BND**: Brunéi
                        32. **BGN**: Bulgaria
                        33. **XOF**: Burkina Faso
                        34. **BIF**: Burundi
                        35. **CVE**: Cabo Verde
                        36. **KHR**: Camboya
                        37. **XAF**: Camerún
                        38. **CAD**: Canadá
                        39. **KYD**: Islas Caimán
                        40. **XAF**: República Centroafricana
                        41. **XAF**: Chad
                        42. **CLF**: Chile (Unidad de Fomento)
                        43. **CLP**: Chile (Peso chileno)
                        44. **CNY**: China
                        45. **AUD**: Isla de Navidad
                        46. **AUD**: Islas Cocos (Keeling)
                        47. **COP**: Colombia
                        48. **COU**: Colombia (Unidad de Valor Real)
                        49. **KMF**: Comoras
                        50. **CDF**: República Democrática del Congo
                        51. **XAF**: Congo
                        52. **NZD**: Islas Cook
                        53. **CRC**: Costa Rica
                        54. **EUR**: Croacia
                        55. **CUC**: Cuba (Peso convertible)
                        56. **CUP**: Cuba (Peso cubano)
                        57. **ANG**: Curazao
                        58. **EUR**: Chipre
                        59. **CZK**: República Checa
                        60. **XOF**: Costa de Marfil
                        61. **DKK**: Dinamarca
                        62. **DJF**: Yibuti
                        63. **XCD**: Dominica
                        64. **DOP**: República Dominicana
                        65. **USD**: Ecuador
                        66. **EGP**: Egipto
                        67. **SVC**: El Salvador
                        68. **USD**: Guinea Ecuatorial
                        69. **ERN**: Eritrea
                        70. **EUR**: Estonia
                        71. **ETB**: Etiopía
                        72. **EUR**: Unión Europea
                        73. **FKP**: Islas Malvinas (Falkland)
                        74. **DKK**: Islas Feroe
                        75. **FJD**: Fiyi
                        76. **EUR**: Finlandia
        ...
        Elije el código de la moneda que quieras convertir (las 3 letras).
        """);

            System.out.println("Ingrese el código de la moneda base:");
            String monedaBase = lectura.next().toUpperCase(); // Convertir a mayúsculas

            System.out.println("Ingrese el código de la moneda destino:");
            String monedaDestino = lectura.next().toUpperCase(); // Convertir a mayúsculas

            // Verificar si la moneda base y destino son cadenas de letras
            if (!monedaBase.matches("[A-Z]+") || !monedaDestino.matches("[A-Z]+")) {
                System.out.println("Los códigos de moneda deben ser cadenas de letras en mayúsculas.");
                return;
            }

            System.out.println("Ingrese el monto a convertir:");
            // Verificar si el monto es un número entero
            if (!lectura.hasNextInt()) {
                System.out.println("El monto debe ser un número entero.");
                return;
            }
            int monto = lectura.nextInt();

            RegistroConversion registro = c.convertir(monedaBase, monedaDestino, monto);
            mostrarResultado(registro, monedaBase, monedaDestino);
        } catch (RuntimeException e) {
            System.out.println("Error al conectar con el servicio de tasas de cambio. Verifica tu conexión a Internet.");
        }
    }


    // Método privado para mostrar el resultado de la conversión
    // Método privado para mostrar el resultado de la conversión
    private static void mostrarResultado(RegistroConversion registro, String monedaBase, String monedaDestino) {
        if (registro != null) {
            Conversion conversion = registro.getConversion();
            if (conversion != null) {
                double monto = conversion.getMonto();
                double resultado = conversion.getResultado();
                double conversionRate = conversion.getConversionRate();

                // Redondear los valores para mostrar solo dos decimales
                monto = Math.round(monto * 10000.0) / 10000.0;
                resultado = Math.round(resultado * 10000.0) / 10000.0;
                conversionRate = Math.round(conversionRate * 10000.0) / 10000.0;

                System.out.println("************************************************************");
                System.out.println("Resultado de la conversión:");
                System.out.println("---------------------------------");
                System.out.println("Moneda base: " + conversion.getMonedaOrigen() + ": " + String.format("%.0f", monto));
                System.out.println("Moneda destino: " + conversion.getMonedaDestino() + ": " + String.format("%.2f", resultado));
                System.out.println("Monto: " + String.format("%.1f", monto));
                System.out.println("Tasa de conversión: " + String.format("%.5f", conversionRate));
                System.out.println("Resultado: " + String.format("%.2f", resultado));
                System.out.println("************************************************************");

            } else {
                System.out.println("Ha ocurrido un error al obtener la conversión.");
            }
        } else {
            System.out.println("Ha ocurrido un error al convertir la moneda.");
        }
    }

}
