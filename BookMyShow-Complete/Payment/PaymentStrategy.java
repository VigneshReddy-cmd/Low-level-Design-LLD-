package Payment;

import model.Payment;

public interface PaymentStrategy {
    Payment processPayment(double amount);
}
