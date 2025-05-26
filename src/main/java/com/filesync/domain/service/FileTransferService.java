package com.filesync.domain.service;

import com.filesync.adapter.in.web.dto.TransferRequestDto;
import com.filesync.adapter.in.web.dto.TransferResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FileTransferService {
    // Methods related to file transfer logic will be defined here
    TransferResponseDto initiateTransfer(TransferRequestDto request);
    TransferResponseDto getTransferJobStatus(String transferId);
    Page<TransferResponseDto> listTransferJobs(String status, String sourceId, String destinationId, Pageable pageable);
    void cancelTransfer(String transferId);
}
