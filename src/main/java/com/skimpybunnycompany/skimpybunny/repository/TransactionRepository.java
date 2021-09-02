package com.skimpybunnycompany.skimpybunny.repository;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
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
    //
    //    @Query("SELECT DISTINCT name FROM people WHERE name NOT IN (:names)")
    //    List<String> findNonReferencedNames(@Param("names") List<String> names);
    //
    //    @Query("SELECT DISTINCT t.category FROM transactions t")
    //    List<String> findAllCategories(String userLogin);

    //    Page<Transaction> findDistinctByUserLogin(String userLogin);
    List<Transaction> getDistinctCategoryByUserLogin(String userLogin);
}
