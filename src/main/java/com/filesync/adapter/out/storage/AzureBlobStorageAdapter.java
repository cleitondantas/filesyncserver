package com.filesync.adapter.out.storage;

import com.filesync.application.port.out.FileStoragePort;
import com.filesync.domain.model.StorageLocation;
import com.azure.storage.blob.BlobServiceClient;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Collections;

@Component
@ConditionalOnProperty(name = "file.storage.type", havingValue = "azure")
public class AzureBlobStorageAdapter implements FileStoragePort {

    private final BlobServiceClient blobServiceClient;

    public AzureBlobStorageAdapter(BlobServiceClient blobServiceClient) {
        this.blobServiceClient = blobServiceClient;
    }

    @Override
    public void uploadFile(StorageLocation location, String path, InputStream inputStream, long length) throws IOException {
        // Placeholder: Log and throw
        System.out.println("AzureBlobStorageAdapter: uploadFile called for " + path + " at " + location.getName());
        throw new UnsupportedOperationException("AzureBlobStorageAdapter#uploadFile not implemented yet");
    }

    @Override
    public InputStream downloadFile(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("AzureBlobStorageAdapter: downloadFile called for " + path + " at " + location.getName());
        throw new UnsupportedOperationException("AzureBlobStorageAdapter#downloadFile not implemented yet");
    }

    @Override
    public void deleteFile(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("AzureBlobStorageAdapter: deleteFile called for " + path + " at " + location.getName());
        throw new UnsupportedOperationException("AzureBlobStorageAdapter#deleteFile not implemented yet");
    }

    @Override
    public List<String> listFiles(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("AzureBlobStorageAdapter: listFiles called for " + path + " at " + location.getName());
        // throw new UnsupportedOperationException("AzureBlobStorageAdapter#listFiles not implemented yet");
        return Collections.emptyList(); // Return empty list as per instruction
    }

    @Override
    public boolean fileExists(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("AzureBlobStorageAdapter: fileExists called for " + path + " at " + location.getName());
        // throw new UnsupportedOperationException("AzureBlobStorageAdapter#fileExists not implemented yet");
        return false; // Return false as per instruction
    }
}
