package com.filesync.application;

import com.filesync.adapter.in.web.dto.TransferRequestDto;
import com.filesync.adapter.in.web.dto.TransferResponseDto;
import com.filesync.domain.service.FileTransferService;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileTransferUseCaseImplTests {

    @Mock
    private FileTransferService fileTransferService;

    @InjectMocks
    private FileTransferUseCaseImpl fileTransferUseCase;

    @Test
    void initiateTransfer_shouldCallServiceAndReturnDto() {
        // Arrange
        TransferRequestDto requestDto = new TransferRequestDto("source1", "dest1", "file.txt");
        TransferResponseDto expectedResponseDto = new TransferResponseDto("job123", "PENDING", "source1", "dest1", "file.txt", 0.0, null);
        when(fileTransferService.initiateTransfer(any(TransferRequestDto.class))).thenReturn(expectedResponseDto);

        // Act
        TransferResponseDto actualResponseDto = fileTransferUseCase.initiateTransfer(requestDto);

        // Assert
        assertNotNull(actualResponseDto);
        assertEquals(expectedResponseDto, actualResponseDto);
        verify(fileTransferService, times(1)).initiateTransfer(requestDto);
    }

    @Test
    void listTransferJobs_shouldCallServiceAndReturnPage() {
        // Arrange
        String status = "COMPLETED";
        String sourceId = "source1";
        String destinationId = "dest1";
        Pageable pageable = PageRequest.of(0, 10);
        List<TransferResponseDto> dtoList = Collections.singletonList(
            new TransferResponseDto("job123", status, sourceId, destinationId, "file.txt", 100.0, null)
        );
        Page<TransferResponseDto> expectedPage = new PageImpl<>(dtoList, pageable, dtoList.size());

        when(fileTransferService.listTransferJobs(status, sourceId, destinationId, pageable)).thenReturn(expectedPage);

        // Act
        Page<TransferResponseDto> actualPage = fileTransferUseCase.listTransferJobs(status, sourceId, destinationId, pageable);

        // Assert
        assertNotNull(actualPage);
        assertEquals(expectedPage, actualPage);
        verify(fileTransferService, times(1)).listTransferJobs(status, sourceId, destinationId, pageable);
    }
}
