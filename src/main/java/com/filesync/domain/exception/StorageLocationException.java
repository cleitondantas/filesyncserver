package com.filesync.domain.exception;

public class StorageLocationException extends RuntimeException {
    public StorageLocationException(String message) {
        super(message);
    }

    public StorageLocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
