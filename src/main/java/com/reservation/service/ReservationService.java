package com.reservation.service;

import com.reservation.model.Currency;
import com.reservation.model.Reservation;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    private final List<Reservation> reservations = new ArrayList<>();
    private final CurrencyConverter converter;

    public ReservationService(CurrencyConverter converter) {
        this.converter = converter;
    }

    public Reservation createReservation(String name,
                                         String origin,
                                         String destination,
                                         ZonedDateTime departure,
                                         double price,
                                         Currency currency) {

        Reservation reservation = new Reservation(
                name, origin, destination, departure, price, currency);
                
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> listReservations() {
        return reservations;
    }

    public double getPriceInCurrency(Reservation r, Currency target) {
        return converter.convert(r.getPrice(), r.getCurrency(), target);
    }
}
