package com.skimpybunnycompany.skimpybunny.repository;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, String> {
    Page<Transaction> findAll(Pageable paging);
    Page<Transaction> findByUserLogin(String userLogin, Pageable paging);

    Page<Transaction> findByUserLoginAndNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrContractorContainingIgnoreCase(
        String userLogin,
        String name,
        String category,
        String contractor,
        Pageable paging
    );
}
