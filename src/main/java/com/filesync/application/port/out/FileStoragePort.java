package com.filesync.application.port.out;

import com.filesync.domain.model.StorageLocation;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

public interface FileStoragePort {
    void uploadFile(StorageLocation location, String path, InputStream inputStream, long length) throws IOException;
    InputStream downloadFile(StorageLocation location, String path) throws IOException;
    void deleteFile(StorageLocation location, String path) throws IOException;
    List<String> listFiles(StorageLocation location, String path) throws IOException;
    boolean fileExists(StorageLocation location, String path) throws IOException;
}
