package Payment;

import model.Payment;
import model.PaymentMethod;
import model.PaymentStatus;

public class UPIPaymentStratergy implements PaymentStrategy{

    @Override
    public Payment processPayment(double amount) {
         Payment payment=new Payment(amount, PaymentMethod.UPI);

       if(mockPaymentProcess(amount, PaymentMethod.UPI))
       payment.setPaymentstatus(PaymentStatus.SUCESSES);
       
       return payment;
    }

    // for calling 3rd party API banks
    private boolean mockPaymentProcess(double Amount,PaymentMethod paymentMethod)
    {
        // simulate the sucess over 90%
        // phonepay / credit API
        return Math.random()>0.1?true:false;
    }
    

}
