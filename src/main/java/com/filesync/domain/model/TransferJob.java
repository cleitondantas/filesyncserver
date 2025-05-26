package com.filesync.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransferJob {
    private String id;
    private StorageLocation source;
    private StorageLocation destination;
    private String filePath; // Relative path of the file within the source/destination
    private TransferStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
    private String errorMessage;

    // Constructors
    public TransferJob() {
    }

    public TransferJob(String id, StorageLocation source, StorageLocation destination, String filePath, TransferStatus status, LocalDateTime createdAt, LocalDateTime completedAt, String errorMessage) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.filePath = filePath;
        this.status = status;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.errorMessage = errorMessage;
    }

    // Getters and Setters
   public String getId() {
       return id;
   }

   public void setId(String id) {
       this.id = id;
   }

   public StorageLocation getSource() {
       return source;
   }

   public void setSource(StorageLocation source) {
       this.source = source;
   }

   public StorageLocation getDestination() {
       return destination;
   }

   public void setDestination(StorageLocation destination) {
       this.destination = destination;
   }

   public String getFilePath() {
       return filePath;
   }

   public void setFilePath(String filePath) {
       this.filePath = filePath;
   }

   public TransferStatus getStatus() {
       return status;
   }

   public void setStatus(TransferStatus status) {
       this.status = status;
   }

   public LocalDateTime getCreatedAt() {
       return createdAt;
   }

   public void setCreatedAt(LocalDateTime createdAt) {
       this.createdAt = createdAt;
   }

   public LocalDateTime getCompletedAt() {
       return completedAt;
   }

   public void setCompletedAt(LocalDateTime completedAt) {
       this.completedAt = completedAt;
   }

   public String getErrorMessage() {
       return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
       this.errorMessage = errorMessage;
   }

    // equals, hashCode, toString
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       TransferJob that = (TransferJob) o;
       return Objects.equals(id, that.id) &&
              Objects.equals(source, that.source) &&
              Objects.equals(destination, that.destination) &&
              Objects.equals(filePath, that.filePath) &&
              status == that.status &&
              Objects.equals(createdAt, that.createdAt) &&
              Objects.equals(completedAt, that.completedAt) &&
              Objects.equals(errorMessage, that.errorMessage);
   }

   @Override
   public int hashCode() {
       return Objects.hash(id, source, destination, filePath, status, createdAt, completedAt, errorMessage);
   }

   @Override
   public String toString() {
       return "TransferJob{" +
              "id='" + id + '\'' +
              ", source=" + source +
              ", destination=" + destination +
              ", filePath='" + filePath + '\'' +
              ", status=" + status +
              ", createdAt=" + createdAt +
              ", completedAt=" + completedAt +
              ", errorMessage='" + errorMessage + '\'' +
              '}';
   }
}
