package com.filesync.adapter.out.persistence;

import com.filesync.application.port.out.TransferJobRepositoryPort;
// import com.filesync.domain.model.TransferJob;
// import com.filesync.domain.model.TransferStatus;
// import com.filesync.adapter.out.persistence.entity.TransferJobEntity;
// import org.springframework.stereotype.Component;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// interface SpringDataTransferJobRepository extends JpaRepository<TransferJobEntity, String> {
//     Page<TransferJobEntity> findAllByStatus(TransferStatus status, Pageable pageable);
// }

// @Component
public class TransferJobJpaAdapter implements TransferJobRepositoryPort {

    // private final SpringDataTransferJobRepository repository;
    // private final TransferJobMapper mapper; // MapStruct or manual mapper

    // public TransferJobJpaAdapter(SpringDataTransferJobRepository repository, TransferJobMapper mapper) {
    //     this.repository = repository;
    //     this.mapper = mapper;
    // }

    // @Override
    // public TransferJob save(TransferJob transferJob) {
    //    TransferJobEntity entity = mapper.toEntity(transferJob);
    //    return mapper.toDomain(repository.save(entity));
    // }
    // Implement other methods from TransferJobRepositoryPort
}
