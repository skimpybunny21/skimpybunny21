package com.skimpybunnycompany.skimpybunny.web.rest;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import com.skimpybunnycompany.skimpybunny.service.TransactionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    TransactionService transactionService;

    @GetMapping("getAll")
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactionList = transactionService.getAllTransactions();
        return transactionList;
    }
}
