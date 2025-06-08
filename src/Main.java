import br.com.currencyconverter.controllers.CurrencyController;
import br.com.currencyconverter.entities.CurrencyRate;
import br.com.currencyconverter.services.ConverterService;
import br.com.currencyconverter.utils.Writer;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<CurrencyRate> currenciesList;
        try{
            System.out.println("Enter input currency: ");
            String inCurrency = sc.next();
            String currenciesData = CurrencyController.getCurrency(inCurrency);
            currenciesList = CurrencyController.getCurrenciesRateList(currenciesData);

            CurrencyController.printCurrencies(currenciesList);

            System.out.println("Select currency's index to convert: ");
            int outIndex = sc.nextInt();
            if(outIndex > currenciesList.size()){
                throw new RuntimeException("Error: value exceeds the available currencies list size.");
            }
            System.out.println("Enter a "+inCurrency+" value to convert: ");
            double value = sc.nextDouble();

            CurrencyRate outCurrency = currenciesList.get(outIndex);
            double conversion = ConverterService.conversion(outCurrency, value);

            System.out.println("BRL -> "+currenciesList.get(0));
            System.out.println(outCurrency.getCode()+" -> "+outCurrency.getRate());
            System.out.println("Result -> "+conversion);

            Writer.writeJsonFile(inCurrency, outCurrency, conversion);

        }catch (RuntimeException | IllegalAccessException | IOException e){
            System.out.println(e.getMessage());
        }

    }
}