package com.reservation;

import com.reservation.model.Currency;
import com.reservation.service.CurrencyConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    @Test
    void testConversionBRLtoUSD() {
        CurrencyConverter converter = new CurrencyConverter();
        double result = converter.convert(5.0, Currency.BRL, Currency.USD);
        assertEquals(1.0, result, 0.01);
    }

    @Test
    void testConversionUSDtoEUR() {
        CurrencyConverter converter = new CurrencyConverter();
        double result = converter.convert(1.0, Currency.USD, Currency.EUR);
        assertEquals(0.92, result, 0.01);
    }
}
