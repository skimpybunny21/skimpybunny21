package com.skimpybunnycompany.skimpybunny.api_validator;

import com.skimpybunnycompany.skimpybunny.exception.ApiRequestException;
import com.skimpybunnycompany.skimpybunny.security.SecurityUtils;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("apiTransactionsValidatorImpl")
public class ApiTransactionsValidatorImpl implements ApiTransactionsValidator {

    public ApiTransactionsValidatorImpl() {}

    public List<String> getAvailableSortColumnNames() {
        return availableSortColumnNames;
    }

    private final List<String> availableSortColumnNames = List.of("amount", "transactionDate", "isActive", "category", "contractor");

    public void checkValidClientRequestSortColumnName(String sortColumn, List<String> validColumnsNames) {
        if (!validColumnsNames.contains(sortColumn)) {
            throw new ApiRequestException(sortColumn + " column is not in available columns: " + validColumnsNames);
        }
    }

    public void checkUserIsLoggedIn() {
        if (SecurityUtils.getCurrentUserLogin().isEmpty()) {
            throw new ApiRequestException("User is not logged in.");
        }
    }

    public void checkValidClientRequestSize(int size) {
        int minSizeOfTransactionslist = 1;
        int maxSizeOfTransactionsList = 200;
        if (size < minSizeOfTransactionslist || size > maxSizeOfTransactionsList) {
            throw new ApiRequestException(
                size +
                " is not valid for size of list transactions. " +
                "Choose number between [" +
                minSizeOfTransactionslist +
                "," +
                maxSizeOfTransactionsList +
                "]"
            );
        }
    }

    public void checkValidClientRequestSortDirection(String direction) {
        if (!List.of("asc", "desc").contains(direction)) {
            throw new ApiRequestException("Sorting param should be: asc or desc. Not: " + direction);
        }
    }

    public void checkValidClientRequest(String title, int size, String sort, String direction, String category, String contractor) {
        checkUserIsLoggedIn();
        checkValidClientRequestSize(size);
        checkValidClientRequestSortColumnName(sort, getAvailableSortColumnNames());
        checkValidClientRequestSortDirection(direction);
        checkValidClientRequestTitleSearch(Optional.ofNullable(title));
        checkValidClientRequestCategorySearch(Optional.ofNullable(category));
        checkValidClientRequestContractorSearch(Optional.ofNullable(contractor));
    }

    private void checkValidClientRequestContractorSearch(Optional<String> contractor) {
        checkMaxLenghtString(contractor, maxFieldSizeContractor);
    }

    private void checkValidClientRequestCategorySearch(Optional<String> category) {
        checkMaxLenghtString(category, maxFieldSizeCategory);
    }

    public void checkValidClientRequestTitleSearch(Optional<String> title) {
        checkMaxLenghtString(title, maxFieldSizeTitle);
    }

    private int maxFieldSizeTitle = 200;
    private int maxFieldSizeCategory = 200;
    private int maxFieldSizeContractor = 200;

    private void checkMaxLenghtString(Optional<String> field, int maxFieldSize) {
        if (field.isPresent()) {
            int maxTitleSearchLenght = maxFieldSize;
            if (field.get().length() > maxTitleSearchLenght) {
                throw new ApiRequestException("Max lenght for " + field + " search is :" + maxFieldSize);
            }
        }
    }
}
