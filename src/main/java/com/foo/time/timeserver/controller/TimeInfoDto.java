package com.foo.time.timeserver.controller;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;

@Data
public class TimeInfoDto {
    private LocalDateTime time;
    private String timeZone;

    public static TimeInfoDto now(ZoneId zoneId) {
        var tm = new TimeInfoDto();
        tm.setTime(LocalDateTime.ofInstant(Instant.now(), zoneId));
        tm.setTimeZone(zoneId.getDisplayName(TextStyle.FULL, Locale.US));
        return tm;
    }
}
