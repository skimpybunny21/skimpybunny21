package com.skimpybunnycompany.skimpybunny.web.rest;

import com.skimpybunnycompany.skimpybunny.api_validator.ApiTransactionsValidator;
import com.skimpybunnycompany.skimpybunny.api_validator.ApiTransactionsValidatorImpl;
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

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>(SecurityUtils.getCurrentUserLogin().get(), HttpStatus.OK);
    }

    @GetMapping("/test2")
    public String test2() {
        return String.valueOf(apiTransactionsValidator.getAvailableSortColumnNames());
    }

    // TODO: /transactions/ - GET
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllTransactions(
        @RequestParam(required = false) String title,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "30") int size,
        @RequestParam(defaultValue = "transaction_date") String sort,
        @RequestParam(defaultValue = "asc") String direction
    ) {
        apiTransactionsValidator.checkUserIsLoggedIn();
        String currentUserLogin = SecurityUtils.getCurrentUserLogin().get();

        apiTransactionsValidator.checkValidClientRequestSize(size);
        Pageable paging = PageRequest.of(page, size);
        apiTransactionsValidator.checkValidClientRequestSortColumnName(sort, apiTransactionsValidator.getAvailableSortColumnNames());
        String sortColumn = sort;
        apiTransactionsValidator.checkValidClientRequestSortDirection(direction);
        Sort.Direction sortDirection = direction.toLowerCase().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sortColumn);

        apiTransactionsValidator.checkValidClientRequestTitleSearch(Optional.ofNullable(title));

        Map<String, Object> response = new HashMap<>();

        response = transactionService.getAllTransactions(currentUserLogin, paging, sortBy, Optional.ofNullable(title));

        response.put("page", page);
        response.put("size", size);
        response.put("sort", sort);
        response.put("direction", direction);
        response.put("title", title);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // TODO: /transactions/{user}/{transaction_id} - PATCH, DELETE, GET
    // TODO: /transactions/{user} - PUT

}
