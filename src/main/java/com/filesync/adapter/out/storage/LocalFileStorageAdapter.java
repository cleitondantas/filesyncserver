package com.filesync.adapter.out.storage;

import com.filesync.application.port.out.FileStoragePort;
import com.filesync.domain.model.StorageLocation;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Collections;

@Component
@ConditionalOnProperty(name = "file.storage.type", havingValue = "local", matchIfMissing = true)
public class LocalFileStorageAdapter implements FileStoragePort {

    public LocalFileStorageAdapter() {
        // Constructor, if needed for initialization
        System.out.println("LocalFileStorageAdapter initialized.");
    }

    @Override
    public void uploadFile(StorageLocation location, String path, InputStream inputStream, long length) throws IOException {
        // Placeholder: Log and throw
        System.out.println("LocalFileStorageAdapter: uploadFile called for " + path + " at " + location.getPath());
        // Example: Files.copy(inputStream, Paths.get(location.getPath(), path));
        throw new UnsupportedOperationException("LocalFileStorageAdapter#uploadFile not implemented yet");
    }

    @Override
    public InputStream downloadFile(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("LocalFileStorageAdapter: downloadFile called for " + path + " at " + location.getPath());
        // Example: return Files.newInputStream(Paths.get(location.getPath(), path));
        throw new UnsupportedOperationException("LocalFileStorageAdapter#downloadFile not implemented yet");
    }

    @Override
    public void deleteFile(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("LocalFileStorageAdapter: deleteFile called for " + path + " at " + location.getPath());
        // Example: Files.deleteIfExists(Paths.get(location.getPath(), path));
        throw new UnsupportedOperationException("LocalFileStorageAdapter#deleteFile not implemented yet");
    }

    @Override
    public List<String> listFiles(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("LocalFileStorageAdapter: listFiles called for " + path + " at " + location.getPath());
        // Example: return Files.list(Paths.get(location.getPath(), path)).map(p -> p.getFileName().toString()).collect(Collectors.toList());
        // throw new UnsupportedOperationException("LocalFileStorageAdapter#listFiles not implemented yet");
        return Collections.emptyList(); // Return empty list as per instruction
    }

    @Override
    public boolean fileExists(StorageLocation location, String path) throws IOException {
        // Placeholder: Log and throw
        System.out.println("LocalFileStorageAdapter: fileExists called for " + path + " at " + location.getPath());
        // Example: return Files.exists(Paths.get(location.getPath(), path));
        // throw new UnsupportedOperationException("LocalFileStorageAdapter#fileExists not implemented yet");
        return false; // Return false as per instruction
    }
}
