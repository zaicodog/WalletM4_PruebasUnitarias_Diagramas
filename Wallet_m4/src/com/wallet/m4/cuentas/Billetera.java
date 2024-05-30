package com.wallet.m4.cuentas;

import com.wallet.m4.metodopago.SeleccionMetodoPago;
import com.wallet.m4.interfaces.MetodoPago;
import com.wallet.m4.metodopago.TarjetaCredito;
import java.util.List;
import java.util.Scanner;

public class Billetera {
    private SeleccionMetodoPago seleccionMetodoPago;

    public Billetera() {
        this.seleccionMetodoPago = new SeleccionMetodoPago();
    }

    public void agregarMetodoPago(MetodoPago metodoPago) {
        seleccionMetodoPago.agregarMetodoPago(metodoPago);
    }

    public void eliminarMetodoPago(MetodoPago metodoPago) {
        seleccionMetodoPago.eliminarMetodoPago(metodoPago);
    }

    public void seleccionarMetodoPago(MetodoPago metodoPago) {
        seleccionMetodoPago.seleccionarMetodoPago(metodoPago);
    }

    public void mostrarMetodosPago() {
        seleccionMetodoPago.mostrarMetodosPago();
    }

    public void realizarPago(double monto) {
        seleccionMetodoPago.realizarPago(monto);
    }

    public List<MetodoPago> getMetodosPago() {
        return seleccionMetodoPago.getMetodosPago();
    }

    public void agregarTarjetaCredito(Scanner scanner, Cuenta cuenta) {
        System.out.println("¿Desea agregar una tarjeta de crédito para la cuenta de " + cuenta.getTitular() + "? (s/n)");
        char respuesta = scanner.next().charAt(0);
        if (respuesta == 's' || respuesta == 'S') {
            this.agregarMetodoPago(new TarjetaCredito(cuenta));
            System.out.println("Tarjeta de crédito agregada para la cuenta de " + cuenta.getTitular());
        }
    }
}
