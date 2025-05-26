package com.filesync.application;

import com.filesync.adapter.in.web.dto.FileDto;
import com.filesync.adapter.in.web.dto.StorageLocationDto;
import com.filesync.domain.service.StorageLocationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StorageLocationUseCaseImplTests {

    @Mock
    private StorageLocationService storageLocationService;

    @InjectMocks
    private StorageLocationUseCaseImpl storageLocationUseCase;

    @Test
    void createStorageLocation_shouldCallServiceAndReturnDto() {
        // Arrange
        StorageLocationDto requestDto = new StorageLocationDto(null, "Test Location", "LOCAL", "/tmp", null);
        StorageLocationDto expectedDto = new StorageLocationDto("loc123", "Test Location", "LOCAL", "/tmp", null);
        when(storageLocationService.createStorageLocation(any(StorageLocationDto.class))).thenReturn(expectedDto);

        // Act
        StorageLocationDto actualDto = storageLocationUseCase.createStorageLocation(requestDto);

        // Assert
        assertNotNull(actualDto);
        assertEquals(expectedDto, actualDto);
        verify(storageLocationService, times(1)).createStorageLocation(requestDto);
    }

    @Test
    void listFilesInStorageLocation_shouldCallServiceAndReturnPage() {
        // Arrange
        String locationId = "loc123";
        String path = "/";
        boolean recursive = false;
        Pageable pageable = PageRequest.of(0, 10);
        List<FileDto> fileList = Collections.singletonList(new FileDto("file.txt", 1024L, false, null));
        Page<FileDto> expectedPage = new PageImpl<>(fileList, pageable, fileList.size());

        when(storageLocationService.listFilesInStorageLocation(locationId, path, recursive, pageable)).thenReturn(expectedPage);

        // Act
        Page<FileDto> actualPage = storageLocationUseCase.listFilesInStorageLocation(locationId, path, recursive, pageable);

        // Assert
        assertNotNull(actualPage);
        assertEquals(expectedPage, actualPage);
        verify(storageLocationService, times(1)).listFilesInStorageLocation(locationId, path, recursive, pageable);
    }
}
