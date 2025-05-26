package com.filesync.adapter.out.persistence;

import com.filesync.application.port.out.StorageLocationRepositoryPort;
// import com.filesync.domain.model.StorageLocation; // Domain model
// import com.filesync.adapter.out.persistence.entity.StorageLocationEntity; // JPA Entity
// import org.springframework.stereotype.Component;
// import java.util.List;
// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository; // Spring Data repo

// Define Spring Data JPA interface (can be inner or separate)
// interface SpringDataStorageLocationRepository extends JpaRepository<StorageLocationEntity, String> {
//     Optional<StorageLocationEntity> findByName(String name);
// }

// @Component
public class StorageLocationJpaAdapter implements StorageLocationRepositoryPort {

    // private final SpringDataStorageLocationRepository repository;
    // private final StorageLocationMapper mapper; // MapStruct or manual mapper

    // public StorageLocationJpaAdapter(SpringDataStorageLocationRepository repository, StorageLocationMapper mapper) {
    //     this.repository = repository;
    //     this.mapper = mapper;
    // }

    // @Override
    // public StorageLocation save(StorageLocation storageLocation) {
    //     StorageLocationEntity entity = mapper.toEntity(storageLocation);
    //     return mapper.toDomain(repository.save(entity));
    // }
    // Implement other methods from StorageLocationRepositoryPort using the repository and mapper
}
