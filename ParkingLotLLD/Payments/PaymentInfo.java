package ParkingLotLLD.Payments;

import java.sql.Date;

public class PaymentInfo {
    String TransactionId;
    PaymentType paymentType;
    double Cost;
    Date paymentDate;
    PaymentStatus paymentStatus;
}
