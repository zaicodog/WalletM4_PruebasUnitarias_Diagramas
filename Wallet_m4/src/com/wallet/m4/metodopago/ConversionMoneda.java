package com.wallet.m4.metodopago;

public class ConversionMoneda {
    private static final double TASA_USD_A_CLP = 750.0;
    private static final double TASA_EUR_A_CLP = 850.0;
    private static final double TASA_CLP_A_USD = 1 / TASA_USD_A_CLP;
    private static final double TASA_CLP_A_EUR = 1 / TASA_EUR_A_CLP;
    private static final double TASA_USD_A_EUR = 0.88;
    private static final double TASA_EUR_A_USD = 1 / TASA_USD_A_EUR;

    public static double convertir(double monto, String de, String a) {
        if (de.equals(a)) {
            return monto;
        }
        switch (de + "->" + a) {
            case "CLP->USD":
                return monto * TASA_CLP_A_USD;
            case "CLP->EUR":
                return monto * TASA_CLP_A_EUR;
            case "USD->CLP":
                return monto * TASA_USD_A_CLP;
            case "USD->EUR":
                return monto * TASA_USD_A_EUR;
            case "EUR->CLP":
                return monto * TASA_EUR_A_CLP;
            case "EUR->USD":
                return monto * TASA_EUR_A_USD;
            default:
                throw new RuntimeException("Conversión no soportada.");
        }
    }
}
