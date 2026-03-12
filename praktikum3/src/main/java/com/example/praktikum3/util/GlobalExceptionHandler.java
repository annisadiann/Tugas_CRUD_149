package com.example.praktikum3.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handleRuntimeException(RuntimeException ex) {
        String message = ex.getMessage();
        HttpStatus status;

        if (message != null && message.contains("tidak ditemukan")) {
            status = HttpStatus.NOT_FOUND; // 404
        } else if (message != null && message.contains("sudah ada")) {
            status = HttpStatus.CONFLICT; // 409
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
        }

        return ResponseEntity.status(status)
                .body(new ApiResponse<>(message, null));
    }
}
