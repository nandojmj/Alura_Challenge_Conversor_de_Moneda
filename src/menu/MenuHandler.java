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
            Esta lista contiene los códigos de moneda y sus respectivos países para facilitar la conversión de moneda:
        
            | 1.  **AED**: United Arab Emirates      | 2.  **AFN**: Afghanistan          | 3.  **ALL**: Albania
            | 4.  **AMD**: Armenia                   | 5.  **ANG**: Netherlands Antilles | 6.  **AOA**: Angola
            | 7.  **ARS**: Argentina                 | 8.  **AUD**: Australia            | 9.  **AWG**: Aruba
            | 10. **AZN**: Azerbaijan                | 11. **BBD**: Barbados             | 12. **BGN**: Bulgaria
            | 13. **BHD**: Bahrain                   | 14. **BRL**: Brazil               | 15. **BSD**: Bahamas
            | 16. **BTN**: Bhutan                    | 17. **BWP**: Botswana             | 18. **BZD**: Belize
            | 19. **CAD**: Canada                    | 20. **CHF**: Switzerland          | 21. **CLP**: Chile
            | 22. **CNY**: China                     | 23. **COP**: Colombia             | 24. **CRC**: Costa Rica
            | 25. **CUP**: Cuba                      | 26. **CVE**: Cape Verde           | 27. **CZK**: Czech Republic
            | 28. **DKK**: Denmark                   | 29. **DOP**: Dominican Republic   | 30. **DZD**: Algeria
            | 31. **EGP**: Egypt                     | 32. **ERN**: Eritrea              | 33. **ETB**: Ethiopia
            | 34. **EUR**: European Union            | 35. **FJD**: Fiji                 | 36. **FKP**: Falkland Islands
            | 37. **GBP**: United Kingdom            | 38. **GEL**: Georgia              | 39. **GHS**: Ghana
            | 40. **GIP**: Gibraltar                 | 41. **GMD**: The Gambia           | 42. **GNF**: Guinea
            | 43. **GTQ**: Guatemala                 | 44. **GYD**: Guyana               | 45. **HKD**: Hong Kong
            | 46. **HNL**: Honduras                  | 47. **HRK**: Croatia              | 48. **HTG**: Haiti
            | 49. **HUF**: Hungary                   | 50. **IDR**: Indonesia            | 51. **ILS**: Israel
            | 52. **IMP**: Isle of Man               | 53. **INR**: India                | 54. **IQD**: Iraq
            | 55. **IRR**: Iran                      | 56. **ISK**: Iceland              | 57. **JMD**: Jamaica
            | 58. **JOD**: Jordan                    | 59. **JPY**: Japan                | 60. **KES**: Kenya
            | 61. **KGS**: Kyrgyzstan                | 62. **KHR**: Cambodia             | 63. **KID**: Kiribati
            | 64. **KMF**: Comoros                   | 65. **KRW**: South Korea          | 66. **KWD**: Kuwait
            | 67. **KYD**: Cayman Islands            | 68. **KZT**: Kazakhstan           | 69. **LAK**: Laos
            | 70. **LBP**: Lebanon                   | 71. **LKR**: Sri Lanka            | 72. **LRD**: Liberia
            | 73. **LSL**: Lesotho                   | 74. **LYD**: Libya                | 75. **MAD**: Morocco
            | 76. **MDL**: Moldova                   | 77. **MGA**: Madagascar           | 78. **MKD**: North Macedonia
            | 79. **MMK**: Myanmar                   | 80. **MNT**: Mongolia             | 81. **MOP**: Macau
            | 82. **MUR**: Mauritius                 | 83. **MVR**: Maldives             | 84. **MWK**: Malawi
            | 85. **MXN**: Mexico                    | 86. **MYR**: Malaysia             | 87. **MZN**: Mozambique
            | 88. **NAD**: Namibia                   | 89. **NGN**: Nigeria              | 90. **NIO**: Nicaragua
            | 91. **NOK**: Norway                    | 92. **NPR**: Nepal                | 93. **NZD**: New Zealand
            | 94. **OMR**: Oman                      | 95. **PAB**: Panama               | 96. **PEN**: Peru
            | 97. **PGK**: Papua New Guinea          | 98. **PHP**: Philippines          | 99. **PKR**: Pakistan
            | 100. **PLN**: Poland
            Selecciona la moneda que deseas convertir mediante su código (3 letras).
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
