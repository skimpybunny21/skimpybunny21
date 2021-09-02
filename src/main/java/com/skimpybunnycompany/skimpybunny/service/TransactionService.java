package com.skimpybunnycompany.skimpybunny.service;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import com.skimpybunnycompany.skimpybunny.repository.TransactionRepository;
import com.skimpybunnycompany.skimpybunny.response.TransactionResponse;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Map<String, Object> getAllTransactions(
        String currentUserLogin,
        Pageable paging,
        Optional<String> title,
        Optional<String> category,
        Optional<String> contractor
    ) {
        Page<Transaction> transactionsPage;
        if (title.isPresent() && contractor.isEmpty() && category.isEmpty()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrContractorContainingIgnoreCase(
                    currentUserLogin,
                    title.get(),
                    title.get(),
                    title.get(),
                    paging
                );
        } else if (title.isEmpty() && contractor.isPresent() && category.isEmpty()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndContractorContainingIgnoreCase(currentUserLogin, contractor.get(), paging);
        } else if (title.isEmpty() && contractor.isEmpty() && category.isPresent()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndCategoryContainingIgnoreCase(currentUserLogin, category.get(), paging);
        } else if (title.isPresent() && contractor.isPresent() && category.isEmpty()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrContractorContainingIgnoreCase(
                    currentUserLogin,
                    title.get(),
                    title.get(),
                    contractor.get(),
                    paging
                );
        } else if (title.isEmpty() && contractor.isPresent() && category.isPresent()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndCategoryContainingIgnoreCaseAndContractorContainingIgnoreCase(
                    currentUserLogin,
                    category.get(),
                    contractor.get(),
                    paging
                );
        } else if (title.isPresent() && contractor.isEmpty() && category.isPresent()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrContractorContainingIgnoreCase(
                    currentUserLogin,
                    title.get(),
                    category.get(),
                    contractor.get(),
                    paging
                );
        } else if (title.isPresent() && contractor.isPresent() && category.isPresent()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrContractorContainingIgnoreCase(
                    currentUserLogin,
                    title.get(),
                    category.get(),
                    contractor.get(),
                    paging
                );
        } else { // (title.isEmpty() && contractor.isEmpty() && category.isEmpty()) {
            transactionsPage = transactionRepository.findByUserLogin(currentUserLogin, paging);
        }
        return prepareTransactionsResponse(transactionsPage);
    }

    private Map<String, Object> prepareTransactionsResponse(Page<Transaction> transactionsPage) {
        List<TransactionResponse> transactionsResponse = new ArrayList<TransactionResponse>();
        transactionsPage
            .getContent()
            .stream()
            .forEach(
                transaction -> {
                    transactionsResponse.add(new TransactionResponse((transaction)));
                }
            );

        Map<String, Object> response = new HashMap<>();
        response.put("transactions", transactionsResponse);
        response.put("currentPage", transactionsPage.getNumber());
        response.put("totalPages", transactionsPage.getTotalPages());
        response.put("totalItems", transactionsPage.getTotalElements());
        return response;
    }

    public Set<String> getAllCategories(String userLogin) {
        Set<String> categories = new HashSet<>();
        List<Transaction> transactions = transactionRepository.getDistinctCategoryByUserLogin(userLogin);
        categories = getCategoriesFromTransactions(transactions);
        return categories;
    }

    private Set<String> getCategoriesFromTransactions(List<Transaction> transactions) {
        Set<String> categories = new HashSet<>();
        transactions
            .stream()
            .forEach(
                transaction -> {
                    categories.add(transaction.getCategory());
                }
            );
        return categories;
    }
}
