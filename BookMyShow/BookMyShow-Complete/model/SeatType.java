package model;

public enum SeatType {
    LOUNGERS(300),

    GOLD(250),

    SOFA(375),

    RECLINERS(420);

    private final double price;

    SeatType(double price){
        this.price=price;
    }

    public double getPrice(){
        return price;
    }
}
