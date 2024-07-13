package VendingMachineLLD;

import java.util.List;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Machine is in idle state.");
    }

    @Override
    public void clickOnInsertButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachinestate(new HasMoney());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Please insert coins first.");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Please insert coins first.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, CoinType coin) throws Exception {
        throw new Exception("Please click on insert coin button first.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Please insert coins first.");
    }

    @Override
    public void dispenseChange(VendingMachine vendingMachine, int change) throws Exception {
        throw new Exception("Please insert coins first.");
    }

    @Override
    public void updateInvntory(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Please insert coins first.");
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("No transaction to cancel.");
    }

    @Override
    public List<CoinType> refundALL(VendingMachine vendingMachine) throws Exception {
        throw new Exception("No transaction to refund.");
    }
}
