package InventoryManagement;
public interface Alertable {
    int LOW_STOCK_THRESHOLD = 5;
    boolean isLowStock();
    void triggerLowStockAlert();
}
