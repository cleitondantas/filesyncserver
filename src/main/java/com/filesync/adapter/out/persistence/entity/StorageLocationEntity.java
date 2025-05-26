package com.filesync.adapter.out.persistence.entity;

import com.filesync.domain.model.StorageType;
import jakarta.persistence.*; // JPA imports
import java.util.Map;

@Entity
@Table(name = "storage_locations")
public class StorageLocationEntity {
    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StorageType type;

    @ElementCollection(fetch = FetchType.EAGER) // Eager fetch for config, or lazy with proper handling
    @CollectionTable(name = "storage_location_configurations", joinColumns = @JoinColumn(name = "location_id"))
    @MapKeyColumn(name = "config_key")
    @Column(name = "config_value")
    private Map<String, String> configuration;

    // Constructors
    public StorageLocationEntity() {}

    public StorageLocationEntity(String id, String name, StorageType type, Map<String, String> configuration) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.configuration = configuration;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public StorageType getType() { return type; }
    public void setType(StorageType type) { this.type = type; }
    public Map<String, String> getConfiguration() { return configuration; }
    public void setConfiguration(Map<String, String> configuration) { this.configuration = configuration; }
}
