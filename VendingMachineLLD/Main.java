// Main.java
package VendingMachineLLD;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        try {
            System.out.println("\t\tWelcome to Vending Machine\n");

            vendingMachine.getInventory().fillVendingMachine();
            vendingMachine.getInventory().displayItemShelfs();

            System.out.println("|");
            System.out.println("Click on InsertCoinButton");
            System.out.println("|");

            State state = vendingMachine.getVendingMachinestate();
            state.clickOnInsertButton(vendingMachine);

            state = vendingMachine.getVendingMachinestate();
            state.insertCoin(vendingMachine, CoinType.TEN);
            state.insertCoin(vendingMachine, CoinType.TWENTY);

            System.out.println("|");
            System.out.println("Click on ProductSelectionButton");
            System.out.println("|");

            state = vendingMachine.getVendingMachinestate();
            state.clickOnStartProductSelectionButton(vendingMachine);
            state.chooseProduct(vendingMachine, 100);

            state = vendingMachine.getVendingMachinestate();
            vendingMachine.getInventory().displayItemShelfs();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            vendingMachine.getInventory().displayItemShelfs();
        }
    }
}
