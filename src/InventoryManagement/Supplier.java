package InventoryManagement;
public class Supplier extends InventoryEntity {

    private int supplierId;
    private String supplierName;

    public Supplier() {
        supplierId = 0;
        supplierName = "";
    }

    public Supplier(int supplierId, String supplierName) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    @Override
    public void display() {
        System.out.println("Supplier ID: " + supplierId);
        System.out.println("Supplier Name: " + supplierName);
        System.out.println("--------------------");
    }
}
