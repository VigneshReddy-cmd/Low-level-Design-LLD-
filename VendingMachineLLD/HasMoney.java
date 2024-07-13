package VendingMachineLLD;

import java.util.List;

public class HasMoney implements State{

    @Override
    public void clickOnInsertButton(VendingMachine vendingMachine) throws Exception {
       throw new Exception("Please insert money");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachinestate(new Selection(vendingMachine));
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine,int codeNumber) throws Exception {
       throw new Exception("please insert money");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine,CoinType coin) throws Exception {
        System.out.print("COINS ACCEPTED");
        vendingMachine.coinList.add(coin);
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine,int codeNumber) throws Exception {
        throw new Exception("please insert money");
    }

    @Override
    public void dispenseChange(VendingMachine vendingMachine,int change) throws Exception {
       throw new Exception("please insert money");
    }

    @Override
    public void updateInvntory(VendingMachine vendingMachine,int codeNumber) throws Exception {
       throw new Exception("please insert money");
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) throws Exception {
      
    }

    @Override
    public List<CoinType> refundALL(VendingMachine vendingMachine) throws Exception 
    {
         System.out.println("Refund full Amount");
         vendingMachine.setVendingMachinestate(new IdleState());
         vendingMachine.makeCoinListFree();
         return vendingMachine.coinList;
    }

}
