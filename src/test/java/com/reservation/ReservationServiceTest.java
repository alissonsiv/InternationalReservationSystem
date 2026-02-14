package com.reservation;

import com.reservation.model.Currency;
import com.reservation.model.Reservation;
import com.reservation.service.CurrencyConverter;
import com.reservation.service.ReservationService;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {

    @Test
    void shouldCreateReservation() {
        CurrencyConverter converter = new CurrencyConverter();
        ReservationService service = new ReservationService(converter);

        Reservation r = service.createReservation(
                "Ana",
                "São Paulo",
                "Paris",
                ZonedDateTime.now(),
                1000,
                Currency.USD
        );

        assertNotNull(r.getId());
        assertEquals("Ana", r.getCustomerName());
    }
}
