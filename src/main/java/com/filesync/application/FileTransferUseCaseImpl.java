package com.filesync.application;

import com.filesync.adapter.in.web.dto.TransferRequestDto;
import com.filesync.adapter.in.web.dto.TransferResponseDto;
import com.filesync.application.port.in.FileTransferUseCase;
import com.filesync.domain.service.FileTransferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FileTransferUseCaseImpl implements FileTransferUseCase {

    private final FileTransferService fileTransferService;

    public FileTransferUseCaseImpl(FileTransferService fileTransferService) {
        this.fileTransferService = fileTransferService;
    }

    @Override
    public TransferResponseDto initiateTransfer(TransferRequestDto request) {
        return fileTransferService.initiateTransfer(request);
    }

    @Override
    public TransferResponseDto getTransferJobStatus(String transferId) {
        return fileTransferService.getTransferJobStatus(transferId);
    }

    @Override
    public Page<TransferResponseDto> listTransferJobs(String status, String sourceId, String destinationId, Pageable pageable) {
        return fileTransferService.listTransferJobs(status, sourceId, destinationId, pageable);
    }

    @Override
    public void cancelTransfer(String transferId) {
        fileTransferService.cancelTransfer(transferId);
    }
}
