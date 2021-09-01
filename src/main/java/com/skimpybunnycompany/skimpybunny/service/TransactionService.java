package com.skimpybunnycompany.skimpybunny.service;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import com.skimpybunnycompany.skimpybunny.repository.TransactionRepository;
import com.skimpybunnycompany.skimpybunny.response.TransactionResponse;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Map<String, Object> getAllTransactions(String currentUserLogin, Pageable paging, Optional<String> title) {
        Page<Transaction> transactionsPage;
        if (title.isEmpty()) {
            transactionsPage = transactionRepository.findByUserLogin(currentUserLogin, paging);
        } else {
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrContractorContainingIgnoreCase(
                    currentUserLogin,
                    title.get(),
                    title.get(),
                    title.get(),
                    paging
                );
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
}
