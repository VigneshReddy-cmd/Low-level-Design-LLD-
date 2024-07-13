package VendingMachineLLD;

import java.util.List;

public interface State {
    public void clickOnInsertButton(VendingMachine vendingMachine) throws Exception;
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception;
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    public void insertCoin(VendingMachine vendingMachine, CoinType coin) throws Exception;
    public void dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    public void dispenseChange(VendingMachine vendingMachine, int change) throws Exception;
    public void updateInvntory(VendingMachine vendingMachine, int codeNumber) throws Exception;
    public void cancelTransaction(VendingMachine vendingMachine) throws Exception;
    public List<CoinType> refundALL(VendingMachine vendingMachine) throws Exception;
}
