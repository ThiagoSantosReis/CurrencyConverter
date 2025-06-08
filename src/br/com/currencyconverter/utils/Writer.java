package br.com.currencyconverter.utils;

import br.com.currencyconverter.entities.CurrencyRate;
import com.google.gson.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Writer {
    public static void writeJsonFile(String inCurrency,
                                     CurrencyRate outCurrency, double conversionResult) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray arr;
        JsonObject fileObj = new JsonObject();
        fileObj.addProperty("from_currency", inCurrency);
        fileObj.addProperty("to_currency", outCurrency.getCode());
        fileObj.addProperty("result", conversionResult);



        if (Files.exists(Paths.get("conversions.json"))){
            try{
                Reader r = new FileReader("conversions.json");
                arr = JsonParser.parseReader(r).getAsJsonArray();
            } catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
                throw new RuntimeException(e);
            }
        }else{
            arr = new JsonArray();
        }

        arr.add(fileObj);

        try {
            FileWriter writer = new FileWriter("conversions.json");
            writer.write(gson.toJson(arr));
            writer.close();
        } catch (IOException e) {
            throw new IOException(e);
        }


    }
}
