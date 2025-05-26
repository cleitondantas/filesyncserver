package com.filesync.adapter.in.web.dto;

import com.filesync.domain.model.StorageType;
import java.util.Map;
// Add validation annotations if spring-boot-starter-validation is used, e.g.:
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;

public class StorageLocationDto {
    private String id;
    // @NotBlank
    private String name;
    // @NotNull
    private StorageType type;
    private Map<String, String> configuration; // Sensitive info should be handled carefully

    // Constructors, Getters, Setters
    public StorageLocationDto() {}

    public StorageLocationDto(String id, String name, StorageType type, Map<String, String> configuration) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.configuration = configuration;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public StorageType getType() { return type; }
    public void setType(StorageType type) { this.type = type; }
    public Map<String, String> getConfiguration() { return configuration; }
    public void setConfiguration(Map<String, String> configuration) { this.configuration = configuration; }
}
