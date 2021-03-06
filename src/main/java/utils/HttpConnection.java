package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

//        stronki z ktorych korzystalem
//        https://exchangeratesapi.io/
//        https://api.exchangeratesapi.io/latest?base=USD

public class HttpConnection {
    double httpRate = 0;

    public double getHttpRate(String currency1, String currency2) throws IOException {
        String ratesHttpApi = System.getProperty("rate.http.api");
        String ulrForRates = ratesHttpApi + currency1;

        URL url = new URL(ulrForRates);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = (JsonObject) root.getAsJsonObject().get("rates");
        httpRate = jsonobj.get(currency2).getAsDouble();

        return this.httpRate;
    }
}