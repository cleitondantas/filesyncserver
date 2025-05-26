package com.filesync.adapter.in.web;

import com.filesync.adapter.in.web.dto.ErrorResponse;
import com.filesync.domain.exception.FileNotFoundException;
import com.filesync.domain.exception.FileTransferException;
import com.filesync.domain.exception.StorageConnectionException;
import com.filesync.domain.exception.StorageLocationException;
import com.filesync.domain.exception.TransferTimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FileTransferException.class)
    public ResponseEntity<ErrorResponse> handleFileTransferException(FileTransferException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "File Transfer Error",
                ex.getMessage(),
                request.getDescription(false).substring(4) // remove "uri="
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StorageLocationException.class)
    public ResponseEntity<ErrorResponse> handleStorageLocationException(StorageLocationException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), // Or INTERNAL_SERVER_ERROR depending on context
                "Storage Location Error",
                ex.getMessage(),
                request.getDescription(false).substring(4)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFileNotFoundException(FileNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "File Not Found",
                ex.getMessage(),
                request.getDescription(false).substring(4)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransferTimeoutException.class)
    public ResponseEntity<ErrorResponse> handleTransferTimeoutException(TransferTimeoutException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.REQUEST_TIMEOUT.value(),
                "Transfer Timeout",
                ex.getMessage(),
                request.getDescription(false).substring(4)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.REQUEST_TIMEOUT);
    }

    @ExceptionHandler(StorageConnectionException.class)
    public ResponseEntity<ErrorResponse> handleStorageConnectionException(StorageConnectionException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.SERVICE_UNAVAILABLE.value(), // Or specific error code for connection issues
                "Storage Connection Error",
                ex.getMessage(),
                request.getDescription(false).substring(4)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(Exception.class) // Generic fallback handler
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage(), // Or a generic message for unknown errors
                request.getDescription(false).substring(4)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
