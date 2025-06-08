package br.com.currencyconverter.services;

import br.com.currencyconverter.entities.CurrencyRate;

public class ConverterService {
    public static double conversion(CurrencyRate outputCurrency, double amount){
        return outputCurrency.getRate() * amount;
    }
}
