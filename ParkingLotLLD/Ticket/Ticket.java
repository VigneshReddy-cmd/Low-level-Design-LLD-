package ParkingLotLLD.Ticket;

import java.sql.Date;

import ParkingLotLLD.ParkingLot.Floors.ParkingSpaceType;

public class Ticket {
    long Id;
    Date onEntryDateandTime;
    Date onExitDateandTime;
    long levelId;
    ParkingSpaceType parkingSpaceType;
    double totalCost;

    public void UpdateTotalCost(){}
    public void update_InandOutTime(Date entry,Date exit){}
    
}
