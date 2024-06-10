package CARRENTAL.BookingSystem;

import java.sql.Date;
import java.sql.Time;

public class Invoices {
    double price;
    long min;
    long km_Driven;
    long m_Driven;
    Date date;
    public Invoices(Pickup pickup,Drop drop_,long km_Driven){
        java.util.Date date = new java.util.Date();    
        this.date=(Date) date;
        Time pick=pickup.time;
        Time drop=drop_.time;
        long differenceInMillis = pick.getTime() - drop.getTime();

        // Convert the difference to hours, minutes, and seconds
        long differenceInSeconds = differenceInMillis / 1000;
        long hours = differenceInSeconds / 3600;
        long minutes = (differenceInSeconds % 3600) / 60;
        long seconds = differenceInSeconds % 60;
        this.min=minutes;
        this.km_Driven=km_Driven;
        this.m_Driven=km_Driven*1000;
    }
}
