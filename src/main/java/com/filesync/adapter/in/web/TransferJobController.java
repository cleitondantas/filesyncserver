package com.filesync.adapter.in.web;

import com.filesync.application.port.in.TransferJobUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobs") // Example, might be part of /transfers or a separate resource
public class TransferJobController {

    private final TransferJobUseCase transferJobUseCase;

    public TransferJobController(TransferJobUseCase transferJobUseCase) {
        this.transferJobUseCase = transferJobUseCase;
    }

    // Example of a potential job-specific endpoint:
    @PostMapping("/{jobId}/execute")
    public ResponseEntity<Void> executeJob(@PathVariable String jobId) {
        transferJobUseCase.manageJob(jobId); // Or a more specific method
        return ResponseEntity.ok().build();
    }
}
