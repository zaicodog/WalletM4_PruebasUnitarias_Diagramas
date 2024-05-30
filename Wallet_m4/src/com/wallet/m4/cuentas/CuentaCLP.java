package com.wallet.m4.cuentas;

import com.wallet.m4.interfaces.IServicioTransaccion;
import com.wallet.m4.interfaces.MostrarInfo;

public class CuentaCLP extends Cuenta implements IServicioTransaccion, MostrarInfo {
    
    public CuentaCLP(int numeroCuenta, String titular, double saldo) {
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
        // Aquí implementaremos la lógica para obtener la tasa de cambio
        if (fromCurrency.equals("USD") && toCurrency.equals("CLP")) {
            return 800.0; // 1 USD = 800 CLP
        } else if (fromCurrency.equals("CLP") && toCurrency.equals("USD")) {
            return 0.00125; // 1 CLP = 0.00125 USD
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("CLP")) {
            return 900.0; // 1 EUR = 900 CLP
        } else if (fromCurrency.equals("CLP") && toCurrency.equals("EUR")) {
            return 0.0011; // 1 CLP = 0.0011 EUR
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
                System.out.println("Error: Saldo insuficiente para retirar " + cantidad + " pesos chilenos.");
                return false;
            }
        } else {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
            return false;
        }
    }
}
