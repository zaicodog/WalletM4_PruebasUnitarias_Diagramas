package com.wallet.m4.metodopago;

import com.wallet.m4.cuentas.Cuenta;
import com.wallet.m4.interfaces.MetodoPago;

import java.time.LocalDate;

public class TarjetaCredito implements MetodoPago {
    private Cuenta cuenta;
    private LocalDate proximoPago;

    public TarjetaCredito(Cuenta cuenta) {
        this.cuenta = cuenta;
        this.proximoPago = null;
    }

    @Override
    public void realizarPago(double monto, String monedaPago) {
        // Verificar si hay un método de pago seleccionado
        if (cuenta == null) {
            System.out.println("No hay un método de pago seleccionado.");
            return;
        }

        // Convertir el monto del pago a la moneda de la cuenta
        double montoEnMonedaCuenta = ConversionMoneda.convertir(monto, monedaPago, monedaPago);

        double saldoActual = cuenta.getSaldo();
        if (saldoActual >= montoEnMonedaCuenta) {
            System.out.println("Pago realizado con tarjeta de crédito. Saldo restante: " + cuenta.getSaldo());

            // Agendar el próximo pago en 30 días
            programarProximoPago(30); // Programa el próximo pago en 30 días
        } else {
            System.out.println("Saldo insuficiente para realizar el pago con tarjeta de crédito.");
        }
    }

    @Override
    public double verificarSaldo() {
        return cuenta.getSaldo();
    }

    private void programarProximoPago(int dias) {
        proximoPago = LocalDate.now().plusDays(dias);
        System.out.println("Próximo pago agendado para: " + proximoPago);
    }

	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		
	}
}
