package com.cabapp.pro.controller;

import com.cabapp.pro.dto.ExceptionResponseDto;
import com.cabapp.pro.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException extends Exception{
	 /**
     * Handles CustomerException and generates an appropriate response.
     * 
     * @param ex The CustomerException object thrown
     * @return ResponseEntity with status code and exception message in the body
     */
    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<Object> CabServiceException(CustomerException ex) {
        ExceptionResponseDto message = new ExceptionResponseDto(
                ex.getStatusCode(), ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode()).body(message);
    }

    /**
     * Handles CabException and generates an appropriate response.
     * 
     * @param ex The CabException object thrown
     * @return ResponseEntity with status code and exception message in the body
     */
    @ExceptionHandler(CabException.class)
    public ResponseEntity<Object> CabServiceException(CabException ex) {
        ExceptionResponseDto message = new ExceptionResponseDto(
                ex.getStatusCode(), ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode()).body(message);
    }

    /**
     * Handles DriverException and generates an appropriate response.
     * 
     * @param ex The DriverException object thrown
     * @return ResponseEntity with status code and exception message in the body
     */
    @ExceptionHandler(DriverException.class)
    public ResponseEntity<Object> CabServiceException(DriverException ex) {
        ExceptionResponseDto message = new ExceptionResponseDto(
                ex.getStatusCode(), ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode()).body(message);
    }

    /**
     * Handles AdminException and generates an appropriate response.
     * 
     * @param ex The AdminException object thrown
     * @return ResponseEntity with status code and exception message in the body
     */
    @ExceptionHandler(AdminException.class)
    public ResponseEntity<Object> CabServiceException(AdminException ex) {
        ExceptionResponseDto message = new ExceptionResponseDto(
                ex.getStatusCode(), ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode()).body(message);
    }

    /**
     * Handles ComplaintException and generates an appropriate response.
     * 
     * @param ex The ComplaintException object thrown
     * @return ResponseEntity with status code and exception message in the body
     */
    @ExceptionHandler(ComplaintException.class)
    public ResponseEntity<Object> CabServiceException(ComplaintException ex) {
        ExceptionResponseDto message = new ExceptionResponseDto(
                ex.getStatusCode(), ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode()).body(message);
    }
}