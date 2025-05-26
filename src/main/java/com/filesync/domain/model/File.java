package com.filesync.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class File {
    private String path;
    private String name;
    private long size;
    private String checksum;
    private LocalDateTime lastModified;

    // Constructors
    public File() {
    }

    public File(String path, String name, long size, String checksum, LocalDateTime lastModified) {
        this.path = path;
        this.name = name;
        this.size = size;
        this.checksum = checksum;
        this.lastModified = lastModified;
    }

    // Getters and Setters
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    // equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return size == file.size &&
               Objects.equals(path, file.path) &&
               Objects.equals(name, file.name) &&
               Objects.equals(checksum, file.checksum) &&
               Objects.equals(lastModified, file.lastModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, name, size, checksum, lastModified);
    }

    @Override
    public String toString() {
        return "File{" +
               "path='" + path + '\'' +
               ", name='" + name + '\'' +
               ", size=" + size +
               ", checksum='" + checksum + '\'' +
               ", lastModified=" + lastModified +
               '}';
    }
}
