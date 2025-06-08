import br.com.currencyconverter.controllers.CurrencyController;
import br.com.currencyconverter.entities.CurrencyRate;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<CurrencyRate> currenciesToConvert;
        try{
            System.out.println("Enter input currency: ");
            String inCurrency = sc.next();

            String currenciesData = CurrencyController.getCurrency(inCurrency);
            currenciesToConvert = CurrencyController.getCurrenciesRateList(currenciesData);

            CurrencyController.printCurrencies(currenciesToConvert);
            System.out.println("Select currency's index to convert: ");

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}