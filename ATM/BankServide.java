package ATM;

/**
 * BankServide
 */
public interface BankServide {

    boolean isValiduser(String pin , CardInfo cardInfo);
    Customer getCustomerDetails();
    Transactiondetail executeTransaction(Transaction transaction);
}