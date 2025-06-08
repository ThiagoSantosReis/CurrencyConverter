import br.com.currencyconverter.controllers.CurrencyController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String  dto = CurrencyController.getCurrency("BRL");
        CurrencyController.getCurrenciesRateList(dto);
    }
}