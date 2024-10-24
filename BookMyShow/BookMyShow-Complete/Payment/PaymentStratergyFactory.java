package Payment;

import model.PaymentMethod;

public class PaymentStratergyFactory {
   public static PaymentStrategy getPaymentStrategy(PaymentMethod paymentMethod)
   {
      switch (paymentMethod) {
        case PAYPAL:
            System.out.println("\n\tPAYMENT STRATERGY SET TO "+PaymentMethod.PAYPAL);
            return new PayPalPaymentStratergy();
            case CREDIT_CARD:
            System.out.println("\n\tPAYMENT STRATERGY SET TO "+PaymentMethod.CREDIT_CARD);
            return new CreditCardPaymentStrategy();
            case UPI:
            System.out.println("\n\tPAYMENT STRATERGY SET TO "+PaymentMethod.UPI);
            return new UPIPaymentStratergy();
            case NET_BANKING:
            System.out.println("\n\tPAYMENT STRATERGY SET TO "+PaymentMethod.NET_BANKING);
            return new Net_BankingPaymentStratergy();
            case DEBIT_CARD:
            System.out.println("\n\tPAYMENT STRATERGY SET TO"+PaymentMethod.NET_BANKING);
             return new DebitCardPaymentStratergy();
        default:
            throw new IllegalStateException("INVALID PAYMENT METHOD SELECTED"); 
      }
   }
}
