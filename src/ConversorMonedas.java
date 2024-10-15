import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import java.util.Scanner;

public class ConversorMonedas {
    // API Key proporcionada
    private static final String API_KEY = "4668cae80e33b5b1dee51d1e";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de monedas disponibles
        String[] monedasDisponibles = {"USD", "EUR", "GBP", "MXN", "JPY", "CAD", "AUD", "CHF"};

        // Mostrar lista de monedas disponibles
        System.out.println("Monedas disponibles:");
        for (int i = 0; i < monedasDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + monedasDisponibles[i]);
        }

        // Pedir al usuario que ingrese la moneda de origen
        String monedaOrigen = obtenerMoneda(scanner, "Introduce la moneda de origen (elige el número): ", monedasDisponibles);

        // Pedir al usuario que ingrese la moneda de destino
        String monedaDestino = obtenerMoneda(scanner, "Introduce la moneda de destino (elige el número): ", monedasDisponibles);

        // Pedir la cantidad a convertir
        System.out.print("Introduce la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        // Construir la URL con la moneda de origen
        String apiUrlConMoneda = API_URL + monedaOrigen;

        try {
            // Crear el cliente Http
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrlConMoneda))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Si la solicitud fue exitosa (código 200)
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();

                // Parsear la respuesta JSON
                JSONObject jsonObject = new JSONObject(jsonResponse);
                JSONObject rates = jsonObject.getJSONObject("conversion_rates");

                // Verificar si la moneda de destino existe en la respuesta
                if (rates.has(monedaDestino)) {
                    double tasaCambio = rates.getDouble(monedaDestino);
                    double resultado = cantidad * tasaCambio;

                    System.out.println("Tasa de cambio: 1 " + monedaOrigen + " = " + tasaCambio + " " + monedaDestino);
                    System.out.println("Resultado: " + cantidad + " " + monedaOrigen + " equivale a " + resultado + " " + monedaDestino);
                } else {
                    System.out.println("Moneda de destino no encontrada.");
                }
            } else {
                System.out.println("Error en la solicitud: Código " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para obtener una moneda válida del usuario
    private static String obtenerMoneda(Scanner scanner, String mensaje, String[] monedasDisponibles) {
        String moneda = "";
        boolean monedaValida = false;
        while (!monedaValida) {
            System.out.print(mensaje);
            int seleccion = scanner.nextInt();
            if (seleccion > 0 && seleccion <= monedasDisponibles.length) {
                moneda = monedasDisponibles[seleccion - 1];
                monedaValida = true;
            } else {
                System.out.println("Selección no válida. Por favor, elige un número entre 1 y " + monedasDisponibles.length);
            }
        }
        return moneda;
    }
}
