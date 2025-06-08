import br.com.currencyconverter.controllers.CurrencyController;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        try{
            String  dto = CurrencyController.getCurrency("BRL");
            CurrencyController.getCurrenciesRateList(dto);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }
}