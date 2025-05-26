package com.filesync.adapter.in.web.dto;

import com.filesync.domain.model.TransferStatus;
import java.time.LocalDateTime;

public class TransferResponseDto {
    private String id;
    private String sourceLocationId;
    private String destinationLocationId;
    private String filePath;
    private TransferStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
    private String errorMessage;

    // Constructors, Getters, Setters
    public TransferResponseDto() {}

    public TransferResponseDto(String id, String sourceLocationId, String destinationLocationId, String filePath, TransferStatus status, LocalDateTime createdAt, LocalDateTime completedAt, String errorMessage) {
        this.id = id;
        this.sourceLocationId = sourceLocationId;
        this.destinationLocationId = destinationLocationId;
        this.filePath = filePath;
        this.status = status;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.errorMessage = errorMessage;
    }

   public String getId() { return id; }
   public void setId(String id) { this.id = id; }
   public String getSourceLocationId() { return sourceLocationId; }
   public void setSourceLocationId(String sourceLocationId) { this.sourceLocationId = sourceLocationId; }
   public String getDestinationLocationId() { return destinationLocationId; }
   public void setDestinationLocationId(String destinationLocationId) { this.destinationLocationId = destinationLocationId; }
   public String getFilePath() { return filePath; }
   public void setFilePath(String filePath) { this.filePath = filePath; }
   public TransferStatus getStatus() { return status; }
   public void setStatus(TransferStatus status) { this.status = status; }
   public LocalDateTime getCreatedAt() { return createdAt; }
   public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
   public LocalDateTime getCompletedAt() { return completedAt; }
   public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
   public String getErrorMessage() { return errorMessage; }
   public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
}
