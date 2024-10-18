import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateAPI {
    private String apiKey;

    public ExchangeRateAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        String urlString = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + fromCurrency + "/" + toCurrency;
        URL url = new URL(urlString);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(request.getInputStream());
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        reader.close();

        if (jsonObject.get("result").getAsString().equals("success")) {
            return jsonObject.get("conversion_rate").getAsDouble();
        } else {
            throw new Exception("Error al obtener la tasa de cambio.");
        }
    }
}

