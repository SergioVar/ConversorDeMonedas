public class CurrencyConverter {
    private ExchangeRateAPI exchangeRateAPI;

    public CurrencyConverter(ExchangeRateAPI exchangeRateAPI) {
        this.exchangeRateAPI = exchangeRateAPI;
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        try {
            double rate = exchangeRateAPI.getExchangeRate(fromCurrency, toCurrency);
            return amount * rate;
        } catch (Exception e) {
            System.out.println("Error al convertir monedas: " + e.getMessage());
            return 0;
        }
    }
}
