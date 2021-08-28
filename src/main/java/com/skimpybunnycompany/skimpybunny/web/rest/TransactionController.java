package com.skimpybunnycompany.skimpybunny.web.rest;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import com.skimpybunnycompany.skimpybunny.response.TransactionResponse;
import com.skimpybunnycompany.skimpybunny.service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public List<TransactionResponse> getAllTransactions() {
        List<TransactionResponse> transactionsResponse = transactionService.getAllTransactions();
        System.out.println(transactionsResponse);
        return transactionsResponse;
    }
}
