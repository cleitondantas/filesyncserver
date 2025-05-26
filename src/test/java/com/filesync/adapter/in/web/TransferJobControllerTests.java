package com.filesync.adapter.in.web;

import com.filesync.application.port.in.TransferJobUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransferJobControllerTests {

    @Mock
    private TransferJobUseCase transferJobUseCase;

    @InjectMocks
    private TransferJobController transferJobController;

    @Test
    void executeJob_shouldReturnOk() {
        // Arrange
        String jobId = "job123";
        doNothing().when(transferJobUseCase).manageJob(jobId);

        // Act
        ResponseEntity<Void> responseEntity = transferJobController.executeJob(jobId);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(transferJobUseCase, times(1)).manageJob(jobId);
    }
}
