package br.com.currencyconverter.controllers;

import br.com.currencyconverter.entities.CurrencyRate;
import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CurrencyController {
    public static String getCurrency(String currencyCode) throws IllegalAccessException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if(currencyCode.length() != 3){
            throw new IllegalAccessException("Error: Currency code must have only 3 characters.");
        }
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

    public static void printCurrencies(List<CurrencyRate> currencies){
        for(int i = 0; i < currencies.size(); i++){
            if(i == 0){
                continue;
            }
            System.out.println(i+" - "+currencies.get(i).getCode());
        }
    }

}
