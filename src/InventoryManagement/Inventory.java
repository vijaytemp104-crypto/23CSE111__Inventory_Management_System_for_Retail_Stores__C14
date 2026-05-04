package InventoryManagement;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Inventory {

    private ArrayList<Product> productList;

    public Inventory() {
        productList = new ArrayList<Product>();
    }

    public void addProduct(int id, String name, double price, int quantity) {
        for (Product item: productList) {
            if (item.getId() == id) {
                System.out.println("Product with this ID already exists!");
                return;
            }
        }
        Product p = new Product(id, name, price, quantity);
        productList.add(p);
        System.out.println("Product added successfully!");
    }

    public void displayInventory() {
        if (productList.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("===== INVENTORY =====");
        for (Product item: productList) {
            item.display();
        }
    }

    public void sellProduct(int id, int qty) {
        for (Product item: productList) {
            if (item.getId() == id) {
                if (item.getQuantity() < qty) {
                    System.out.println("Not enough stock! Available: " + item.getQuantity());
                    return;
                }
                item.setQuantity(item.getQuantity() - qty);
                System.out.println("Sale successful!");
                if (item.isLowStock()) {
                    item.triggerLowStockAlert();
                }
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void restockProduct(int id, int qty) {
        for (Product item: productList) {
            if (item.getId() == id) {
                item.setQuantity(item.getQuantity() + qty);
                System.out.println("Restocked! New quantity: " + item.getQuantity());
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void searchProduct(int id) {
        for (Product item: productList) {
            if (item.getId() == id) {
                item.display();
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Product item: productList) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                item.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found with that name.");
        }
    }

    public void showLowStockProducts() {
        boolean found = false;
        System.out.println("===== LOW STOCK PRODUCTS =====");
        for (Product item: productList) {
            if (item.isLowStock()) {
                item.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("All products are sufficiently stocked.");
        }
    }

    public void showInventoryValue() {
        double totalValue = 0;
        for (Product item: productList) {
            totalValue += item.getPrice() * item.getQuantity();
        }
        System.out.println("Total Inventory Value: Rs." + totalValue);
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                System.out.println("Product deleted.");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void exportToCSV(String fileName) throws IOException {
        if (productList.isEmpty()) {
            System.out.println("Inventory is empty. Nothing to export.");
            return;
        }

        FileWriter fw = new FileWriter(fileName);

        // write header row
        fw.write("Product ID,Name,Price,Quantity\n");

        // write each product as a row
        for (Product p : productList) {
            fw.write(p.getId() + "," + p.getName() + "," + p.getPrice() + "," + p.getQuantity() + "\n");
        }

        fw.close();
        System.out.println("Inventory exported successfully to " + fileName);
    }

    public void updateProduct(int id, String name, double price, int qty) {
        for (Product item: productList) {
            if (item.getId() == id) {
                item.setName(name);
                item.setPrice(price);
                item.setQuantity(qty);
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }
}
