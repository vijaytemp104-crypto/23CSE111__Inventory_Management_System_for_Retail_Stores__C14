package InventoryManagement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        Supplier supplier = null;
        Scanner sc = new Scanner(System.in);

        // adding some sample products to start with
        inventory.addProduct(1, "Rice 5kg", 285.00, 50);
        inventory.addProduct(2, "Sunflower Oil 1L", 135.00, 30);
        inventory.addProduct(3, "Wheat Flour", 60.00, 3);
        inventory.addProduct(4, "Toor Dal", 95.00, 20);
        inventory.addProduct(5, "Sugar 1kg", 42.00, 2);

        int choice = -1;

        while (choice != 0) {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1.  Add Product");
            System.out.println("2.  Display Inventory");
            System.out.println("3.  Sell Product");
            System.out.println("4.  Restock Product");
            System.out.println("5.  Search by ID");
            System.out.println("6.  Search by Name");
            System.out.println("7.  Update Product");
            System.out.println("8.  Delete Product");
            System.out.println("9.  Show Low Stock");
            System.out.println("10. Show Inventory Value");
            System.out.println("11. Export Inventory to CSV");
            System.out.println("12. Add Supplier");
            System.out.println("13. Display Supplier");
            System.out.println("0.  Exit");
            System.out.println("========================================");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int newId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double newPrice = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int newQty = sc.nextInt();
                    sc.nextLine();
                    inventory.addProduct(newId, newName, newPrice, newQty);
                    break;

                case 2:
                    inventory.displayInventory();
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int sellId = sc.nextInt();
                    System.out.print("Enter Quantity to Sell: ");
                    int sellQty = sc.nextInt();
                    sc.nextLine();
                    inventory.sellProduct(sellId, sellQty);
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    int restockId = sc.nextInt();
                    System.out.print("Enter Quantity to Add: ");
                    int restockQty = sc.nextInt();
                    sc.nextLine();
                    inventory.restockProduct(restockId, restockQty);
                    break;

                case 5:
                    System.out.print("Enter Product ID to Search: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();
                    inventory.searchProduct(searchId);
                    break;

                case 6:
                    System.out.print("Enter Product Name to Search: ");
                    String searchName = sc.nextLine();
                    inventory.searchByName(searchName);
                    break;

                case 7:
                    System.out.print("Enter Product ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String updateName = sc.nextLine();
                    System.out.print("Enter New Price: ");
                    double updatePrice = sc.nextDouble();
                    System.out.print("Enter New Quantity: ");
                    int updateQty = sc.nextInt();
                    sc.nextLine();
                    inventory.updateProduct(updateId, updateName, updatePrice, updateQty);
                    break;

                case 8:
                    System.out.print("Enter Product ID to Delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    inventory.deleteProduct(deleteId);
                    break;

                case 9:
                    inventory.showLowStockProducts();
                    break;

                case 10:
                    inventory.showInventoryValue();
                    break;

                case 11:
                    System.out.print("Enter file name (e.g. inventory.csv): ");
                    String csvFile = sc.nextLine();
                    try {
                        inventory.exportToCSV(csvFile);
                    } catch (Exception e) {
                        System.out.println("Failed to export: " + e.getMessage());
                    }
                    break;
                case 12:
                    System.out.println("Enter supplier id : ");
                    int supplierID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter supplier name :");
                    String supplierName = sc.nextLine();
                    supplier = new Supplier(supplierID,supplierName);
                    break;
                case 13:
                    try{
                        supplier.display();
                    } catch (Exception e) {
                        System.out.println("Please add a supplier first");
                    }
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
