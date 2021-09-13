package com.skimpybunnycompany.skimpybunny.service;

import com.skimpybunnycompany.skimpybunny.api_validator.ApiTransactionsValidator;
import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import com.skimpybunnycompany.skimpybunny.domain.User;
import com.skimpybunnycompany.skimpybunny.repository.TransactionInsertRepository;
import com.skimpybunnycompany.skimpybunny.repository.TransactionRepository;
import com.skimpybunnycompany.skimpybunny.repository.UserRepository;
import com.skimpybunnycompany.skimpybunny.request.TransactionRequest;
import com.skimpybunnycompany.skimpybunny.response.TransactionResponse;
import java.time.LocalDate;
import java.util.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final TransactionInsertRepository transactionInsertRepository;

    @Autowired
    @Qualifier("apiTransactionsValidatorImpl")
    private final ApiTransactionsValidator apiTransactionsValidator;

    @Autowired
    public TransactionService(
        TransactionRepository transactionRepository,
        ApiTransactionsValidator apiTransactionsValidator,
        UserRepository userRepository,
        TransactionInsertRepository transactionInsertRepository
    ) {
        this.transactionRepository = transactionRepository;
        this.apiTransactionsValidator = apiTransactionsValidator;
        this.userRepository = userRepository;
        this.transactionInsertRepository = transactionInsertRepository;
    }

    public Map<String, Object> getAllTransactions(
        String currentUserLogin,
        Pageable paging,
        Optional<String> name,
        Optional<String> category,
        Optional<String> contractor,
        Optional<String> dates
    ) {
        Page<Transaction> transactionsPage;

        /*query type 1*/if (name.isPresent() && contractor.isEmpty() && category.isEmpty() && dates.isEmpty()) {
            transactionsPage = transactionRepository.findByUserLoginAndNameContainingIgnoreCase(currentUserLogin, name.get(), paging);
        } /*query type 2*/else if (name.isEmpty() && contractor.isPresent() && category.isEmpty() && dates.isEmpty()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndContractorContainingIgnoreCase(currentUserLogin, contractor.get(), paging);
        } /*query type 3*/else if (name.isEmpty() && contractor.isEmpty() && category.isPresent() && dates.isEmpty()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndCategoryContainingIgnoreCase(currentUserLogin, category.get(), paging);
        } /*query type 4*/else if (name.isPresent() && contractor.isPresent() && category.isEmpty() && dates.isEmpty()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseAndContractorContainingIgnoreCase(
                    currentUserLogin,
                    name.get(),
                    contractor.get(),
                    paging
                );
        } /*query type 5*/else if (name.isPresent() && contractor.isEmpty() && category.isPresent() && dates.isEmpty()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(
                    currentUserLogin,
                    name.get(),
                    category.get(),
                    paging
                );
        } /*query type 6*/else if (name.isEmpty() && contractor.isPresent() && category.isPresent() && dates.isEmpty()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndContractorContainingIgnoreCaseAndCategoryContainingIgnoreCase(
                    currentUserLogin,
                    contractor.get(),
                    category.get(),
                    paging
                );
        } /*query type --7--*/else if (name.isEmpty() && contractor.isPresent() && category.isEmpty() && dates.isPresent()) {
            List<LocalDate> startEndDates = apiTransactionsValidator.getDatesFromApiQuery(dates.get());
            LocalDate startDate = startEndDates.get(0);
            LocalDate endDate = startEndDates.get(1);
            transactionsPage =
                transactionRepository.findByUserLoginAndContractorContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
                    currentUserLogin,
                    contractor.get(),
                    startDate,
                    endDate,
                    paging
                );
        } /*query type --8--*/else if (name.isEmpty() && contractor.isEmpty() && category.isPresent() && dates.isPresent()) {
            List<LocalDate> startEndDates = apiTransactionsValidator.getDatesFromApiQuery(dates.get());
            LocalDate startDate = startEndDates.get(0);
            LocalDate endDate = startEndDates.get(1);
            transactionsPage =
                transactionRepository.findByUserLoginAndCategoryContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
                    currentUserLogin,
                    category.get(),
                    startDate,
                    endDate,
                    paging
                );
        } /*query type --9--*/else if (name.isEmpty() && contractor.isEmpty() && category.isEmpty() && dates.isPresent()) {
            System.out.println(dates.get());
            System.out.println(apiTransactionsValidator.getDatesFromApiQuery(dates.get()));
            List<LocalDate> startEndDates = apiTransactionsValidator.getDatesFromApiQuery(dates.get());
            LocalDate startDate = startEndDates.get(0);
            LocalDate endDate = startEndDates.get(1);
            transactionsPage =
                transactionRepository.findByUserLoginAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
                    currentUserLogin,
                    startDate,
                    endDate,
                    paging
                );
        } /*query type --10--*/else if (name.isPresent() && contractor.isEmpty() && category.isEmpty() && dates.isPresent()) {
            List<LocalDate> startEndDates = apiTransactionsValidator.getDatesFromApiQuery(dates.get());
            LocalDate startDate = startEndDates.get(0);
            LocalDate endDate = startEndDates.get(1);
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
                    currentUserLogin,
                    name.get(),
                    startDate,
                    endDate,
                    paging
                );
        } /*query type 11*/else if (name.isPresent() && contractor.isPresent() && category.isPresent() && dates.isEmpty()) {
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseAndContractorContainingIgnoreCaseAndCategoryContainingIgnoreCase(
                    currentUserLogin,
                    name.get(),
                    contractor.get(),
                    category.get(),
                    paging
                );
        } /*query type --12--*/else if (name.isPresent() && contractor.isPresent() && category.isEmpty() && dates.isPresent()) {
            List<LocalDate> startEndDates = apiTransactionsValidator.getDatesFromApiQuery(dates.get());
            LocalDate startDate = startEndDates.get(0);
            LocalDate endDate = startEndDates.get(1);
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseAndContractorContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
                    currentUserLogin,
                    name.get(),
                    contractor.get(),
                    startDate,
                    endDate,
                    paging
                );
        } /*query type --13--*/else if (name.isPresent() && contractor.isEmpty() && category.isPresent() && dates.isPresent()) {
            List<LocalDate> startEndDates = apiTransactionsValidator.getDatesFromApiQuery(dates.get());
            LocalDate startDate = startEndDates.get(0);
            LocalDate endDate = startEndDates.get(1);
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
                    currentUserLogin,
                    name.get(),
                    category.get(),
                    startDate,
                    endDate,
                    paging
                );
        } /*query type --14--*/else if (name.isEmpty() && contractor.isPresent() && category.isPresent() && dates.isPresent()) {
            List<LocalDate> startEndDates = apiTransactionsValidator.getDatesFromApiQuery(dates.get());
            LocalDate startDate = startEndDates.get(0);
            LocalDate endDate = startEndDates.get(1);
            transactionsPage =
                transactionRepository.findByUserLoginAndContractorContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
                    currentUserLogin,
                    contractor.get(),
                    category.get(),
                    startDate,
                    endDate,
                    paging
                );
        } /*query type --15--*/else if (name.isPresent() && contractor.isPresent() && category.isPresent() && dates.isPresent()) {
            List<LocalDate> startEndDates = apiTransactionsValidator.getDatesFromApiQuery(dates.get());
            LocalDate startDate = startEndDates.get(0);
            LocalDate endDate = startEndDates.get(1);
            transactionsPage =
                transactionRepository.findByUserLoginAndNameContainingIgnoreCaseAndContractorContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(
                    currentUserLogin,
                    name.get(),
                    contractor.get(),
                    category.get(),
                    startDate,
                    endDate,
                    paging
                );
        } else { // /*query type 0*/ (name.isEmpty() && contractor.isEmpty() && category.isEmpty() && dates.isEmpty() ) {
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

    public Set<String> getAllContractors(String userLogin) {
        Set<String> contractors = new HashSet<>();
        List<Transaction> transactions = transactionRepository.getDistinctContractorByUserLogin(userLogin);
        contractors = getContractorsFromTransactions(transactions);
        return contractors;
    }

    private Set<String> getContractorsFromTransactions(List<Transaction> transactions) {
        Set<String> contractors = new HashSet<>();
        transactions
            .stream()
            .forEach(
                transaction -> {
                    contractors.add(transaction.getContractor());
                }
            );
        return contractors;
    }

    public Optional<TransactionResponse> createTransaction(TransactionRequest transactionRequest, String transactionUserLogin) {
        Transaction newTransaction = null;
        Optional<TransactionResponse> insertedTransactionResponse = null;
        Optional<User> user = userRepository.findOneByLogin(transactionUserLogin);
        if (user.isPresent()) {
            System.out.println(user.get());
            newTransaction = new Transaction(transactionRequest);
            String newTransactionID = newTransaction.getTransactionID();
            newTransaction.setUser(user.get());
            if (1 == transactionInsertRepository.saveTransaction(newTransaction)) {
                insertedTransactionResponse = Optional.of(new TransactionResponse(newTransaction));
            } else {
                insertedTransactionResponse = Optional.empty();
            }
        }
        return insertedTransactionResponse;
    }

    public String deleteTransaction(String transactionID) {
        transactionRepository.deleteById(transactionID);
        return "Transaction has been deleted successfully";
    }
}
