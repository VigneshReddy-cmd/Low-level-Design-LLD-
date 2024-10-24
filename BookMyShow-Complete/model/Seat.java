package model;

public class Seat {
    private final String seatNumber;

    private SeatStatus seatStatus;

    private SeatType seatType;

    public Seat(String seatNumber, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.seatStatus = SeatStatus.AVALIABLE;
        this.seatType = seatType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public static double getSeatPrice(Seat seat) {
        return seat.getSeatType().getPrice();
    }
}
