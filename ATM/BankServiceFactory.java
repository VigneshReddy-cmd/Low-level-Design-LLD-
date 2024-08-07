package ATM;

public class BankServiceFactory {
    BankServide getBankServide(CardInfo cardInfo)
    {
        return new BankServide() {

            @Override
            public boolean isValiduser(String pin, CardInfo cardInfo) { 
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'isValiduser'");
            }

            @Override
            public Customer getCustomerDetails() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getCustomerDetails'");
            }

            @Override
            public Transactiondetail executeTransaction(Transaction transaction) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'executeTransaction'");
            }
        };
    }
}
