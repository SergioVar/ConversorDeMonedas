import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApiKeyManager apiKeyManager = new ApiKeyManager();
        ExchangeRateAPI exchangeRateAPI = new ExchangeRateAPI(apiKeyManager.getApiKey());
        CurrencyConverter converter = new CurrencyConverter(exchangeRateAPI);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al conversor de monedas.");

        System.out.print("Ingrese la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        System.out.print("Ingrese la moneda de origen (ej: USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Ingrese la moneda de destino (ej: EUR): ");
        String toCurrency = scanner.next().toUpperCase();

        double result = converter.convert(amount, fromCurrency, toCurrency);
        System.out.println(amount + " " + fromCurrency + " equivale a " + result + " " + toCurrency);
    }
}
