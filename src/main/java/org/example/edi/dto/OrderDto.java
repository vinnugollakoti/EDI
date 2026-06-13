package org.example.edi.dto;

import org.example.edi.enums.Status;

public class OrderDto {

    private int id;
    private String poNumber;
    private Status status;

    public void setId(int id) {
        this.id = id;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public int getId() {
        return id;
    }
}
