package com.skimpybunnycompany.skimpybunny.repository;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, String> {
    //    List<Transaction> findAll ( Pageable paging );
    Page<Transaction> findByUserLogin(String userLogin, Pageable paging);
    Page<Transaction> findByUserLoginAndNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrContractorContainingIgnoreCase(
        String userLogin,
        String title,
        String category,
        String contractor,
        Pageable paging
    );
}
