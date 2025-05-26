package com.filesync.adapter.in.web.dto;

import java.time.LocalDateTime;

public class FileDto {
    private String path;
    private String name;
    private long size;
    private LocalDateTime lastModified;
    // Checksum might be too much for a list, can be added if needed for individual file details
    // private String checksum;

    // Constructors, Getters, Setters
    public FileDto() {}

    public FileDto(String path, String name, long size, LocalDateTime lastModified) {
        this.path = path;
        this.name = name;
        this.size = size;
        this.lastModified = lastModified;
    }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public long getSize() { return size; }
    public void setSize(long size) { this.size = size; }
    public LocalDateTime getLastModified() { return lastModified; }
    public void setLastModified(LocalDateTime lastModified) { this.lastModified = lastModified; }
}
