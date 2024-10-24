package model;

import java.util.List;

public class Booking {
    private final String Id;

    private User user;

    private Show show;

    private List<Seat> reservedSeats;

    private double totalAmount;

    private BookingStatus bookingStatus;

    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public Booking(User user, Show show, List<Seat> reservedSeats, double totalAmount) {
        Id = idGenerator.generateUid();
        this.user = user;
        this.show = show;
        this.reservedSeats = reservedSeats;
        this.totalAmount = totalAmount;
        this.bookingStatus=BookingStatus.PENDING;
    }

    public String getId() {
        return Id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<Seat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
}
