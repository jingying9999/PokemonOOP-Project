public class RedeemItem {
    private String itemName;
    private String itemDesc;
    private int goldChipCost;

    public RedeemItem(String itemName, String itemDesc, int goldChipCost) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.goldChipCost = goldChipCost;
    }
    
    // Setter method for itemName
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Setter method for itemDesc
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    // Setter method for goldChipCost
    public void setGoldChipCost(int goldChipCost) {
        this.goldChipCost = goldChipCost;
    }
    
    // Getter method for itemName
    public String getItemName() {
        return itemName;
    }

    // Getter method for itemDesc
    public String getItemDesc() {
        return itemDesc;
    }

    // Getter method for goldChipCost
    public int getGoldChipCost() {
        return goldChipCost;
    }
    
    public String toString() {
        return String.format(
                "Item Name: %s\nItem Desc: %s\nCost: %d Gold Chips",
                itemName, itemDesc, goldChipCost
        );
    }
}
