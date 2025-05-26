package com.filesync.adapter.in.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.filesync.application.port.in.StorageLocationUseCase;
import com.filesync.adapter.in.web.dto.StorageLocationDto;
import com.filesync.adapter.in.web.dto.FileDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/storage-locations")
public class StorageLocationController {

    private final StorageLocationUseCase storageLocationUseCase;

    public StorageLocationController(StorageLocationUseCase storageLocationUseCase) {
       this.storageLocationUseCase = storageLocationUseCase;
    }

    @PostMapping
    public ResponseEntity<StorageLocationDto> createStorageLocation(@RequestBody StorageLocationDto dto) {
        return ResponseEntity.ok(storageLocationUseCase.createStorageLocation(dto));
    }

    @GetMapping
    public ResponseEntity<List<StorageLocationDto>> listStorageLocations() {
        return ResponseEntity.ok(storageLocationUseCase.listStorageLocations());
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<StorageLocationDto> getStorageLocation(@PathVariable String locationId) {
        return ResponseEntity.ok(storageLocationUseCase.getStorageLocationById(locationId));
    }

    @PutMapping("/{locationId}")
    public ResponseEntity<StorageLocationDto> updateStorageLocation(@PathVariable String locationId, @RequestBody StorageLocationDto dto) {
        return ResponseEntity.ok(storageLocationUseCase.updateStorageLocation(locationId, dto));
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> deleteStorageLocation(@PathVariable String locationId) {
        storageLocationUseCase.deleteStorageLocation(locationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{locationId}/files")
    public ResponseEntity<Page<FileDto>> listFiles(
            @PathVariable String locationId,
            @RequestParam(required = false, defaultValue = "/") String path,
            @RequestParam(required = false, defaultValue = "false") boolean recursive,
            Pageable pageable) {
        return ResponseEntity.ok(storageLocationUseCase.listFilesInStorageLocation(locationId, path, recursive, pageable));
    }
}
