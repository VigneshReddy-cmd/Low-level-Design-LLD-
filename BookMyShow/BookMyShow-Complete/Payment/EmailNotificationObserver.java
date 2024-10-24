package Payment;

import model.Payment;
import model.PaymentStatus;

public class EmailNotificationObserver implements PaymentObserver {

    private final String email;
     

    public EmailNotificationObserver(String email) {
        this.email = email;
    }


    @Override
    public void UpdateUser(Payment payment) {
        if(payment.getPaymentstatus().equals(PaymentStatus.SUCESSES))
        {
            System.out.println("\nEMAIL sent to : "+email+" \tOn PaymentId : "+payment.getId());
        }
    }

}
