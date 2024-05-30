package com.wallet.m4.interfaces;

public interface MetodoPago {
    void realizarPago(double monto);
    double verificarSaldo();
	void realizarPago(double monto, String monedaPago);
}
