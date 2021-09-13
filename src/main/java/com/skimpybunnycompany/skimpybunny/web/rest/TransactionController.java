package com.skimpybunnycompany.skimpybunny.web.rest;

import com.skimpybunnycompany.skimpybunny.api_validator.ApiTransactionsValidator;
import com.skimpybunnycompany.skimpybunny.request.TransactionRequest;
import com.skimpybunnycompany.skimpybunny.response.TransactionResponse;
import com.skimpybunnycompany.skimpybunny.response.TransactionsResponseSchema;
import com.skimpybunnycompany.skimpybunny.security.SecurityUtils;
import com.skimpybunnycompany.skimpybunny.service.TransactionService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Transactions controller", description = "REST APIs related transactions")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    @Qualifier("apiTransactionsValidatorImpl")
    ApiTransactionsValidator apiTransactionsValidator;

    @Autowired
    public TransactionController(TransactionService transactionService, ApiTransactionsValidator apiTransactionsValidator) {
        this.transactionService = transactionService;
        this.apiTransactionsValidator = apiTransactionsValidator;
    }

    @ApiOperation(
        value = "getAllTransactions",
        notes = "Get list of transactions that match criteria query",
        response = TransactionsResponseSchema.class,
        tags = "transactions-resource"
    )
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200",
                description = "Request's OK, Optional list of transactions is in response",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionsResponseSchema.class)) }
            ),
            @ApiResponse(responseCode = "400", description = "Bad request. Try correct your query."),
        }
    )
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllTransactions(
        @ApiParam(value = "i.e. '0'  - page number of returned list of transactions. Default: '0' - first page") @RequestParam(
            defaultValue = "0"
        ) int page,
        @ApiParam(value = "i.e. '20' - page number of returned list of transactions. Default: '30' transactions.'") @RequestParam(
            defaultValue = "30"
        ) int size,
        @ApiParam(value = "default 'transactionDate' - name of column by which to sort the table") @RequestParam(
            defaultValue = "transactionDate"
        ) String sort,
        @ApiParam(value = "default 'asc' - sort direction") @RequestParam(defaultValue = "asc") String direction,
        @ApiParam(value = "'transaction name' - optional pattern for name of transaction") @RequestParam(required = false) String name,
        @ApiParam(value = "'category name' - optional pattern for category name of transaction") @RequestParam(
            required = false
        ) String category,
        @ApiParam(value = "'contractor name' - optional pattern for contractor name of transaction") @RequestParam(
            required = false
        ) String contractor,
        @ApiParam(
            value = "'dates range' - optional dates range for transaction. " +
            "Accepted: lastWeekNextWeek, lastMonthNextMonth, lastMonthNext3Months or i.e. 2021-09-01,2021-12-01"
        ) @RequestParam(required = false) String dates
    ) {
        apiTransactionsValidator.checkValidClientRequestGetTransactions(name, size, sort, direction, category, contractor, dates);

        String currentUserLogin = SecurityUtils.getCurrentUserLogin().get();
        String sortColumn = sort;
        Sort.Direction sortDirection = direction.toLowerCase().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sortColumn);
        Pageable paging = PageRequest.of(page, size, sortBy);

        Map<String, Object> response = new HashMap<>();
        response =
            transactionService.getAllTransactions(
                currentUserLogin,
                paging,
                Optional.ofNullable(name),
                Optional.ofNullable(category),
                Optional.ofNullable(contractor),
                Optional.ofNullable(dates)
            );

        response.put("queryPage", page);
        response.put("querySize", size);
        response.put("querySort", sort);
        response.put("queryDirection", direction);
        response.put("queryName", name);
        response.put("queryCategory", category);
        response.put("queryContractory", contractor);
        response.put("queryDates", dates);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // TODO: /transactions/{user}/{transaction_id} - PATCH, DELETE, GET

    @DeleteMapping("/{id}")
    public ResponseEntity<String> getTransaction(@PathVariable String id) {
        return new ResponseEntity<>(transactionService.deleteTransaction(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TransactionResponse> createTransaction(
        @Valid @RequestBody(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") TransactionRequest transactionRequest,
        @RequestParam String userLogin
    ) {
        String transactionUserLogin = userLogin != null ? userLogin : SecurityUtils.getCurrentUserLogin().get();
        Optional<TransactionResponse> transactionResponse = transactionService.createTransaction(transactionRequest, transactionUserLogin);
        if (transactionResponse.isPresent()) {
            return new ResponseEntity<>(transactionResponse.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // /api/transactions/categories - GET
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

    // /transactions/contractors - GET
    @GetMapping("/contractors")
    public ResponseEntity<Map<String, Object>> getAllContractors() {
        apiTransactionsValidator.checkUserIsLoggedIn();
        String currentUserLogin = SecurityUtils.getCurrentUserLogin().get();

        Map<String, Object> response = new HashMap<>();
        Set<String> contractors = transactionService.getAllContractors(currentUserLogin);
        response.put("total", contractors.size());
        response.put("contractors", contractors);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
