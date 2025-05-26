package com.filesync.adapter.out.persistence;

import com.filesync.adapter.out.persistence.entity.TransferJobEntity;
import com.filesync.adapter.out.persistence.mapper.TransferJobMapper;
import com.filesync.domain.model.TransferJob;
import com.filesync.domain.model.TransferStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransferJobJpaAdapterTests {

    @Mock
    private TransferJobJpaAdapter.SpringDataTransferJobRepository repository;

    @Mock
    private TransferJobMapper mapper;

    @InjectMocks
    private TransferJobJpaAdapter transferJobJpaAdapter;

    @Test
    void save_shouldCallRepositoryAndMapperAndReturnDomain() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        TransferJob domainToSave = new TransferJob("job1", "source1", "dest1", TransferStatus.PENDING, now, now, null);
        TransferJobEntity entityToSave = new TransferJobEntity("job1", "source1", "dest1", TransferStatus.PENDING, now, now);
        TransferJobEntity savedEntity = new TransferJobEntity("job1", "source1", "dest1", TransferStatus.PENDING, now, now);
        TransferJob expectedDomain = new TransferJob("job1", "source1", "dest1", TransferStatus.PENDING, now, now, null);

        when(mapper.toEntity(any(TransferJob.class))).thenReturn(entityToSave);
        when(repository.save(any(TransferJobEntity.class))).thenReturn(savedEntity);
        when(mapper.toDomain(any(TransferJobEntity.class))).thenReturn(expectedDomain);

        // Act
        TransferJob actualDomain = transferJobJpaAdapter.save(domainToSave);

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
        String id = "job1";
        LocalDateTime now = LocalDateTime.now();
        TransferJobEntity foundEntity = new TransferJobEntity(id, "source1", "dest1", TransferStatus.COMPLETED, now, now);
        TransferJob expectedDomain = new TransferJob(id, "source1", "dest1", TransferStatus.COMPLETED, now, now, null);

        when(repository.findById(id)).thenReturn(Optional.of(foundEntity));
        when(mapper.toDomain(any(TransferJobEntity.class))).thenReturn(expectedDomain);

        // Act
        Optional<TransferJob> actualOptionalDomain = transferJobJpaAdapter.findById(id);

        // Assert
        assertTrue(actualOptionalDomain.isPresent());
        assertEquals(expectedDomain, actualOptionalDomain.get());
        verify(repository, times(1)).findById(id);
        verify(mapper, times(1)).toDomain(foundEntity);
    }
    
    @Test
    void findAllByStatus_shouldCallRepositoryAndMapperAndReturnPageOfDomainObjects() {
        // Arrange
        TransferStatus status = TransferStatus.PENDING;
        Pageable pageable = PageRequest.of(0, 10);
        LocalDateTime now = LocalDateTime.now();
        List<TransferJobEntity> entityList = Collections.singletonList(
            new TransferJobEntity("job1", "source1", "dest1", status, now, now)
        );
        Page<TransferJobEntity> entityPage = new PageImpl<>(entityList, pageable, entityList.size());
        
        TransferJob domain = new TransferJob("job1", "source1", "dest1", status, now, now, null);
        
        when(repository.findAllByStatus(status, pageable)).thenReturn(entityPage);
        when(mapper.toDomain(any(TransferJobEntity.class))).thenReturn(domain);

        // Act
        Page<TransferJob> actualPage = transferJobJpaAdapter.findAllByStatus(status, pageable);

        // Assert
        assertNotNull(actualPage);
        assertEquals(1, actualPage.getTotalElements());
        assertEquals(domain, actualPage.getContent().get(0));
        verify(repository, times(1)).findAllByStatus(status, pageable);
        verify(mapper, times(1)).toDomain(entityList.get(0));
    }
}
