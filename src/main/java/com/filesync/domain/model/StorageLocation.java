package com.filesync.domain.model;

import java.util.Map;
import java.util.Objects;

public class StorageLocation {
    private String id;
    private String name;
    private StorageType type;
    private Map<String, String> configuration;

    // Constructors
    public StorageLocation() {
    }

    public StorageLocation(String id, String name, StorageType type, Map<String, String> configuration) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.configuration = configuration;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StorageType getType() {
        return type;
    }

    public void setType(StorageType type) {
        this.type = type;
    }

    public Map<String, String> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    // equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageLocation that = (StorageLocation) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(name, that.name) &&
               type == that.type &&
               Objects.equals(configuration, that.configuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, configuration);
    }

    @Override
    public String toString() {
        return "StorageLocation{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", configuration=" + configuration +
               '}';
    }
}
