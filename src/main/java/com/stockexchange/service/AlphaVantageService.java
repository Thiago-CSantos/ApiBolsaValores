package com.stockexchange.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stockexchange.model.stocks.Stock;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AlphaVantageService {

    public Stock getPrice(String targetDate, String symbol) throws IOException, InterruptedException {
        String api_key = "QIJVEB27NEQRGFET";
        // String symbol = "PETR4.SA";
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + api_key))
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> resposta = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        String respotaBody = resposta.body();

        JsonObject jsonObject = JsonParser.parseString(respotaBody).getAsJsonObject();
        // Obtém o JsonObject "Time Series (Daily)"
        JsonObject timeSeries = jsonObject.getAsJsonObject("Time Series (Daily)");
        // Obtém os dados da data desejada
        JsonObject targetDados = timeSeries.getAsJsonObject(targetDate);

        if (targetDados != null) {
            Double abertura = targetDados.get("1. open").getAsDouble();
            Double maxima = targetDados.get("2. high").getAsDouble();
            Double minima = targetDados.get("3. low").getAsDouble();
            Double fechamento = targetDados.get("4. close").getAsDouble();
            Double volume = targetDados.get("5. volume").getAsDouble();

            System.out.println("Symbol: " + symbol);
            System.out.println("Data: " + targetDate);
            System.out.println("Abertura: " + targetDados.get("1. open"));
            System.out.println("Máxima: " + targetDados.get("2. high"));
            System.out.println("Mínima: " + targetDados.get("3. low"));
            System.out.println("Fechamento: " + targetDados.get("4. close"));
            System.out.println("Volume: " + targetDados.get("5. volume"));

            return new Stock(symbol, targetDate, abertura, maxima, minima, fechamento, volume, 1);
        } else {
            System.out.println("Dados não encontrados para a data: " + targetDate);
            return null;
        }
    }

    public String getByPriceClose(String targetDate, String symbol) {
        try {
            String api_key = "QIJVEB27NEQRGFET";
            // String symbol = "PETR4.SA";
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + api_key))
                    .build();

            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpResponse<String> resposta = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String respotaBody = resposta.body();

            JsonObject jsonObject = JsonParser.parseString(respotaBody).getAsJsonObject();
            // Obtém o JsonObject "Time Series (Daily)"
            JsonObject timeSeries = jsonObject.getAsJsonObject("Time Series (Daily)");
            // Obtém os dados da data desejada
            JsonObject targetDados = timeSeries.getAsJsonObject(targetDate);

            if (targetDados != null) {
                return String.valueOf(targetDados.get("4. close"));
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return "Dados não encontrados para a data: " + targetDate;
    }

}
