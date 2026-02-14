package com.reservation.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUtil {

    public static ZonedDateTime createDateTime(
            int year, int month, int day,
            int hour, int minute,
            String zone) {

        return ZonedDateTime.of(
                year, month, day,
                hour, minute, 0, 0,
                ZoneId.of(zone)
        );
    }
}
