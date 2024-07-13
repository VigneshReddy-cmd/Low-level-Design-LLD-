package VendingMachineLLD;

import java.util.List;

public class DispensertState implements State {
    public DispensertState(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Dispenser state");
        dispenseProduct(vendingMachine, codeNumber);
        updateInvntory(vendingMachine, codeNumber);
    }

    @Override
    public void clickOnInsertButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("wait.. transaction is processing ");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("wait.. transaction is processing ");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("wait.. transaction is processing ");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, CoinType coin) throws Exception {
        throw new Exception("wait.. transaction is processing ");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Product is being dispensed");
    }

    @Override
    public void dispenseChange(VendingMachine vendingMachine, int change) throws Exception {
        System.out.println("Please collect your change: " + change);
        vendingMachine.makeCoinListFree();
    }

    @Override
    public void updateInvntory(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Updating inventory");
        vendingMachine.setItemAValiability(codeNumber);
        vendingMachine.setVendingMachinestate(new IdleState());
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("wait.. transaction is processing ");
    }

    @Override
    public List<CoinType> refundALL(VendingMachine vendingMachine) throws Exception {
        throw new Exception("wait.. transaction is processing ");
    }
}
