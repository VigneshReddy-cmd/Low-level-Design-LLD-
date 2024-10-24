package BOOKMYSHOW.Cinema;

import java.sql.Time;
import java.util.List;

public class Show {
    String Id;
    String movieName;
    Time start_time;
    Time end_time;
    CinemaHall cinemaPlayedAt;
    // seats must be present in the AUDi but here we make bookings of seats depends on the status type
    List<Seat> seats;
}
