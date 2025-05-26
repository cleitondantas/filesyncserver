package com.filesync.adapter.in.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.filesync.application.port.in.FileTransferUseCase;
import com.filesync.adapter.in.web.dto.TransferRequestDto;
import com.filesync.adapter.in.web.dto.TransferResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transfers")
public class FileTransferController {

    private final FileTransferUseCase fileTransferUseCase;

    public FileTransferController(FileTransferUseCase fileTransferUseCase) {
        this.fileTransferUseCase = fileTransferUseCase;
    }

    @PostMapping
    public ResponseEntity<TransferResponseDto> initiateTransfer(@RequestBody TransferRequestDto request) {
        return ResponseEntity.ok(fileTransferUseCase.initiateTransfer(request));
    }

    @GetMapping("/{transferId}")
    public ResponseEntity<TransferResponseDto> getTransferStatus(@PathVariable String transferId) {
        return ResponseEntity.ok(fileTransferUseCase.getTransferJobStatus(transferId));
    }

    @GetMapping
    public ResponseEntity<Page<TransferResponseDto>> listTransfers(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String sourceId,
            @RequestParam(required = false) String destinationId,
            Pageable pageable) {
        return ResponseEntity.ok(fileTransferUseCase.listTransferJobs(status, sourceId, destinationId, pageable));
    }

    @DeleteMapping("/{transferId}")
    public ResponseEntity<Void> cancelTransfer(@PathVariable String transferId) {
        fileTransferUseCase.cancelTransfer(transferId);
        return ResponseEntity.noContent().build();
    }
}
