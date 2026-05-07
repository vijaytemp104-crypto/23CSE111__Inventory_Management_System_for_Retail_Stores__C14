package InventoryManagement;
public class Product extends InventoryEntity implements Alertable {

    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product() {
        id = 0;
        name = "";
        price = 0.0;
        quantity = 0;
    }

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public double getPrice() {

        return price;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    @Override
    public void display() {
        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("--------------------");        
    }

    @Override
    public boolean isLowStock() {
        if (quantity < LOW_STOCK_THRESHOLD) {
            return true;
        }
        return false;
    }

    @Override
    public void triggerLowStockAlert() {
        System.out.println("WARNING: Low stock for " + name + "! Only " + quantity + " left.");
    }
}
