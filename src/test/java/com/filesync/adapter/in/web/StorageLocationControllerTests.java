package com.filesync.adapter.in.web;

import com.filesync.adapter.in.web.dto.FileDto;
import com.filesync.adapter.in.web.dto.StorageLocationDto;
import com.filesync.application.port.in.StorageLocationUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StorageLocationControllerTests {

    @Mock
    private StorageLocationUseCase storageLocationUseCase;

    @InjectMocks
    private StorageLocationController storageLocationController;

    @Test
    void createStorageLocation_shouldReturnOkAndStorageLocationDto() {
        // Arrange
        StorageLocationDto requestDto = new StorageLocationDto(null, "Test Location", "LOCAL", "/tmp", null);
        StorageLocationDto expectedResponseDto = new StorageLocationDto("loc123", "Test Location", "LOCAL", "/tmp", null);
        when(storageLocationUseCase.createStorageLocation(any(StorageLocationDto.class))).thenReturn(expectedResponseDto);

        // Act
        ResponseEntity<StorageLocationDto> responseEntity = storageLocationController.createStorageLocation(requestDto);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponseDto, responseEntity.getBody());
        verify(storageLocationUseCase, times(1)).createStorageLocation(requestDto);
    }

    @Test
    void listStorageLocations_shouldReturnOkAndListOfStorageLocationDtos() {
        // Arrange
        List<StorageLocationDto> expectedList = Collections.singletonList(
            new StorageLocationDto("loc123", "Test Location", "LOCAL", "/tmp", null)
        );
        when(storageLocationUseCase.listStorageLocations()).thenReturn(expectedList);

        // Act
        ResponseEntity<List<StorageLocationDto>> responseEntity = storageLocationController.listStorageLocations();

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedList, responseEntity.getBody());
        verify(storageLocationUseCase, times(1)).listStorageLocations();
    }
    
    @Test
    void getStorageLocation_shouldReturnOkAndStorageLocationDto() {
        // Arrange
        String locationId = "loc123";
        StorageLocationDto expectedDto = new StorageLocationDto(locationId, "Test Location", "LOCAL", "/tmp", null);
        when(storageLocationUseCase.getStorageLocationById(locationId)).thenReturn(expectedDto);

        // Act
        ResponseEntity<StorageLocationDto> responseEntity = storageLocationController.getStorageLocation(locationId);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedDto, responseEntity.getBody());
        verify(storageLocationUseCase, times(1)).getStorageLocationById(locationId);
    }

    @Test
    void updateStorageLocation_shouldReturnOkAndStorageLocationDto() {
        // Arrange
        String locationId = "loc123";
        StorageLocationDto requestDto = new StorageLocationDto(locationId, "Updated Location", "LOCAL", "/data", null);
        StorageLocationDto expectedDto = new StorageLocationDto(locationId, "Updated Location", "LOCAL", "/data", null);
        when(storageLocationUseCase.updateStorageLocation(eq(locationId), any(StorageLocationDto.class))).thenReturn(expectedDto);

        // Act
        ResponseEntity<StorageLocationDto> responseEntity = storageLocationController.updateStorageLocation(locationId, requestDto);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedDto, responseEntity.getBody());
        verify(storageLocationUseCase, times(1)).updateStorageLocation(locationId, requestDto);
    }

    @Test
    void deleteStorageLocation_shouldReturnNoContent() {
        // Arrange
        String locationId = "loc123";
        doNothing().when(storageLocationUseCase).deleteStorageLocation(locationId);

        // Act
        ResponseEntity<Void> responseEntity = storageLocationController.deleteStorageLocation(locationId);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(storageLocationUseCase, times(1)).deleteStorageLocation(locationId);
    }

    @Test
    void listFiles_shouldReturnOkAndPageOfFileDtos() {
        // Arrange
        String locationId = "loc123";
        String path = "/";
        boolean recursive = false;
        Pageable pageable = PageRequest.of(0, 10);
        List<FileDto> fileList = Collections.singletonList(new FileDto("file.txt", 1024L, false, null));
        Page<FileDto> expectedPage = new PageImpl<>(fileList, pageable, fileList.size());

        when(storageLocationUseCase.listFilesInStorageLocation(locationId, path, recursive, pageable)).thenReturn(expectedPage);

        // Act
        ResponseEntity<Page<FileDto>> responseEntity = storageLocationController.listFiles(locationId, path, recursive, pageable);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedPage, responseEntity.getBody());
        verify(storageLocationUseCase, times(1)).listFilesInStorageLocation(locationId, path, recursive, pageable);
    }
}
