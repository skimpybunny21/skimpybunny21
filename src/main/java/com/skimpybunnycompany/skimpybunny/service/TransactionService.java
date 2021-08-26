package com.skimpybunnycompany.skimpybunny.service;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import com.skimpybunnycompany.skimpybunny.repository.TransactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
