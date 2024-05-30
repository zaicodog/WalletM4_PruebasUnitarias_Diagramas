package com.wallet.m4.metodopago;

import com.wallet.m4.interfaces.MetodoPago;
import java.util.ArrayList;
import java.util.List;
import com.wallet.m4.metodopago.SeleccionMetodoPago;

public class SeleccionMetodoPago {
    private List<MetodoPago> metodosPago;
    private MetodoPago metodoPagoActual;

    public SeleccionMetodoPago() {
        this.metodosPago = new ArrayList<>();
        this.metodoPagoActual = null;
    }

    public void agregarMetodoPago(MetodoPago metodoPago) {
        this.metodosPago.add(metodoPago);
    }

    public void eliminarMetodoPago(MetodoPago metodoPago) {
        this.metodosPago.remove(metodoPago);
    }

    public void seleccionarMetodoPago(MetodoPago metodoPago) {
        if (this.metodosPago.contains(metodoPago)) {
            this.metodoPagoActual = metodoPago;
        } else {
            System.out.println("Error: El método de pago seleccionado no se encuentra en la SeleccionMetodoPago.");
        }
    }

    public void mostrarMetodosPago() {
        System.out.println("Métodos de pago disponibles:");
        for (MetodoPago metodoPago : this.metodosPago) {
            System.out.println(metodoPago.getClass().getSimpleName());
        }
    }

    public void realizarPago(double monto) {
        if (metodoPagoActual == null) {
            System.out.println("Error: No se ha seleccionado un método de pago.");
        } else {
            metodoPagoActual.realizarPago(monto);
        }
    }

    public List<MetodoPago> getMetodosPago() {
        return metodosPago;
    }
}
