package br.com.currencyconverter.entities;

public class CurrencyRate {
    private String code;
    private Double rate;

    public CurrencyRate(String code, double rate){
        this.code = code;
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public Double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return code+": "+rate;
    }
}
