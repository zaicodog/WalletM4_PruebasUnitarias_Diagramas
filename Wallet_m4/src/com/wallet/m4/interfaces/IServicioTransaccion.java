package com.wallet.m4.interfaces;

public interface IServicioTransaccion {
    double exchangeRate(String fromCurrency, String toCurrency);
    double convert(double amount, String fromCurrency, String toCurrency);
    void depositar(double cantidad);
    boolean retirar(double cantidad);
}
