package com.wallet.m4.cuentas;

import java.util.Scanner;

public class Cuenta {
    private int numeroCuenta;
    private String titular;
    private double saldo;
    
    public Cuenta() {
        this.numeroCuenta = 0;
        this.titular = "";
        this.saldo = 0.0;
    }
    
    public Cuenta(int numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }
    
    public static Cuenta crearCuentaDesdeTeclado(Scanner scanner) {
        System.out.println("Ingrese el numero de cuenta:");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del titular:");
        String titular = scanner.nextLine();
        System.out.println("Ingrese el saldo:");
        double saldo = scanner.nextDouble();
        return new Cuenta(numeroCuenta, titular, saldo);
    }          
    // getters y setters
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("La cantidad a depositar debe ser positiva.");
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro realizado. Nuevo saldo: " + saldo);
            return true;
        } else {
            System.out.println("Fondos insuficientes o cantidad no válida.");
            return false;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }

	public double exchangeRate(String fromCurrency, String toCurrency) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double convert(double amount, String fromCurrency, String toCurrency) {
		// TODO Auto-generated method stub
		return 0;
	}
}
