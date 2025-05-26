package com.filesync.adapter.in.web;

import com.filesync.adapter.in.web.dto.TransferRequestDto;
import com.filesync.adapter.in.web.dto.TransferResponseDto;
import com.filesync.application.port.in.FileTransferUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileTransferControllerTests {

    @Mock
    private FileTransferUseCase fileTransferUseCase;

    @InjectMocks
    private FileTransferController fileTransferController;

    @Test
    void initiateTransfer_shouldReturnOkAndResponseDto() {
        // Arrange
        TransferRequestDto requestDto = new TransferRequestDto("source1", "dest1", "file.txt");
        TransferResponseDto expectedResponseDto = new TransferResponseDto("job123", "PENDING", "source1", "dest1", "file.txt", 0.0, null);
        when(fileTransferUseCase.initiateTransfer(any(TransferRequestDto.class))).thenReturn(expectedResponseDto);

        // Act
        ResponseEntity<TransferResponseDto> responseEntity = fileTransferController.initiateTransfer(requestDto);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponseDto, responseEntity.getBody());
        verify(fileTransferUseCase, times(1)).initiateTransfer(requestDto);
    }

    @Test
    void getTransferStatus_shouldReturnOkAndResponseDto() {
        // Arrange
        String transferId = "job123";
        TransferResponseDto expectedResponseDto = new TransferResponseDto(transferId, "COMPLETED", "source1", "dest1", "file.txt", 100.0, null);
        when(fileTransferUseCase.getTransferJobStatus(transferId)).thenReturn(expectedResponseDto);

        // Act
        ResponseEntity<TransferResponseDto> responseEntity = fileTransferController.getTransferStatus(transferId);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponseDto, responseEntity.getBody());
        verify(fileTransferUseCase, times(1)).getTransferJobStatus(transferId);
    }

    @Test
    void listTransfers_shouldReturnOkAndPageOfResponseDtos() {
        // Arrange
        String status = "COMPLETED";
        String sourceId = "source1";
        String destinationId = "dest1";
        Pageable pageable = PageRequest.of(0, 10);
        List<TransferResponseDto> dtoList = Collections.singletonList(
            new TransferResponseDto("job123", status, sourceId, destinationId, "file.txt", 100.0, null)
        );
        Page<TransferResponseDto> expectedPage = new PageImpl<>(dtoList, pageable, dtoList.size());

        when(fileTransferUseCase.listTransferJobs(status, sourceId, destinationId, pageable)).thenReturn(expectedPage);

        // Act
        ResponseEntity<Page<TransferResponseDto>> responseEntity = fileTransferController.listTransfers(status, sourceId, destinationId, pageable);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedPage, responseEntity.getBody());
        verify(fileTransferUseCase, times(1)).listTransferJobs(status, sourceId, destinationId, pageable);
    }

     @Test
    void cancelTransfer_shouldReturnNoContent() {
        // Arrange
        String transferId = "job123";
        doNothing().when(fileTransferUseCase).cancelTransfer(transferId);

        // Act
        ResponseEntity<Void> responseEntity = fileTransferController.cancelTransfer(transferId);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(fileTransferUseCase, times(1)).cancelTransfer(transferId);
    }
}
