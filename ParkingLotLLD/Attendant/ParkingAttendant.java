package ParkingLotLLD.Attendant;

import ParkingLotLLD.Account.Account;
import ParkingLotLLD.Payments.Payment;
import ParkingLotLLD.Payments.PaymentType;
import ParkingLotLLD.Ticket.Ticket;
import ParkingLotLLD.Vechile.Vechile;

public class ParkingAttendant extends Account {
    Payment paymentServices;
    public void ProcessVEchileEntry(Vechile vechile){}
    public Void processPayment(Ticket ticket,PaymentType paymentType){
        return null;}
}
