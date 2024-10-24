package model;

import java.util.UUID;

public class idGenerator {

    public static String generateUid()
    {
        // random uuid with nort repeating
        return UUID.randomUUID().toString();
    }
}
