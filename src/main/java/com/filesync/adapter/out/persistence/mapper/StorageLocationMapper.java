package com.filesync.adapter.out.persistence.mapper;

import com.filesync.adapter.out.persistence.entity.StorageLocationEntity;
import com.filesync.domain.model.StorageLocation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StorageLocationMapper {
    StorageLocationEntity toEntity(StorageLocation domain);
    StorageLocation toDomain(StorageLocationEntity entity);
}
