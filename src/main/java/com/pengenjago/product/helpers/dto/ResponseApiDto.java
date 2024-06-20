package com.pengenjago.product.helpers.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
public class ResponseApiDto {
    private int code;
    private HttpStatus status;
    private String message;
    private Object data;
}
