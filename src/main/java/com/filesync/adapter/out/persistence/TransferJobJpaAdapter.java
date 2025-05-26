package com.filesync.adapter.out.persistence;

import com.filesync.application.port.out.TransferJobRepositoryPort;
import com.filesync.domain.model.TransferJob;
import com.filesync.domain.model.TransferStatus;
import com.filesync.adapter.out.persistence.entity.TransferJobEntity;
import com.filesync.adapter.out.persistence.mapper.TransferJobMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public class TransferJobJpaAdapter implements TransferJobRepositoryPort {

    private final SpringDataTransferJobRepository repository;
    private final TransferJobMapper mapper;

    public TransferJobJpaAdapter(SpringDataTransferJobRepository repository, TransferJobMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TransferJob save(TransferJob transferJob) {
        TransferJobEntity entity = mapper.toEntity(transferJob);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<TransferJob> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<TransferJob> findAllByStatus(TransferStatus status, Pageable pageable) {
        return repository.findAllByStatus(status, pageable).map(mapper::toDomain);
    }
    
    @Override
    public Page<TransferJob> findAll(Pageable pageable) {
       return repository.findAll(pageable).map(mapper::toDomain);
    }

    // Inner Spring Data JPA repository interface
    @Repository
    interface SpringDataTransferJobRepository extends JpaRepository<TransferJobEntity, String> {
        Page<TransferJobEntity> findAllByStatus(TransferStatus status, Pageable pageable);
    }
}
