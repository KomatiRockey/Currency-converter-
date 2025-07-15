
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    private static HashMap<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample exchange rates to USD
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("INR", 83.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("JPY", 157.3);
        exchangeRates.put("GBP", 0.78);

        System.out.println("💱 Currency Converter");
        System.out.println("Available currencies: USD, INR, EUR, JPY, GBP");

        System.out.print("Enter base currency: ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency: ");
        String targetCurrency = scanner.next().toUpperCase();

        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("❌ Invalid currency code. Try again with supported codes.");
            return;
        }

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double baseToUSD = amount / exchangeRates.get(baseCurrency);
        double convertedAmount = baseToUSD * exchangeRates.get(targetCurrency);

        System.out.printf("✅ %.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }
}
