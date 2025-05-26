package com.filesync.adapter.out.persistence;

import com.filesync.application.port.out.StorageLocationRepositoryPort;
import com.filesync.domain.model.StorageLocation;
import com.filesync.adapter.out.persistence.entity.StorageLocationEntity;
import com.filesync.adapter.out.persistence.mapper.StorageLocationMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StorageLocationJpaAdapter implements StorageLocationRepositoryPort {

    private final SpringDataStorageLocationRepository repository;
    private final StorageLocationMapper mapper;

    public StorageLocationJpaAdapter(SpringDataStorageLocationRepository repository, StorageLocationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StorageLocation save(StorageLocation storageLocation) {
        StorageLocationEntity entity = mapper.toEntity(storageLocation);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<StorageLocation> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<StorageLocation> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
    
    @Override
    public Optional<StorageLocation> findByName(String name) {
       return repository.findByName(name).map(mapper::toDomain);
    }

    // Inner Spring Data JPA repository interface
    @Repository
    interface SpringDataStorageLocationRepository extends JpaRepository<StorageLocationEntity, String> {
        Optional<StorageLocationEntity> findByName(String name); // Example custom query
    }
}
