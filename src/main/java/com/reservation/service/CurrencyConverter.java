package com.reservation.service;

import com.reservation.model.Currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private final Map<Currency, Double> rates = new HashMap<>();

    public CurrencyConverter() {
        rates.put(Currency.USD, 1.0);
        rates.put(Currency.EUR, 0.92);
        rates.put(Currency.BRL, 5.0);
        rates.put(Currency.GBP, 0.78);
        rates.put(Currency.JPY, 150.0);
    }

    public double convert(double amount, Currency from, Currency to) {
        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            throw new IllegalArgumentException("Currency not supported");
        }

        double usdAmount = amount / rates.get(from);
        return usdAmount * rates.get(to);
    }
}
