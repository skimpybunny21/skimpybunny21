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
    // (title.isEmpty() && contractor.isEmpty() && category.isEmpty()) {
    Page<Transaction> findByUserLogin(String userLogin, Pageable paging);

    // (title.Present() && contractor.isEmpty() && category.isEmpty()) {
    Page<Transaction> findByUserLoginAndNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrContractorContainingIgnoreCase(
        String userLogin,
        String name,
        String category,
        String contractor,
        Pageable paging
    );

    // title.isEmpty() && contractor.isPresent() && category.isEmpty()){
    Page<Transaction> findByUserLoginAndContractorContainingIgnoreCase(String userLogin, String contractor, Pageable paging);

    // title.isEmpty() && contractor.isEmpty() && category.isPresent()){
    Page<Transaction> findByUserLoginAndCategoryContainingIgnoreCase(String userLogin, String category, Pageable paging);

    /*
    // title.isPresent() && contractor.isPresent() && category.isEmpty()){
    // title.isPresent() && contractor.isEmpty() && category.isPresent()){
    // title.isPresent() && contractor.isPresent() && category.isPresent())
     above methods are "the same" as :
     (title.Present() && contractor.isEmpty() && category.isEmpty())
     reason is that we still search(filter) transactions
     */

    // title.isEmpty() && contractor.isPresent() && category.isPresent()){
    Page<Transaction> findByUserLoginAndCategoryContainingIgnoreCaseAndContractorContainingIgnoreCase(
        String userLogin,
        String category,
        String contractor,
        Pageable paging
    );

    List<Transaction> getDistinctCategoryByUserLogin(String userLogin);
}
