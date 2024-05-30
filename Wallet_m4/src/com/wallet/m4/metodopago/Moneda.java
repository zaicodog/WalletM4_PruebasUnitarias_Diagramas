package com.wallet.m4.metodopago;

import com.wallet.m4.cuentas.CuentaCLP;
import com.wallet.m4.interfaces.MetodoPago;

public class Moneda implements MetodoPago {
    private CuentaCLP cuenta;

    public Moneda(CuentaCLP cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void realizarPago(double monto) {
        double saldoActual = cuenta.getSaldo();
        if (saldoActual >= monto) {
            cuenta.retirar(monto);
            System.out.println("Pago realizado con éxito. Saldo restante: " + cuenta.getSaldo());
        } else {
            System.out.println("Saldo insuficiente para realizar el pago.");
        }
    }

    @Override
    public double verificarSaldo() {
        return cuenta.getSaldo();
    }

	@Override
	public void realizarPago(double monto, String monedaPago) {
		// TODO Auto-generated method stub
		
	}
}

