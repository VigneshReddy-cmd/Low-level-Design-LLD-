package model;

import java.time.LocalDateTime;

import Pricing.PricingStatergy;

public class Show {

    private final String Id;

    private Movie movie;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Screen screen;

    private PricingStatergy 
    pricingStatergy;

    public PricingStatergy getPricingStatergy() {
        return pricingStatergy;
    }

    public void setPricingStatergy(PricingStatergy pricingStatergy) {
        this.pricingStatergy = pricingStatergy;
    }

    private static final double BASE_PRICE=100.0;

    public double getShowPrice()
    {
        return pricingStatergy.CalculatePrice(BASE_PRICE); 
    }

    public Show(Movie movie, LocalDateTime startTime, LocalDateTime endTime, Screen screen) {
        this.Id = idGenerator.generateUid();
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        this.screen = screen;
    }

    public String getId() {
        return Id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

}
