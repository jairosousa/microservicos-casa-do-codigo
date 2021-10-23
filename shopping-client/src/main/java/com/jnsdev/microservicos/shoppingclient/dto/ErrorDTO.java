package com.jnsdev.microservicos.shoppingclient.dto;

import java.util.Date;

/**
 * @Autor Jairo Nascimento
 * @Created 12/10/2021 - 10:25
 */
public class ErrorDTO {
    private int status;
    private String message;
    private Date timestamp;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
