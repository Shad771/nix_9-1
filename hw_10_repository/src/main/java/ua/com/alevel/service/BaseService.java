package ua.com.alevel.service;

import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.Optional;

public interface BaseService<ENT extends BaseEntity> {

    void create(ENT ent);

    void update(ENT ent);

    void delete(Long id);

    Optional<ENT> findById(Long id);

    DataTableResponse<ENT> findAll(DataTableRequest request);
}
