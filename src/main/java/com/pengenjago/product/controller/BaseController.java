package com.pengenjago.product.controller;

import com.pengenjago.product.helpers.dto.ResponseApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class BaseController {

    public ResponseApiDto ResponseOk(Object data) {
        ResponseApiDto res = new ResponseApiDto();
        res.setCode(200);
        res.setStatus(HttpStatus.OK);
        res.setMessage("Success");
        res.setData(data);

        return res;
    }

    public ResponseApiDto ResponseInvalidRequest(Object data, String message) {
        ResponseApiDto res = new ResponseApiDto();
        res.setCode(400);
        res.setStatus(HttpStatus.BAD_REQUEST);
        res.setMessage(message);
        res.setData(data);

        return res;
    }

    public ResponseApiDto ResponseNotFound(String message) {
        ResponseApiDto res = new ResponseApiDto();
        res.setCode(404);
        res.setStatus(HttpStatus.NOT_FOUND);
        res.setMessage(message);
        res.setData(null);

        return res;
    }
}
