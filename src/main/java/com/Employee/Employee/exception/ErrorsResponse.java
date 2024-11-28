package com.Employee.Employee.exception;

import lombok.Data;

@Data
public class ErrorsResponse {
    private int status;
    private String message;
    private double timestamp;

    public ErrorsResponse(){}
    public ErrorsResponse(int status, String message, double timestamp){
        this.status=status;
        this.message=message;
        this.timestamp=timestamp;

    }
}
