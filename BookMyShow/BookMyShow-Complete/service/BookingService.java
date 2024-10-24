package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Payment.PaymentObserver;
import Payment.PaymentStrategy;
import Payment.PaymentStratergyFactory;
import model.Booking;
import model.BookingStatus;
import model.Movie;
import model.Multiplex;
import model.Payment;
import model.PaymentMethod;
import model.Seat;
import model.SeatStatus;
import model.Show;
import model.User;

public class BookingService {

    /**
     * volatile is user=d for the thread safe
     */
    private volatile static BookingService instance = null;

    private final List<Movie> movies;

    private final List<Multiplex> multiplexs;

    private final Map<String, Show> shows;

    private final Map<String, Booking> bookings;

    private PaymentService paymentService;

    /**
     * whole application must have single instance of the booking service
     * using violatile static for thread safe
     */
    private BookingService() {
        this.movies = new ArrayList<>();
        this.multiplexs = new ArrayList<>();
        this.shows = new HashMap<>();
        this.bookings = new HashMap<>();
        paymentService=PaymentService.getInstance();
    }

    public static BookingService getInstance() {
        if (instance == null) {
            synchronized (BookingService.class) {
                if (instance == null) // double checking
                    instance = new BookingService();
            }
        }
        return instance;

    }

    public void addObserver(PaymentObserver observer)
    {
        paymentService.addObserver(observer);
    }

    /**
     * @param movie
     *              Admin has acess to add movie
     */
    public void addMovies(Movie movie) {
        movies.add(movie);
    }

    /**
     * @param multiplex
     *                  Admin can add multiplex
     */
    public void addMultiplex(Multiplex multiplex) {
        multiplexs.add(multiplex);
    }

    /**
     * @param show
     *             Admin can add show
     */
    public void addShow(Show show) {
        shows.put(show.getId(), show);
    }

    /**
     * @param user
     * @param show
     *                      user wants to book for this show
     * @param selectedSeats
     *                      user selected seats
     *                      cheeck if seats are avaliable
     *                      if yes change the seat status to Booked
     *                      calculate price
     * @param Booking
     * @apiNote areseatsAvaliable() check sfor the each and every seat avaliabe in
     *          the seat w.r.t. show
     * @apiNote maekSeatAsBooked() changes the seats statuc from Avaliable to booked
     *          create booking objext base d on user , show, selected seats ,
     *          totalprice
     * 
     * synchronised because seat is a critical section
     * 
     * @return
     */
    public synchronized Booking bookTicket(User user, Show show, List<Seat> selectedSeats,PaymentMethod paymentMethod) {

        if (areSeatsAvaliable(selectedSeats, show)) {
            markSeatAsBooked(selectedSeats, show);
            double totalprice = calculateTotalPrice(selectedSeats, show);
            System.out.println("\n\t TOTAL PRICE IS :"+totalprice);

             // create booking object
             Booking booking = new Booking(user, show, selectedSeats, totalprice);
             System.out.println("\n\tBooking1 made id:"+booking.getId());

            // doing payments through payment service
            // Payment payment=paymentService.processPayment(totalprice, paymentMethod);
            // passimg the payment method to payment service is not redomemded it has to handle it self 
            // intead set the payment stratergy for the payment service then call them buy the method

            // setting the payment stratergy for the payment servide using payment factory
            // getting through the factory design pattern
            // the factory method should be static since only redirects towards the gateway
            PaymentStrategy paymentStrategy=PaymentStratergyFactory.getPaymentStrategy(paymentMethod);
            // set the payment stratergy the payment service have to choose
            paymentService.setPaymentStrategy(paymentStrategy);
            // call the process payment in the payment service
            Payment payment=paymentService.processPayment(totalprice);

           
            // link to booking 
            booking.setPayment(payment);
            // after payment is done we have to notify the user about booking in the paymentServie


            // add bookings to bookings map
            bookings.put(booking.getId(), booking);

            return booking;

        }
        return null;
    }

    /**
     * @param bookingId
     *                  booking is done on the based of booking Id added in book
     *                  ticket
     *                  change the statuc of the booking from pending to confirmed
     */
    public synchronized void confirmBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking.getBookingStatus() == BookingStatus.PENDING) {
            booking.setBookingStatus(BookingStatus.CONFIRMED);
            // call some Api for payment
        }
        System.out.println("\n\tBooking Sucessfull");
    }

    /**
     * @param bookingId
     *                  booking is done on the based of booking Id added in book
     *                  ticket
     *                  change the statuc of the booking from pending to confirmed
     *                  booking have theri selected seats and show
     * @apiNote make the changes in the seat statuc for 
     * the reserved seats
     * synchronised because seat is a critical section
     */
    public synchronized void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking.getBookingStatus() != BookingStatus.CANCLED) {
            booking.setBookingStatus(BookingStatus.CANCLED);
            // call some Api for payment
        }
        System.out.println("\n\tBooking Cancelled");
        List<Seat> selectedSeats = booking.getReservedSeats();
        Show show = booking.getShow();
        markSeatAsAvaliable(selectedSeats, show);

    }

    /**
     * @param selectedSeats
     *                      direct acess may give error like morning show and
     *                      evening show
     *                      show has screen , screen has seats
     * @param show
     *                      getting the selected seat
     * synchronised because seat is a critical section
     */
    private  synchronized void markSeatAsAvaliable(List<Seat> selectedSeats, Show show) {
        for (Seat seat : selectedSeats) {
            Map<String, Seat> seatMap = show.getScreen().getSeats();

            Seat showSeat = seatMap.get(seat.getSeatNumber());
            System.out.println(showSeat+" , "+seat+" ");
            showSeat.setSeatStatus(SeatStatus.AVALIABLE);
        }
    }

    /**
     * @param selectedSeats
     *                      iterate through each seat
     * 
     * @param show
     *                      direct acess error because of morning show / evening
     *                      ...???
     *                      show has screen , screen has seats
     *                      getting the selected seat
     *                      Accessing seats through shows
     * synchronised because seat is a critical section
     * @return
     */
    private synchronized boolean areSeatsAvaliable(List<Seat> selectedSeats, Show show) {
        for (Seat seat : selectedSeats) {
            Map<String, Seat> seatMap = show.getScreen().getSeats();

            Seat showSeat = seatMap.get(seat.getSeatNumber());

            if (showSeat.getSeatStatus() != SeatStatus.AVALIABLE) {
                System.out.println(showSeat+" , "+seat+" ");
                return false;
            }
        }
        return true;
    }

    /**
     * @param selectedSeats
     *                      direct acess may give error like morning show and
     *                      evening show
     *                      show has screen , screen has seats
     * @param show
     *                      getting the selected seat
     * synchronised because seat is a critical section
     */
    private synchronized void markSeatAsBooked(List<Seat> selectedSeats, Show show) {
        for (Seat seat : selectedSeats) {
            Map<String, Seat> seatMap = show.getScreen().getSeats();

            Seat showSeat = seatMap.get(seat.getSeatNumber());

            showSeat.setSeatStatus(SeatStatus.BOOKED);
        }
    }

    /**
     * @param selectedSeats
     * @param show
     *                      actually price is calculated based on the seat
     *                      in some cases for ex: specila shows , fanshows prices
     *                      may vary
     * @return
     */
    private double calculateTotalPrice(List<Seat> selectedSeats, Show show) {
        // the dynamic calculating of show peice based on the pricing stratergy admin chooses
        return selectedSeats.stream().mapToDouble(Seat::getSeatPrice).sum()+ (show.getShowPrice()*selectedSeats.size());
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Multiplex> getMultiplexs() {
        return multiplexs;
    }

    public Map<String, Show> getShows() {
        return shows;
    }

    public Map<String, Booking> getBookings() {
        return bookings;
    }
}
