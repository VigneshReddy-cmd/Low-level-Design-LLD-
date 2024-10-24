import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BuilderFilter.FilterBuilder;
import DECFilters.GerneFilter;
import DECFilters.LocationFilter;
import DECFilters.ShowFilter;
import Filters.Filter;
import Filters.FilterManager;
import Filters.MovieFilter;
import Filters.MultiplexFilter;
import Payment.EmailNotificationObserver;
import Payment.PaymentObserver;
import Payment.SMSNotificationObserver;
import Pricing.DiscountPricingStartegy;
import Pricing.OffPeakPricingStartegy;
import Pricing.PeakPricingStartegy;
import Pricing.PricingStatergy;
import model.Booking;
import model.Movie;
import model.Multiplex;
import model.PaymentMethod;
import model.PaymentStatus;
import model.Screen;
import model.Seat;
import model.Show;
import model.User;
import service.BookingService;
import sorter.CheapestShowSorter;
import sorter.SorterManager;
import sorter.SortingStartegy;

public class BookingServiceDemo {

    public static void main(String[] args) {
        // booking service should be a singleton
        BookingService bookingService = BookingService.getInstance();
        // creating a movie
        Movie movie1 = new Movie("DEVARA", "TELUGU", "ACTION-DRAMA", "2024-10-1", 180);
        Movie movie2 = new Movie("INCEPTION", "ENGLISH", "SI-FI", "2024-10-10", 180);
        Movie movie3 = new Movie("SALAR", "TELUGU", "ACTION-DRAMA", "2024-10-18", 180);
        Movie movie4 = new Movie("MR.PERFECT", "TELUGU", "DRAMA", "2024-10-23", 140);
        Movie movie5 = new Movie("KHALEJA", "TELUGU", "DRAMA", "2025-09-08", 150);

        // multillex has name and location ans screens
        Multiplex sairam= new Multiplex("SREE SAI RAM", "MALKAJGIRI");
        Multiplex talluri= new Multiplex("Talluri", "ECIL");
        Multiplex radhika= new Multiplex("Radhika", "ECIL");


        // screens has muktiplex totalno.of seats name
        Screen screen1sairam = new Screen(sairam, 300, "SCREEN-1");
        sairam.addScreens(screen1sairam);


        Screen screen1talluri = new Screen(talluri, 250, "SCREEN-1");
        talluri.addScreens(screen1talluri);
        Screen screen2talluri = new Screen(talluri, 150, "SCREEN-2");
        talluri.addScreens(screen2talluri);
        Screen screen3talluri = new Screen(talluri, 100, "SCREEN-3");
        talluri.addScreens(screen3talluri);


        Screen screen1radhika = new Screen(radhika, 200, "SCREEN-1");
        radhika.addScreens(screen1radhika);
        Screen screen2radhika = new Screen(radhika, 200, "SCREEN-2");
        radhika.addScreens(screen2radhika);
        Screen screen3radhika = new Screen(radhika, 200, "SCREEN-3");
        radhika.addScreens(screen3radhika);
        Screen screen4radhika = new Screen(radhika, 200, "SCREEN-4");
        radhika.addScreens(screen4radhika);
        Screen screen5radhika = new Screen(radhika, 200, "SCREEN-5");
        radhika.addScreens(screen5radhika);

        

        // show has start time , end time , movie , screen
        //sairam shows
        addShows(movie1,screen1sairam,bookingService);
        addShows(movie1,screen1talluri,bookingService);
        addShows(movie5,screen2talluri,bookingService);
        addShows(movie3,screen3talluri,bookingService);
        addShows(movie1,screen1radhika,bookingService);
        addShows(movie2,screen2radhika,bookingService);
        addShows(movie3,screen3radhika,bookingService);
        addShows(movie4,screen4radhika,bookingService);

        

        // create a user
        User nani = new User("nani", "nani11@gmail.com","9182593977");
        // creating the medium through which the user linked to the app
        PaymentObserver emailObserver=new EmailNotificationObserver(nani.getEmail());
        PaymentObserver smsObserver=new SMSNotificationObserver(nani.getMobileNum());
        bookingService.addObserver(emailObserver);
        bookingService.addObserver(smsObserver);
        // user shoukld only apass the seats he wants to book not seatt type
        // creating a new eat is not for the user
        

        


        // strategy design pattern
        // Filter movieFilter=new MovieFilter("SALAR".toUpperCase());
        // Filter multiplexFilter=new MultiplexFilter("SREE SAI RAM".toUpperCase());
        // FilterManager filterManager=new FilterManager();
        // filterManager.setFilter(multiplexFilter);
        // filterManager.setFilter(movieFilter);
        // List<Show> filteredShows=filterManager.applyFilter(new ArrayList<>(bookingService.getShows().values()));
        // for(Show  filteredShow: filteredShows)
        // {
        //     System.out.println("\n{"+filteredShow.getScreen().getMultiplex().getName()+" , "+filteredShow.getScreen().getMultiplex().getLocation()+" , "+filteredShow.getMovie().getTitle()+"}");
        // }



        // decorative pattern
        // ShowFilter gernFilter=new GerneFilter("DRAMA");
        // ShowFilter locationFilter=new LocationFilter("ECIL",gernFilter );
        // List<Show> filteredShows=locationFilter.apply(new ArrayList<>(bookingService.getShows().values()));
        // for(Show  filteredShow: filteredShows)
        // {
        //     System.out.println("\n{"+filteredShow.getScreen().getMultiplex().getName()+" , "+filteredShow.getScreen().getMultiplex().getLocation()+" , "+filteredShow.getMovie().getTitle()+"}");
        // }



       
       
        // System.out.println("\n\t\t\t\tTOTAL SHOWS\n");
        // List<Show> allShows=new ArrayList<>(bookingService.getShows().values());
        // for(Show  filteredShow: allShows)
        // {
        //     System.out.println("{"+filteredShow.getScreen().getMultiplex().getName()+" , "+filteredShow.getScreen().getMultiplex().getLocation()+" , "+filteredShow.getMovie().getTitle()+" , "+filteredShow.getShowPrice()+"}\n");
        // }
        // //BUILD PATTERN
        // System.out.println("\n\t\t\t\t Filtered shows\n");
        // FilterBuilder filterBuilder=new FilterBuilder();
        // ShowFilter filter=filterBuilder
        //                      .genre("DRAMA")
        //                      .location("ECIL")
        //                      .build();
        // List<Show> filteredShows=filter.apply(allShows);
        // for(Show  filteredShow: filteredShows)
        // {
        //     System.out.println("{"+filteredShow.getScreen().getMultiplex().getName()+" , "+filteredShow.getScreen().getMultiplex().getLocation()+" , "+filteredShow.getMovie().getTitle()+" , "+filteredShow.getShowPrice()+"}\n");
        // }

        // //startegey sorting pattern
        // SortingStartegy sortingStartegy=new CheapestShowSorter();
        // SorterManager sorterManager=new SorterManager(sortingStartegy);
        // System.out.println("\n\t\t\t\tSorted Filtered List\n");
        // List<Show> sortedFilteredList=sorterManager.getSortShows(filteredShows);
        // // sortedFilteredList.forEach(System.out::println);
        //  for(Show  filteredShow: sortedFilteredList)
        // {
        //     System.out.println("{"+filteredShow.getScreen().getMultiplex().getName()+" , "+filteredShow.getScreen().getMultiplex().getLocation()+" , "+filteredShow.getMovie().getTitle()+ " , "+filteredShow.getShowPrice()+"}\n");
        // }



        // get seats from the show
        Show show1=sairam.getScreens().get(0).getShows().get(0);
        show1.setPricingStatergy(new PeakPricingStartegy());
        Seat seat1 = show1.getScreen().getSeats().get(String.valueOf(1));
        Seat seat2 = show1.getScreen().getSeats().get(String.valueOf(2));

        // choose payment method
        System.out.println("You have choosen SAIRAM  movie name DEVARA");
        System.out.println("\n"+"choose Payment method from following");
        System.out.println("\n\t\t\t\tPAYMENT METHODS");
        System.out.println("\t1."+PaymentMethod.CREDIT_CARD);
        System.out.println("\t2."+PaymentMethod.DEBIT_CARD);
        System.out.println("\t3."+PaymentMethod.PAYPAL);
        System.out.println("\t4."+PaymentMethod.UPI);
        System.out.println("\t5."+PaymentMethod.NET_BANKING);
        PaymentMethod paymentMethod=choosemethod();
        
        Booking booking = bookingService.bookTicket(nani, show1, List.of(seat1, seat2),paymentMethod);
        
        
        if(booking!=null)
        {
            String bookingId=booking.getId();
            if(booking.getPayment().getPaymentstatus()==PaymentStatus.SUCESSES)
            {
                bookingService.confirmBooking(bookingId);
            }
            else
            {
                bookingService.cancelBooking(bookingId);
            }
        }

    }

    private static PaymentMethod choosemethod() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose one of them");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                return PaymentMethod.CREDIT_CARD;
            case 2:
                return PaymentMethod.DEBIT_CARD;
            case 3:
                return PaymentMethod.PAYPAL;
            case 4:
                return PaymentMethod.UPI;
            case 5:
                return PaymentMethod.NET_BANKING;
            default:
                throw new IllegalStateException("Invalid Payment Method");
        }
    }

    private static void addShows(Movie movie, Screen screen, BookingService bookingService) {
        
        Show show1 = new Show(movie, 
            LocalDateTime.of(2024, 10, 23, 11, 0),
            LocalDateTime.of(2024, 10, 23, 14, 0), screen);
            setPricingStategy(show1,movie);

            Show show2 = new Show(movie, 
            LocalDateTime.of(2024, 10, 23, 14, 30),
            LocalDateTime.of(2024, 10, 23, 17, 0), screen);
            setPricingStategy(show2,movie);
            
            Show show3 = new Show(movie, 
            LocalDateTime.of(2024, 10, 23, 18, 0),
            LocalDateTime.of(2024, 10, 23, 21, 30), screen);
            setPricingStategy(show3,movie);
            
            Show show4 = new Show(movie, 
            LocalDateTime.of(2024, 10, 23, 22, 0),
            LocalDateTime.of(2024, 10, 24, 1, 0), screen);
            setPricingStategy(show4,movie);
    
        // Add the shows to the screen
        screen.addShows(show1);
        screen.addShows(show2);
        screen.addShows(show3);
        screen.addShows(show4);

        
    
        // Add the shows to the booking service
        bookingService.addShow(show1);
        bookingService.addShow(show2);
        bookingService.addShow(show3);
        bookingService.addShow(show4);
    }

    private static void setPricingStategy(Show show, Movie movie) {
        if(movie.getTitle().equals("SALAR")) show.setPricingStatergy(new OffPeakPricingStartegy());
        if(movie.getTitle().equals("INCEPTION")) show.setPricingStatergy(new OffPeakPricingStartegy());
        if(movie.getTitle().equals("KHALEJA")) show.setPricingStatergy(new OffPeakPricingStartegy());
        if(movie.getTitle().equals("MR.PERFECT")) show.setPricingStatergy(new DiscountPricingStartegy());
        if(movie.getTitle().equals("DEVERA")) show.setPricingStatergy(new PeakPricingStartegy());
    }
    
    
}
/*
   // Seat seat3=new Seat(show1.getScreen().getSeats().get(String.valueOf(1)).getSeatNumber(),
        // SeatType.GOLD);
        // Seat seat4=new Seat(show1.getScreen().getSeats().get(String.valueOf(2)).getSeatNumber(),
        // SeatType.GOLD);
        // why seat3 and seat4 are diferent in terms of objects but their seat number is different
        // even they are avaliable we cannot book
        // the status is completely depends on the show
        // Booking booking2 = bookingService.bookTicket(nani, show1, List.of(seat3, seat4));
        // if(booking2!=null)
        // {
        //     String bookingId=booking2.getId();
        //     System.out.println("Booking made id:"+bookingId);
        //     if(isPaymentSucessfull)
        //     {
        //         System.out.println("Payment Sucess");
        //         bookingService.confirmBooking(bookingId);
        //         System.out.println("Booking confirmed");
        //     }
        //     else
        //     {
        //         System.out.println("Payment Failure");
        //         bookingService.cancelBooking(bookingId);
        //         System.out.println("Booking cancled");
        //     }
        // }
 */
