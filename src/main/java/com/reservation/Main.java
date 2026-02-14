package com.reservation;

import com.reservation.model.Currency;
import com.reservation.model.Reservation;
import com.reservation.service.CurrencyConverter;
import com.reservation.service.ReservationService;
import com.reservation.util.DateTimeUtil;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        ReservationService service = new ReservationService(converter);

        while (true) {
            System.out.println("\n=== International Reservation System ===");
            System.out.println("1. Create reservation");
            System.out.println("2. List reservations");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 0) break;

            switch (option) {
                case 1 -> {
                    System.out.print("Customer name: ");
                    String name = scanner.nextLine();

                    System.out.print("Origin city: ");
                    String origin = scanner.nextLine();

                    System.out.print("Destination city: ");
                    String destination = scanner.nextLine();

                    System.out.print("Year: ");
                    int year = scanner.nextInt();

                    System.out.print("Month: ");
                    int month = scanner.nextInt();

                    System.out.print("Day: ");
                    int day = scanner.nextInt();

                    System.out.print("Hour: ");
                    int hour = scanner.nextInt();

                    System.out.print("Minute: ");
                    int minute = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Time zone (e.g. Europe/Paris): ");
                    String zone = scanner.nextLine();

                    ZonedDateTime dateTime =
                            DateTimeUtil.createDateTime(year, month, day, hour, minute, zone);

                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Currency (USD, EUR, BRL, GBP, JPY): ");
                    Currency currency =
                            Currency.valueOf(scanner.nextLine().toUpperCase());

                    Reservation r = service.createReservation(
                            name, origin, destination, dateTime, price, currency
                    );

                    System.out.println("Created: " + r);
                }

                case 2 -> {
                    for (Reservation r : service.listReservations()) {
                        double priceUSD =
                                service.getPriceInCurrency(r, Currency.USD);

                        System.out.println(r);
                        System.out.println("Price in USD: " + priceUSD);
                        System.out.println("--------------------------");
                    }
                }
            }
        }
        scanner.close();
    }
}
