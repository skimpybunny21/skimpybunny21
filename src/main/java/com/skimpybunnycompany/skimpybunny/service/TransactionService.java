package com.skimpybunnycompany.skimpybunny.service;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import com.skimpybunnycompany.skimpybunny.repository.TransactionRepository;
import com.skimpybunnycompany.skimpybunny.response.TransactionResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public List<TransactionResponse> getAllTransactions() {
        List<Transaction> transactionList = transactionRepository.findAll();
        List<TransactionResponse> transactionsResponse = new ArrayList<TransactionResponse>();
        transactionList
            .stream()
            .forEach(
                transaction -> {
                    transactionsResponse.add(new TransactionResponse((transaction)));
                }
            );
        return transactionsResponse;
    }
}
