package com.filesync.domain.service;

import com.filesync.adapter.in.web.dto.FileDto;
import com.filesync.adapter.in.web.dto.StorageLocationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StorageLocationService {
    // Methods related to storage location management will be defined here
    StorageLocationDto createStorageLocation(StorageLocationDto dto);
    List<StorageLocationDto> listStorageLocations();
    StorageLocationDto getStorageLocationById(String locationId);
    StorageLocationDto updateStorageLocation(String locationId, StorageLocationDto dto);
    void deleteStorageLocation(String locationId);
    Page<FileDto> listFilesInStorageLocation(String locationId, String path, boolean recursive, Pageable pageable);
}
