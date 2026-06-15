package org.example.edi.dto;

import org.example.edi.enums.Status;

public class ModifyOrderRequest {

    private Long id;
    private Status status;

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
}
