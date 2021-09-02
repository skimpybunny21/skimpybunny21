package com.skimpybunnycompany.skimpybunny.web.rest;

import com.skimpybunnycompany.skimpybunny.api_validator.ApiTransactionsValidator;
import com.skimpybunnycompany.skimpybunny.api_validator.ApiTransactionsValidatorImpl;
import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import com.skimpybunnycompany.skimpybunny.security.SecurityUtils;
import com.skimpybunnycompany.skimpybunny.service.TransactionService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    @Qualifier("apiTransactionsValidatorImpl")
    ApiTransactionsValidator apiTransactionsValidator;

    // TODO: /transactions/ - GET
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllTransactions(
        @RequestParam(required = false) String title,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "30") int size,
        @RequestParam(defaultValue = "transactionDate") String sort,
        @RequestParam(defaultValue = "asc") String direction
    ) {
        apiTransactionsValidator.checkUserIsLoggedIn();
        String currentUserLogin = SecurityUtils.getCurrentUserLogin().get();

        apiTransactionsValidator.checkValidClientRequestSize(size);
        System.out.println(sort);
        apiTransactionsValidator.checkValidClientRequestSortColumnName(sort, apiTransactionsValidator.getAvailableSortColumnNames());
        String sortColumn = sort;
        apiTransactionsValidator.checkValidClientRequestSortDirection(direction);
        Sort.Direction sortDirection = direction.toLowerCase().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sortColumn);
        Pageable paging = PageRequest.of(page, size, sortBy);

        apiTransactionsValidator.checkValidClientRequestTitleSearch(Optional.ofNullable(title));

        Map<String, Object> response = new HashMap<>();

        response = transactionService.getAllTransactions(currentUserLogin, paging, Optional.ofNullable(title));

        response.put("page", page);
        response.put("size", size);
        response.put("sort", sort);
        response.put("direction", direction);
        response.put("title", title);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // TODO: /transactions/{user}/{transaction_id} - PATCH, DELETE, GET
    // TODO: /transactions/{user} - PUT

    // TODO: /transactions/categories - GET
    @GetMapping("/categories")
    public ResponseEntity<Map<String, Object>> getAllCategories() {
        apiTransactionsValidator.checkUserIsLoggedIn();
        String currentUserLogin = SecurityUtils.getCurrentUserLogin().get();

        Map<String, Object> response = new HashMap<>();
        Set<String> categories = transactionService.getAllCategories(currentUserLogin);
        response.put("total", categories.size());
        response.put("categories", categories);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    // TODO: /transactions/contractors - GET

}
