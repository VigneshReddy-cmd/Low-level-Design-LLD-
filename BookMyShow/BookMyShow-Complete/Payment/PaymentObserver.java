package Payment;

import model.Payment;

public interface PaymentObserver {
    void UpdateUser(Payment payment);
}
