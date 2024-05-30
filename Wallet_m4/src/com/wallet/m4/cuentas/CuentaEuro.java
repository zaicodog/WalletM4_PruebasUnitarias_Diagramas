package com.wallet.m4.cuentas;

import com.wallet.m4.interfaces.IServicioTransaccion;
import com.wallet.m4.interfaces.MostrarInfo;

public class CuentaEuro extends Cuenta implements IServicioTransaccion, MostrarInfo {
    
    public CuentaEuro(int numeroCuenta, String titular, double saldo) {
        super(numeroCuenta, titular, saldo);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Número de cuenta: " + getNumeroCuenta());
        System.out.println("Titular: " + getTitular());
        System.out.println("Saldo: " + getSaldo());
    }

    @Override
    public double exchangeRate(String fromCurrency, String toCurrency) {
        // Aquí va tu implementación del método
        if (fromCurrency.equals("EUR") && toCurrency.equals("CLP")) {
            return 900.0; // 1 EUR = 900 CLP
        } else if (fromCurrency.equals("CLP") && toCurrency.equals("EUR")) {
            return 0.0011; // 1 CLP = 0.0011 EUR
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return 1.1; // 1 EUR = 1.1 USD
        } else if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return 0.91; // 1 USD = 0.91 EUR
        }
        return 1.0; // Tasa de cambio por defecto (misma moneda)
    }

    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        double rate = exchangeRate(fromCurrency, toCurrency);
        return amount * rate;
    }

    @Override
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            setSaldo(getSaldo() + cantidad);
            System.out.println("Depósito exitoso. Nuevo saldo: " + getSaldo());
        } else {
            System.out.println("Error: La cantidad a depositar debe ser mayor que cero.");
        }
    }

    @Override
    public boolean retirar(double cantidad) {
        if (cantidad > 0) {
            if (getSaldo() >= cantidad) {
                setSaldo(getSaldo() - cantidad);
                System.out.println("Retiro exitoso. Nuevo saldo: " + getSaldo());
                return true;
            } else {
                System.out.println("Error: Saldo insuficiente para retirar " + cantidad + " euros.");
                return false;
            }
        } else {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
            return false;
        }
    }
}
