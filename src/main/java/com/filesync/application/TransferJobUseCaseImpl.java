package com.filesync.application;

import com.filesync.application.port.in.TransferJobUseCase;
import com.filesync.domain.service.FileTransferService;
import org.springframework.stereotype.Service;

@Service
public class TransferJobUseCaseImpl implements TransferJobUseCase {

    private final FileTransferService fileTransferService;

    public TransferJobUseCaseImpl(FileTransferService fileTransferService) {
        this.fileTransferService = fileTransferService;
    }

    @Override
    public void manageJob(String jobId) {
        // Placeholder implementation
        System.out.println("Managing job: " + jobId);
    }
}
