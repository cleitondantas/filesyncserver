package com.filesync.adapter.out.persistence.mapper;

import com.filesync.adapter.out.persistence.entity.TransferJobEntity;
import com.filesync.domain.model.TransferJob;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransferJobMapper {
    TransferJobEntity toEntity(TransferJob domain);
    TransferJob toDomain(TransferJobEntity entity);
}
