package br.com.currencyconverter.utils;

import br.com.currencyconverter.entities.CurrencyRate;
import com.google.gson.JsonObject;

public class Writer {
    public static void writeJsonFile(String inCurrency,
                                     CurrencyRate outCurrency, double conversionResult){
        JsonObject fileObj = new JsonObject();
        fileObj.addProperty("from_currency", inCurrency);
        fileObj.addProperty("to_currency", outCurrency.getCode());
        fileObj.addProperty("result", conversionResult);

        

    }
}
