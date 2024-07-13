package VendingMachineLLD;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State vendingMachinestate;
    private Inventory inventory;
    public List<CoinType> coinList;

    public VendingMachine() {
        this.vendingMachinestate = new IdleState();
        this.inventory = new Inventory();
        coinList = new ArrayList<CoinType>();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public VendingMachine(State vendingMachinestate) {
        this.vendingMachinestate = vendingMachinestate;
    }

    public State getVendingMachinestate() {
        return vendingMachinestate;
    }

    public void setVendingMachinestate(State vendingMachinestate) {
        this.vendingMachinestate = vendingMachinestate;
    }

    public void makeCoinListFree() {
        coinList.clear();
    }

    public List<CoinType> getCoinList() {
        return coinList;
    }

    public int getMoney() {
        int total = 0;
        for (CoinType coin : coinList) {
            total += coin.getValue();
        }
        return total;
    }

    public void setCoinList(List<CoinType> coinList) {
        this.coinList = coinList;
    }

    public void setItemAValiability(int codeNumber) {
        inventory.setItemAValiability(codeNumber);
    }
}
