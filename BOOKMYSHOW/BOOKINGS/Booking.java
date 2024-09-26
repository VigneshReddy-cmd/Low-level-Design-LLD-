package BOOKMYSHOW.BOOKINGS;

import java.lang.reflect.Member;
import java.sql.Date;
import java.util.List;

import BOOKMYSHOW.Cinema.Audi;
import BOOKMYSHOW.Cinema.Seat;
import BOOKMYSHOW.Cinema.Show;


public class Booking {
    String Id;
    Date date;
    Member member;
    Show show;
    Audi audi;
    BOOKINGSTATUS bookingStatus;
    double Amount;
    List<Seat> seats;
    Payment payment;
    boolean makePayment(Payment payment){
        return false;
    }    
}
