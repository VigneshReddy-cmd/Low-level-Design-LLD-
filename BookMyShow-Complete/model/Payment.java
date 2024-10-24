package model;

import java.time.LocalDateTime;
public class Payment {
    private final String  Id;

    private double amount;

    PaymentStatus paymentstatus;

    PaymentMethod paymentMethod;

    private LocalDateTime timestamp;
    

    public Payment(double amount,PaymentMethod paymentMethod) {
        Id=idGenerator.generateUid();
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        paymentstatus=PaymentStatus.PENDING;
        this.paymentMethod=paymentMethod;
    }

    public String getId() {
        return Id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(PaymentStatus paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


}
