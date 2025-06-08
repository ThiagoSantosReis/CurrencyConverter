package br.com.currencyconverter.controllers;

import br.com.currencyconverter.entities.CurrencyRate;
import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class CurrencyController {
    public static String getCurrency(String currencyCode){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        URI currencyAdress = URI
                .create("https://v6.exchangerate-api.com/v6/65ac7ed9c98e681f4892ac7f/latest/"+currencyCode);

        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(currencyAdress)
                    .build();
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        }catch (Exception e){
            throw new RuntimeException("Error: Incorrect address.");
        }
    }

    public static List<CurrencyRate> getCurrenciesRateList(String currenciesJson){
        List<CurrencyRate> currenciesList = new ArrayList<>();
        JsonObject cRatesObj = JsonParser.parseString(currenciesJson)
                .getAsJsonObject()
                .getAsJsonObject("conversion_rates");

        for(String k : cRatesObj.keySet()){
            double v = cRatesObj.get(k).getAsDouble();
            currenciesList.add(new CurrencyRate(k,v));
        }

        return currenciesList;

    }

}
