package com.filesync.adapter.out.storage;

import com.filesync.application.port.out.FileStoragePort;
import com.filesync.domain.model.StorageLocation;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Collections;

@Component
@ConditionalOnProperty(name = "file.storage.type", havingValue = "ftp")
public class FtpFileStorageAdapter implements FileStoragePort {

    // In a real implementation, you would manage the FTPClient lifecycle,
    // connection, disconnection, and error handling.
    // This might involve a pool of clients or a more sophisticated setup.
    // For this placeholder, we'll assume a new client is implicitly available or not used.

    public FtpFileStorageAdapter() {
        // Initialize FTPClient, potentially with configuration from application properties
        // For example:
        // this.ftpClient = new FTPClient();
        // // Configuration like host, port, user, password would be set here or per operation
        System.out.println("FtpFileStorageAdapter initialized.");
    }

    @Override
    public void uploadFile(StorageLocation location, String path, InputStream inputStream, long length) throws IOException {
        System.out.println("FtpFileStorageAdapter: uploadFile called for " + path + " at " + location.getName());
        // Example: connect, login, store file, logout, disconnect
        throw new UnsupportedOperationException("FtpFileStorageAdapter#uploadFile not implemented yet");
    }

    @Override
    public InputStream downloadFile(StorageLocation location, String path) throws IOException {
        System.out.println("FtpFileStorageAdapter: downloadFile called for " + path + " at " + location.getName());
        // Example: connect, login, retrieve file, logout, disconnect
        throw new UnsupportedOperationException("FtpFileStorageAdapter#downloadFile not implemented yet");
    }

    @Override
    public void deleteFile(StorageLocation location, String path) throws IOException {
        System.out.println("FtpFileStorageAdapter: deleteFile called for " + path + " at " + location.getName());
        // Example: connect, login, delete file, logout, disconnect
        throw new UnsupportedOperationException("FtpFileStorageAdapter#deleteFile not implemented yet");
    }

    @Override
    public List<String> listFiles(StorageLocation location, String path) throws IOException {
        System.out.println("FtpFileStorageAdapter: listFiles called for " + path + " at " + location.getName());
        // Example: connect, login, list files, logout, disconnect
        // throw new UnsupportedOperationException("FtpFileStorageAdapter#listFiles not implemented yet");
        return Collections.emptyList(); // Return empty list as per instruction
    }

    @Override
    public boolean fileExists(StorageLocation location, String path) throws IOException {
        System.out.println("FtpFileStorageAdapter: fileExists called for " + path + " at " + location.getName());
        // Example: connect, login, check file existence, logout, disconnect
        // throw new UnsupportedOperationException("FtpFileStorageAdapter#fileExists not implemented yet");
        return false; // Return false as per instruction
    }
}
