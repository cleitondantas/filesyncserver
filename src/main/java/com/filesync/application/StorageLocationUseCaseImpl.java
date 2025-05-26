package com.filesync.application;

import com.filesync.adapter.in.web.dto.FileDto;
import com.filesync.adapter.in.web.dto.StorageLocationDto;
import com.filesync.application.port.in.StorageLocationUseCase;
import com.filesync.domain.service.StorageLocationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StorageLocationUseCaseImpl implements StorageLocationUseCase {

    private final StorageLocationService storageLocationService;

    public StorageLocationUseCaseImpl(StorageLocationService storageLocationService) {
        this.storageLocationService = storageLocationService;
    }

    @Override
    public StorageLocationDto createStorageLocation(StorageLocationDto dto) {
        return storageLocationService.createStorageLocation(dto);
    }

    @Override
    public List<StorageLocationDto> listStorageLocations() {
        return storageLocationService.listStorageLocations();
    }

    @Override
    public StorageLocationDto getStorageLocationById(String locationId) {
        return storageLocationService.getStorageLocationById(locationId);
    }

    @Override
    public StorageLocationDto updateStorageLocation(String locationId, StorageLocationDto dto) {
        return storageLocationService.updateStorageLocation(locationId, dto);
    }

    @Override
    public void deleteStorageLocation(String locationId) {
        storageLocationService.deleteStorageLocation(locationId);
    }

    @Override
    public Page<FileDto> listFilesInStorageLocation(String locationId, String path, boolean recursive, Pageable pageable) {
        return storageLocationService.listFilesInStorageLocation(locationId, path, recursive, pageable);
    }
}
