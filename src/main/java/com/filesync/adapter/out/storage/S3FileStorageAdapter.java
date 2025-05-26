package com.filesync.adapter.out.storage;

import com.filesync.application.port.out.FileStoragePort;
import com.filesync.domain.model.StorageLocation;
import software.amazon.awssdk.services.s3.S3Client;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Collections;

@Component
@ConditionalOnProperty(name = "file.storage.type", havingValue = "s3")
public class S3FileStorageAdapter implements FileStoragePort {

    private final S3Client s3Client;

    public S3FileStorageAdapter(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public void uploadFile(StorageLocation location, String path, InputStream inputStream, long length) throws IOException {
        // Placeholder: Log and throw
        System.out.println("S3FileStorageAdapter: uploadFile called for " + path + " at " + location.getName());
        throw new UnsupportedOperationException("S3FileStorageAdapter#uploadFile not implemented yet");
    }

    @Override
    public InputStream downloadFile(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("S3FileStorageAdapter: downloadFile called for " + path + " at " + location.getName());
        throw new UnsupportedOperationException("S3FileStorageAdapter#downloadFile not implemented yet");
    }

    @Override
    public void deleteFile(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("S3FileStorageAdapter: deleteFile called for " + path + " at " + location.getName());
        throw new UnsupportedOperationException("S3FileStorageAdapter#deleteFile not implemented yet");
    }

    @Override
    public List<String> listFiles(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("S3FileStorageAdapter: listFiles called for " + path + " at " + location.getName());
        // throw new UnsupportedOperationException("S3FileStorageAdapter#listFiles not implemented yet");
        return Collections.emptyList(); // Return empty list as per instruction
    }

    @Override
    public boolean fileExists(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("S3FileStorageAdapter: fileExists called for " + path + " at " + location.getName());
        // throw new UnsupportedOperationException("S3FileStorageAdapter#fileExists not implemented yet");
        return false; // Return false as per instruction
    }
}
