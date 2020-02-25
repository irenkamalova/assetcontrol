package com.kamalova.assetcontrol.api.controller;

import com.kamalova.assetcontrol.api.model.response.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class AssetControlController {
    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ApiError> handleArgumentExceptions(IllegalArgumentException ex) {
        return new ResponseEntity<>(new ApiError(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ApiError> runTimeExceptions(RuntimeException ex) {
        return new ResponseEntity<>(new ApiError(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
