package com.skimpybunnycompany.skimpybunny.repository;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import com.skimpybunnycompany.skimpybunny.domain.User;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, String> {
    //    /*query type 0*/ if (name.isEmpty() && contractor.isEmpty() && category.isEmpty() && dates.isEmpty() ) {
    Page<Transaction> findByUserLogin(String userLogin, Pageable paging);

    //    /*query type 1*/ if (name.isPresent() && contractor.isEmpty() && category.isEmpty() && dates.isEmpty() ) {
    Page<Transaction> findByUserLoginAndNameContainingIgnoreCase(String userLogin, String name, Pageable paging);

    //    /*query type 2*/ else if (name.isEmpty() && contractor.isPresent() && category.isEmpty() && dates.isEmpty() ) {
    Page<Transaction> findByUserLoginAndContractorContainingIgnoreCase(String userLogin, String contractor, Pageable paging);

    //    /*query type 3*/ else if (name.isEmpty() && contractor.isEmpty() && category.isPresent() && dates.isEmpty() ) {
    Page<Transaction> findByUserLoginAndCategoryContainingIgnoreCase(String userLogin, String category, Pageable paging);
    //    /*query type 4*/ else if (name.isPresent() && contractor.isPresent() && category.isEmpty() && dates.isEmpty() ) {
    Page<Transaction> findByUserLoginAndNameContainingIgnoreCaseAndContractorContainingIgnoreCase(
        String userLogin,
        String name,
        String contractor,
        Pageable paging
    );

    //    /*query type 5*/ else if (name.isPresent() && contractor.isEmpty() && category.isPresent() && dates.isEmpty() ) {
    Page<Transaction> findByUserLoginAndNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(
        String userLogin,
        String name,
        String category,
        Pageable paging
    );

    //    /*query type 6*/ else if (name.isEmpty() && contractor.isPresent() && category.isPresent() && dates.isEmpty() ) {
    Page<Transaction> findByUserLoginAndContractorContainingIgnoreCaseAndCategoryContainingIgnoreCase(
        String userLogin,
        String contractor,
        String category,
        Pageable paging
    );

    //    /*query type --7--*/else if (name.isEmpty() && contractor.isPresent() && category.isEmpty() && dates.isPresent() ) {}
    Page<Transaction> findByUserLoginAndContractorContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
        String userLogin,
        String contractor,
        LocalDate startDate,
        LocalDate endDate,
        Pageable paging
    );

    //    /*query type --8--*/else if (name.isEmpty() && contractor.isEmpty() && category.isPresent() && dates.isPresent() ) {}
    Page<Transaction> findByUserLoginAndCategoryContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
        String userLogin,
        String category,
        LocalDate startDate,
        LocalDate endDate,
        Pageable paging
    );

    //    /*query type --9--*/else if (name.isEmpty() && contractor.isEmpty() && category.isEmpty() && dates.isPresent() ) {
    Page<Transaction> findByUserLoginAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
        String userLogin,
        LocalDate startDate,
        LocalDate endDate,
        Pageable paging
    );

    //    /*query type --10--*/else if (name.isPresent() && contractor.isEmpty() && category.isEmpty() && dates.isPresent() ) {}
    Page<Transaction> findByUserLoginAndNameContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
        String userLogin,
        String name,
        LocalDate startDate,
        LocalDate endDate,
        Pageable paging
    );

    //    /*query type 11*/ else if (name.isPresent() && contractor.isPresent() && category.isPresent() && dates.isEmpty() ) {
    Page<Transaction> findByUserLoginAndNameContainingIgnoreCaseAndContractorContainingIgnoreCaseAndCategoryContainingIgnoreCase(
        String userLogin,
        String name,
        String contractor,
        String category,
        Pageable paging
    );

    //    /*query type --12--*/else if (name.isPresent() && contractor.isPresent() && category.isEmpty() && dates.isPresent() ) {}
    Page<Transaction> findByUserLoginAndNameContainingIgnoreCaseAndContractorContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
        String userLogin,
        String name,
        String contractor,
        LocalDate startDate,
        LocalDate endDate,
        Pageable paging
    );

    //    /*query type --13--*/else if (name.isPresent() && contractor.isEmpty() && category.isPresent() && dates.isPresent() ) {}
    Page<Transaction> findByUserLoginAndNameContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
        String userLogin,
        String name,
        String category,
        LocalDate startDate,
        LocalDate endDate,
        Pageable paging
    );

    //    /*query type --14--*/else if (name.isEmpty() && contractor.isPresent() && category.isPresent() && dates.isPresent() ) {}
    Page<Transaction> findByUserLoginAndContractorContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
        String userLogin,
        String contractor,
        String category,
        LocalDate startDate,
        LocalDate endDate,
        Pageable paging
    );

    //    /*query type --15--*/else if (name.isPresent() && contractor.isPresent() && category.isPresent() && dates.isPresent() ) {}
    Page<Transaction> findByUserLoginAndNameContainingIgnoreCaseAndContractorContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
        String userLogin,
        String name,
        String contractor,
        String category,
        LocalDate startDate,
        LocalDate endDate,
        Pageable paging
    );

    List<Transaction> getDistinctCategoryByUserLogin(String userLogin);
    List<Transaction> getDistinctContractorByUserLogin(String userLogin);
}
