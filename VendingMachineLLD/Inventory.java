package VendingMachineLLD;

public class Inventory {
    private ItemShelf[][] itemShelfs = new ItemShelf[3][3];

    public ItemShelf[][] getItemShelfs() {
        return itemShelfs;
    }

    public void setItemShelfs() {
        fillVendingMachine();
    }

    public void fillVendingMachine() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) {
                    itemShelfs[i][j] = new ItemShelf(new Item(10, "Coke", true, ItemType.COKE), 100);
                }
                if (i == 0 && j == 1) {
                    itemShelfs[i][j] = new ItemShelf(new Item(20, "Pepsi", true, ItemType.PEPSI), 200);
                }
                if (i == 0 && j == 2) {
                    itemShelfs[i][j] = new ItemShelf(new Item(30, "Sprite", true, ItemType.SPRITE), 300);
                }
                if (i == 1 && j == 0) {
                    itemShelfs[i][j] = new ItemShelf(new Item(40, "Fanta", true, ItemType.FANTA), 400);
                }
                if (i == 1 && j == 1) {
                    itemShelfs[i][j] = new ItemShelf(new Item(50, "Cola", true, ItemType.COLA), 500);
                }
                if (i == 1 && j == 2) {
                    itemShelfs[i][j] = new ItemShelf(new Item(60, "Coke", true, ItemType.COKE), 600);
                }
                if (i == 2 && j == 0) {
                    itemShelfs[i][j] = new ItemShelf(new Item(70, "Pepsi", true, ItemType.PEPSI), 700);
                }
                if (i == 2 && j == 1) {
                    itemShelfs[i][j] = new ItemShelf(new Item(80, "Sprite", true, ItemType.SPRITE), 800);
                }
                if (i == 2 && j == 2) {
                    itemShelfs[i][j] = new ItemShelf(new Item(90, "Fanta", true, ItemType.FANTA), 900);
                }
            }
        }
    }

    public void displayItemShelfs() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Item item = itemShelfs[i][j].item;
                System.out.println(item.name + " " + item.price + " " + item.isAvaliable + " " + itemShelfs[i][j].codeNumber);
            }
        }
    }

    public void setItemAValiability(int codeNumber) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (itemShelfs[i][j].codeNumber == codeNumber) {
                    itemShelfs[i][j].item.isAvaliable = false;
                }
            }
        }
    }

    public Item getItemByCodeNumber(int codeNumber) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (itemShelfs[i][j].codeNumber == codeNumber) {
                    return itemShelfs[i][j].item;
                }
            }
        }
        return null;
    }
}
