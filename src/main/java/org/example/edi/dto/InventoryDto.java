package org.example.edi.dto;

public class InventoryDto {
    private String sku;
    private int availableQuantity;
    private int reserveQuantity;


    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public void setReserveQuantity(int reserveQuantity) {
        this.reserveQuantity = reserveQuantity;
    }

    public String getSku() {
        return sku;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public int getReserveQuantity() {
        return reserveQuantity;
    }
}
