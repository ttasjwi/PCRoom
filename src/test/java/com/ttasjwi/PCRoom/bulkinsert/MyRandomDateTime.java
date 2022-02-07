package com.ttasjwi.PCRoom.bulkinsert;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class MyRandomDateTime {

    public static LocalDateTime generate() {
        long now = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        long monthSecond = 60 * 60 * 24 * 30;
        long randomEpochSecond = now - (long)(Math.random() * monthSecond);
        return LocalDateTime.ofEpochSecond(randomEpochSecond,0, ZoneOffset.UTC);
    }
}
