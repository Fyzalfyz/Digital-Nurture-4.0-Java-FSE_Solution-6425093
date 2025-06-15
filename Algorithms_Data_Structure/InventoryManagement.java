
/**
 *
 * @author Fyzal
 */
import java.util.*;

public class InventoryManagement {

    static class GroceryItem {
        String itemId;
        String itemName;
        int quantity;
        double price;

        GroceryItem(String itemId, String itemName, int quantity, double price) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
        }

        public String toString() {
            return itemId + " | " + itemName + " | " + quantity + " | " + price;
        }
    }

    static class Inventory {
        Map<String, GroceryItem> items = new HashMap<>();

        void addItem(GroceryItem item) {
            items.put(item.itemId, item);
        }

        void updateItem(String itemId, int quantity, double price) {
            if (items.containsKey(itemId)) {
                GroceryItem item = items.get(itemId);
                item.quantity = quantity;
                item.price = price;
            }
        }

        void deleteItem(String itemId) {
            items.remove(itemId);
        }

        void printInventory() {
            for (GroceryItem item : items.values()) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        Inventory shop = new Inventory();

        GroceryItem i1 = new GroceryItem("G001", "Sugar", 50, 45.0);
        GroceryItem i2 = new GroceryItem("G002", "Milk", 30, 25.5);
        GroceryItem i3 = new GroceryItem("G003", "Rice", 100, 60.0);

        shop.addItem(i1);
        shop.addItem(i2);
        shop.addItem(i3);

        shop.printInventory();

        shop.updateItem("G002", 40, 27.0);
        shop.deleteItem("G001");

        System.out.println("After update and delete:");
        shop.printInventory();
    }
}
