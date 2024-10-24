package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {

    private final String Id;

    private String name;

    private List<Show> shows;

    // each screen will be associated to single multiplex
    private Multiplex multiplex;

    private Map<String, Seat> seats;

    private int totalSeats;

    public Screen(Multiplex multiplex, int totalSeats, String name) {
        this.name = name;
        Id = idGenerator.generateUid();
        this.shows = new ArrayList<>();
        this.multiplex = multiplex;
        this.seats = initSeats();
        this.totalSeats = totalSeats;
    }

    private Map<String, Seat> initSeats() {
        Map<String, Seat> map = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            map.put(String.valueOf(i), new Seat(String.valueOf(i), SeatType.LOUNGERS));
        }
        for (int i = 11; i <= 20; i++) {
            map.put(String.valueOf(i), new Seat(String.valueOf(i), SeatType.GOLD));
        }
        for (int i = 21; i <= 30; i++) {
            map.put(String.valueOf(i), new Seat(String.valueOf(i), SeatType.SOFA));
        }
        for (int i = 31; i <= 40; i++) {
            map.put(String.valueOf(i), new Seat(String.valueOf(i), SeatType.RECLINERS));
        }
        return map;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void addShows(Show show) {
        shows.add(show);
    }

    public Multiplex getMultiplex() {
        return multiplex;
    }

    public void setMultiplex(Multiplex multiplex) {
        this.multiplex = multiplex;
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

}
