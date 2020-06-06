package com.fptu.swp.ppr.exceptions.handler;

import com.fptu.swp.ppr.util.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<BaseResponse> notFoundHandler(Exception ex) {
        BaseResponse response = new BaseResponse(false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<BaseResponse> badRequestHandler(Exception ex) {
        BaseResponse response = new BaseResponse(false, ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
