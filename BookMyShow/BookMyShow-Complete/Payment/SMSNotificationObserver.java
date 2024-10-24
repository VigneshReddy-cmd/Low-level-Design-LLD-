package Payment;

import model.Payment;
import model.PaymentStatus;

public class SMSNotificationObserver implements PaymentObserver{

    private final String phoneNumber;
    

    public SMSNotificationObserver(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public void UpdateUser(Payment payment) {
          if(payment.getPaymentstatus().equals(PaymentStatus.SUCESSES))
        {
            System.out.println("\nSMS sent to  : +91"+ phoneNumber+"\tOn PaymentId : "+payment.getId());
        }
    }

}
