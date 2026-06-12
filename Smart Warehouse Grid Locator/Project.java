class GridItem {
    private String itemId;
    private String itemName;
    private int quantity;

    public GridItem(String itemId, String itemName, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void display() {
        System.out.println(itemId + " - " + itemName + " (Qty: " + quantity + ")");
    }
}

class Warehouse {
    private GridItem[][] grid;

    public Warehouse(int rows, int columns) {
        grid = new GridItem[rows][columns];
    }

    public void addItem(int row, int col, GridItem item) {
        grid[row][col] = item;
    }

    public void searchItem(String id) {
        System.out.println("\nSearching for item ID: " + id);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] != null &&
                    grid[i][j].getItemId().equals(id)) {

                    System.out.println("Item found at Row: " + i +
                                       ", Column: " + j);

                    System.out.print("Item Details: ");
                    grid[i][j].display();
                    return;
                }
            }
        }

        System.out.println("Item not found in warehouse");
    }

    public void displayGrid() {
        System.out.println("Warehouse Layout:");

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] != null) {
                    System.out.print(grid[i][j].getItemId() + "\t");
                } else {
                    System.out.print("Empty\t");
                }
            }
            System.out.println();
        }
    }
}

public class Project {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse(5, 5);

        warehouse.addItem(0, 0, new GridItem("I101", "Laptop", 10));
        warehouse.addItem(1, 2, new GridItem("I102", "Phone", 25));
        warehouse.addItem(3, 1, new GridItem("I103", "Keyboard", 15));
        warehouse.addItem(4, 4, new GridItem("I104", "Mouse", 20));

        warehouse.displayGrid();

        warehouse.searchItem("I102");
        warehouse.searchItem("I999");
    }
}