package VendingMachineLLD;

import java.util.List;

public class Selection implements State {

    public Selection(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void clickOnInsertButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("please insert money");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("please insert money");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Inventory inventory = vendingMachine.getInventory();
        Item item = inventory.getItemByCodeNumber(codeNumber);
        if (!item.isAvaliable) {
            vendingMachine.setVendingMachinestate(new IdleState());
            throw new Exception("Item not available");
        }
        int price = item.price;
        int userMoney = vendingMachine.getMoney();
        if (userMoney < price) {
            refundALL(vendingMachine);
            vendingMachine.setVendingMachinestate(new IdleState());
            throw new Exception("Not enough money");
        } else if (userMoney >= price) {
            if (userMoney > price) {
                dispenseChange(vendingMachine, userMoney - price);
            }
            vendingMachine.setVendingMachinestate(new DispensertState(vendingMachine, codeNumber));
        }
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, CoinType coin) throws Exception {
        throw new Exception("please insert money");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("please insert money");
    }

    @Override
    public void dispenseChange(VendingMachine vendingMachine, int change) throws Exception {
        throw new Exception("please insert money");
    }

    @Override
    public void updateInvntory(VendingMachine vendingMachine, int codeNumber) throws Exception {

    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("please insert money");
    }

    @Override
    public List<CoinType> refundALL(VendingMachine vendingMachine) throws Exception {
        vendingMachine.makeCoinListFree();
        return vendingMachine.coinList;
    }
}
