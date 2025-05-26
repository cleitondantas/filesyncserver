package com.filesync.adapter.out.persistence;

import com.filesync.adapter.out.persistence.entity.StorageLocationEntity;
import com.filesync.adapter.out.persistence.mapper.StorageLocationMapper;
import com.filesync.domain.model.StorageLocation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StorageLocationJpaAdapterTests {

    @Mock
    private StorageLocationJpaAdapter.SpringDataStorageLocationRepository repository;

    @Mock
    private StorageLocationMapper mapper;

    @InjectMocks
    private StorageLocationJpaAdapter storageLocationJpaAdapter;

    @Test
    void save_shouldCallRepositoryAndMapperAndReturnDomain() {
        // Arrange
        StorageLocation domainToSave = new StorageLocation("loc1", "Local Disk", "LOCAL", "/mnt/data", null);
        StorageLocationEntity entityToSave = new StorageLocationEntity("loc1", "Local Disk", "LOCAL", "/mnt/data");
        StorageLocationEntity savedEntity = new StorageLocationEntity("loc1", "Local Disk", "LOCAL", "/mnt/data");
        StorageLocation expectedDomain = new StorageLocation("loc1", "Local Disk", "LOCAL", "/mnt/data", null);

        when(mapper.toEntity(any(StorageLocation.class))).thenReturn(entityToSave);
        when(repository.save(any(StorageLocationEntity.class))).thenReturn(savedEntity);
        when(mapper.toDomain(any(StorageLocationEntity.class))).thenReturn(expectedDomain);

        // Act
        StorageLocation actualDomain = storageLocationJpaAdapter.save(domainToSave);

        // Assert
        assertNotNull(actualDomain);
        assertEquals(expectedDomain, actualDomain);
        verify(mapper, times(1)).toEntity(domainToSave);
        verify(repository, times(1)).save(entityToSave);
        verify(mapper, times(1)).toDomain(savedEntity);
    }

    @Test
    void findById_shouldCallRepositoryAndMapperAndReturnOptionalDomain() {
        // Arrange
        String id = "loc1";
        StorageLocationEntity foundEntity = new StorageLocationEntity(id, "Local Disk", "LOCAL", "/mnt/data");
        StorageLocation expectedDomain = new StorageLocation(id, "Local Disk", "LOCAL", "/mnt/data", null);

        when(repository.findById(id)).thenReturn(Optional.of(foundEntity));
        when(mapper.toDomain(any(StorageLocationEntity.class))).thenReturn(expectedDomain);

        // Act
        Optional<StorageLocation> actualOptionalDomain = storageLocationJpaAdapter.findById(id);

        // Assert
        assertTrue(actualOptionalDomain.isPresent());
        assertEquals(expectedDomain, actualOptionalDomain.get());
        verify(repository, times(1)).findById(id);
        verify(mapper, times(1)).toDomain(foundEntity);
    }

    @Test
    void findById_whenNotFound_shouldReturnEmptyOptional() {
        // Arrange
        String id = "loc1";
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<StorageLocation> actualOptionalDomain = storageLocationJpaAdapter.findById(id);

        // Assert
        assertFalse(actualOptionalDomain.isPresent());
        verify(repository, times(1)).findById(id);
        verify(mapper, never()).toDomain(any());
    }
}
