package com.reservation.model;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Reservation {

    private String id;
    private String customerName;
    private String origin;
    private String destination;
    private ZonedDateTime departureTime;
    private double price;
    private Currency currency;

    public Reservation(String customerName, String origin, String destination,
                       ZonedDateTime departureTime, double price, Currency currency) {
        this.id = UUID.randomUUID().toString();
        this.customerName = customerName;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = price;
        this.currency = currency;
    }

    public String getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public ZonedDateTime getDepartureTime() { return departureTime; }
    public double getPrice() { return price; }
    public Currency getCurrency() { return currency; }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", customer='" + customerName + '\'' +
                ", route='" + origin + " -> " + destination + '\'' +
                ", departure=" + departureTime +
                ", price=" + price + " " + currency +
                '}';
    }
}
