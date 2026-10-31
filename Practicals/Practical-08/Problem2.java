import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Custom checked exception for out-of-stock items
class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

// Custom checked exception for invalid quantities
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    private Map<String, Integer> stock = new HashMap<>();

    public Warehouse() {
        // Initialize stock inventory
        stock.put("Laptop", 5);
        stock.put("Monitor", 3);
        stock.put("Mouse", 10);
        stock.put("Keyboard", 7);
    }

    public void issue(String item, int qty) throws OutOfStockException, InvalidQuantityException {
        if (!stock.containsKey(item)) {
            throw new OutOfStockException("Item " + item + " does not exist.");
        }

        if (qty <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than zero.");
        }

        int available = stock.get(item);
        if (qty > available) {
            throw new OutOfStockException("Not enough stock for " + item + ". Available = " + available);
        }

        stock.put(item, available - qty);
        System.out.println("Issued " + qty + " " + item + "(s) successfully.");
        System.out.println("Remaining stock = " + stock.get(item));
    }

    public void displayStock() {
        System.out.println("\nCurrent Warehouse Stock:");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class Problem2 { // Rename to WarehouseStock if your file is WarehouseStock.java
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Warehouse warehouse = new Warehouse();

        System.out.println("=== Warehouse Stock System ===");
        warehouse.displayStock();

        System.out.print("\nEnter number of requests: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nRequest " + i);
            System.out.print("Enter item: ");
            String item = sc.next();
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            try {
                warehouse.issue(item, qty);
            } catch (OutOfStockException | InvalidQuantityException e) {
                System.out.println("Request failed: " + e.getMessage());
            }

            System.out.println("Processing continues...");
        }

        warehouse.displayStock();
        sc.close();
    }
}
