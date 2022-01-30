package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.transactions.Transaction;
import ua.com.alevel.persistence.repository.transactions.TransactionRepository;
import ua.com.alevel.service.TransactionService;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CrudRepositoryHelper<Transaction, TransactionRepository> crudRepositoryHelper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, CrudRepositoryHelper<Transaction, TransactionRepository> crudRepositoryHelper) {
        this.transactionRepository = transactionRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(Transaction entity) {
        crudRepositoryHelper.create(transactionRepository, entity);
    }

    @Override
    public void update(Transaction entity) {
        crudRepositoryHelper.update(transactionRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(transactionRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Transaction> findById(Long id) {
        return crudRepositoryHelper.findById(transactionRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public DataTableResponse<Transaction> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(transactionRepository, request);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
