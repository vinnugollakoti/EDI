package org.example.edi.dto;

public class ManageInventoryRequest {

    private String sku;
    private int quantity;
    private boolean add;


    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean getAdd() {
        return add;
    }
}
