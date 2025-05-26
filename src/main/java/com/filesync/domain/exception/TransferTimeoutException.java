package com.filesync.domain.exception;

public class TransferTimeoutException extends FileTransferException {
    public TransferTimeoutException(String message) {
        super(message);
    }

    public TransferTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}
