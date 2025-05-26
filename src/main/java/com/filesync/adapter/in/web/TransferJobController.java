package com.filesync.adapter.in.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Future imports:
// import com.filesync.application.port.in.TransferJobUseCase;

@RestController
@RequestMapping("/api/v1/jobs") // Example, might be part of /transfers or a separate resource
public class TransferJobController {

    // private final TransferJobUseCase transferJobUseCase;

    // public TransferJobController(TransferJobUseCase transferJobUseCase) {
    //     this.transferJobUseCase = transferJobUseCase;
    // }

    // Endpoints specific to TransferJob if not covered by FileTransferController
}
