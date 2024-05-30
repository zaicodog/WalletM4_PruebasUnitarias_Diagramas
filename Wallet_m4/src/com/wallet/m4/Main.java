package com.wallet.m4;

import java.util.Scanner;
import com.wallet.m4.cuentas.*;
import com.wallet.m4.metodopago.*;
import com.wallet.m4.interfaces.MetodoPago;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear cuentas
        CuentaCLP cuentaPeso = new CuentaCLP(123456, "Juan Perez", 1000);
        CuentaUSD cuentaDolar = new CuentaUSD(789012, "Maria Lopez", 1000.0);
        CuentaEuro cuentaEuro = new CuentaEuro(345678, "Pedro Rodriguez", 1000.0);

        // Crear billetera
        Billetera billetera = new Billetera();

        while (true) {
            System.out.println("\n================== MENU ==================");
            System.out.println("1. Mostrar información de las cuentas");
            System.out.println("2. Realizar operaciones en las cuentas");
            System.out.println("3. Seleccionar método de pago y Realizar pago");
            System.out.println("4. Agregar tarjeta de crédito");
            System.out.println("5. Salir ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nInformación de la Cuenta en Pesos Chilenos:");
                    cuentaPeso.mostrarInformacion();
                    System.out.println("\nInformación de la Cuenta en Dólares:");
                    cuentaDolar.mostrarInformacion();
                    System.out.println("\nInformación de la Cuenta en Euros:");
                    cuentaEuro.mostrarInformacion();
                    break;
                case 2:
                    // Aquí puedes agregar la lógica para realizar operaciones en las cuentas
                    break;
                case 3:
                    if (billetera.getMetodosPago().size() > 0) {
                        System.out.println("\nSeleccionar método de pago:");
                        billetera.mostrarMetodosPago();
                        System.out.print("Ingrese el índice del método de pago a seleccionar: ");
                        int metodoIndex = scanner.nextInt();
                        if (metodoIndex >= 0 && metodoIndex < billetera.getMetodosPago().size()) {
                            MetodoPago metodoSeleccionado = billetera.getMetodosPago().get(metodoIndex);
                            billetera.seleccionarMetodoPago(metodoSeleccionado);
                            
                            System.out.println("\nSeleccionar cuenta para realizar el pago:");
                            System.out.println("1. Cuenta en Pesos Chilenos (Juan Perez)");
                            System.out.println("2. Cuenta en Dólares (Maria Lopez)");
                            System.out.println("3. Cuenta en Euros (Pedro Rodriguez)");
                            System.out.print("Seleccione la cuenta desde la cual desea realizar el pago (1-3): ");
                            int cuentaIndex = scanner.nextInt();
                            Cuenta cuentaSeleccionada = null;
                            switch (cuentaIndex) {
                                case 1:
                                    cuentaSeleccionada = cuentaPeso;
                                    break;
                                case 2:
                                    cuentaSeleccionada = cuentaDolar;
                                    break;
                                case 3:
                                    cuentaSeleccionada = cuentaEuro;
                                    break;
                                default:
                                    System.out.println("Selección de cuenta no válida.");
                                    break;
                            }
                            if (cuentaSeleccionada != null) {
                                System.out.print("Ingrese el monto a pagar: ");
                                double monto = scanner.nextDouble();
                                if (cuentaSeleccionada.retirar(monto)) {
                                    metodoSeleccionado.realizarPago(monto);
                                }
                            }
                        } else {
                            System.out.println("Índice de método de pago no válido.");
                        }
                    } else {
                        System.out.println("No hay métodos de pago disponibles.");
                    }
                    break;

                case 4:
                    System.out.println("\nAgregar tarjeta de crédito:");
                    System.out.println("1. Agregar tarjeta de crédito para la cuenta de Juan Perez");
                    System.out.println("2. Agregar tarjeta de crédito para la cuenta de Maria Lopez");
                    System.out.println("3. Agregar tarjeta de crédito para la cuenta de Pedro Rodriguez");
                    System.out.print("Seleccione la opción para agregar tarjeta de crédito (1-3): ");
                    int agregarTarjetaIndex = scanner.nextInt();
                    switch (agregarTarjetaIndex) {
                        case 1:
                            agregarTarjetaCredito(billetera, scanner, cuentaPeso);
                            break;
                        case 2:
                            agregarTarjetaCredito(billetera, scanner, cuentaDolar);
                            break;
                        case 3:
                            agregarTarjetaCredito(billetera, scanner, cuentaEuro);
                            break;
                        default:
                            System.out.println("Selección no válida.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void agregarTarjetaCredito(Billetera billetera, Scanner scanner, Cuenta cuenta) {
        System.out.println("¿Desea agregar una tarjeta de crédito para la cuenta de " + cuenta.getTitular() + "? (s/n)");
        char respuesta = scanner.next().charAt(0);
        if (respuesta == 's' || respuesta == 'S') {
            billetera.agregarMetodoPago(new TarjetaCredito(cuenta));
            System.out.println("Tarjeta de crédito agregada para la cuenta de " + cuenta.getTitular());
        }
    }
}
