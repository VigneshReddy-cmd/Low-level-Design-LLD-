package VendingMachineLLD;

public class Item {
    public int price;
    public String name;
    public boolean isAvaliable;
    public ItemType itemType;

    public Item(int price, String name, boolean isAvaliable, ItemType itemType) {
        this.price = price;
        this.name = name;
        this.isAvaliable = isAvaliable;
        this.itemType = itemType;
    }
}
