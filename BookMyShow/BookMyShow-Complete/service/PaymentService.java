package service;

import Payment.PaymentStrategy;
import Payment.PaymentObserver;
import model.Payment;
import java.util.List;
import java.util.ArrayList;

public class PaymentService {

    private volatile static  PaymentService service=null;

    private PaymentStrategy paymentStrategy;

    List<PaymentObserver> observers;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    private PaymentService()
    {
       observers=new ArrayList<>();
    }

    // using observer design pattern choosing the all observers the use chooses
    public void addObserver(PaymentObserver observer)
    {
        observers.add(observer);
    }

    public static PaymentService getInstance()
    {
        if(service==null)  // optimisation
        {
            synchronized(PaymentService.class)
            {
                if(service==null) // double checking
                {
                    PaymentService.service=new PaymentService();
                }
            }
        }
        return service;
    }

    // public Payment processPayment(double Amount,PaymentMethod paymentMethod)
    // {
    //     Payment payment=new Payment(Amount, paymentMethod);
    //     boolean isSucess=mockPaymentProcess(Amount, paymentMethod);

    //     if(isSucess)
    //     {
    //         payment.setPaymentstatus(PaymentStatus.SUCESSES);
    //     }

    //     return payment;
    // }
    // the above method calling chooses same procedure for the payment processing
    // it folows same for every method
    // we need to choose different method based on the conditions
    // use paymentfactory for the need 
    public Payment processPayment(double Amount)
    {
        //the payment stratergy is set in the booking service through factory
        // abstraction
        Payment payment=paymentStrategy.processPayment(Amount);
        // we have to nitify() the users about booking
        nitifyUsers(payment);
        return payment;
    }

    private void nitifyUsers(Payment payment) {
        // notification logic
        for(PaymentObserver paymentObserver:observers)
        {
            paymentObserver.UpdateUser(payment);
        }   
    }

}
