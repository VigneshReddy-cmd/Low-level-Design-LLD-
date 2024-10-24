package Payment;

import model.Payment;
import model.PaymentMethod;
import model.PaymentStatus;

public class PayPalPaymentStratergy  implements PaymentStrategy{

    @Override
    public Payment processPayment(double amount) {
       Payment payment=new Payment(amount, PaymentMethod.PAYPAL);

       if(mockPaymentProcess(amount, PaymentMethod.PAYPAL))
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
