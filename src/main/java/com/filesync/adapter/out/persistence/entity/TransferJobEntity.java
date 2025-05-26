package com.filesync.adapter.out.persistence.entity;

import com.filesync.domain.model.TransferStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer_jobs")
public class TransferJobEntity {
    @Id
    private String id;

    // Instead of full StorageLocationEntity, store IDs and fetch if needed,
    // or use @ManyToOne if appropriate and manage cascading/fetching.
    // For simplicity with Hexagonal Arch, IDs are often preferred in entities,
    // and mapping to domain models happens in the adapter.
    @Column(name = "source_location_id", nullable = false)
    private String sourceLocationId;

    @Column(name = "destination_location_id", nullable = false)
    private String destinationLocationId;

    @Column(name = "file_path", nullable = false)
    private String filePath; // Relative path of the file

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransferStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Lob // For potentially long error messages
    @Column(name = "error_message")
    private String errorMessage;

    // Constructors
    public TransferJobEntity() {}

    public TransferJobEntity(String id, String sourceLocationId, String destinationLocationId, String filePath, TransferStatus status, LocalDateTime createdAt, LocalDateTime completedAt, String errorMessage) {
        this.id = id;
        this.sourceLocationId = sourceLocationId;
        this.destinationLocationId = destinationLocationId;
        this.filePath = filePath;
        this.status = status;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.errorMessage = errorMessage;
    }

    // Getters and Setters
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
