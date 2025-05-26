package com.filesync.adapter.in.web.dto;

// import jakarta.validation.constraints.NotBlank;

public class TransferRequestDto {
    // @NotBlank
    private String sourceLocationId;
    // @NotBlank
    private String destinationLocationId;
    // @NotBlank
    private String filePath; // Path of the file to transfer

    // Constructors, Getters, Setters
    public TransferRequestDto() {}

    public TransferRequestDto(String sourceLocationId, String destinationLocationId, String filePath) {
        this.sourceLocationId = sourceLocationId;
        this.destinationLocationId = destinationLocationId;
        this.filePath = filePath;
    }

    public String getSourceLocationId() { return sourceLocationId; }
    public void setSourceLocationId(String sourceLocationId) { this.sourceLocationId = sourceLocationId; }
    public String getDestinationLocationId() { return destinationLocationId; }
    public void setDestinationLocationId(String destinationLocationId) { this.destinationLocationId = destinationLocationId; }
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
}
