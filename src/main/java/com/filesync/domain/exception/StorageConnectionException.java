package com.filesync.domain.exception;

public class StorageConnectionException extends StorageLocationException {
    public StorageConnectionException(String message) {
        super(message);
    }

    public StorageConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
