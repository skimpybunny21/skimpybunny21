package com.skimpybunnycompany.skimpybunny.apivalidator;

import com.skimpybunnycompany.skimpybunny.exception.ApiRequestException;
import com.skimpybunnycompany.skimpybunny.request.ApplicationSettingsRequest;
import com.skimpybunnycompany.skimpybunny.security.SecurityUtils;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("apiTransactionsValidatorImpl")
public class ApiTransactionsValidatorImpl implements ApiTransactionsValidator {

    private final String splitStringInApiDates = ",";

    private final List<String> validNamesOfDates = new ArrayList<String>(
        List.of("lastWeekNextWeek", "lastMonthNextMonth", "lastMonthNext3Months")
    );
    private final String validPatternDateTimeFormat = "yyyy-MM-dd";
    private final List<String> availableSortColumnNames = List.of("amount", "transactionDate", "category", "contractor");

    public ApiTransactionsValidatorImpl() {}

    public List<String> getAvailableSortColumnNames() {
        return availableSortColumnNames;
    }

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

    public void checkValidClientRequestGetTransactions(
        String title,
        int size,
        String sort,
        String direction,
        String category,
        String contractor,
        String dates
    ) {
        checkUserIsLoggedIn();
        checkValidClientRequestSize(size);
        checkValidClientRequestSortColumnName(sort, getAvailableSortColumnNames());
        checkValidClientRequestSortDirection(direction);
        checkValidClientRequestTitleSearch(Optional.ofNullable(title));
        checkValidClientRequestCategorySearch(Optional.ofNullable(category));
        checkValidClientRequestContractorSearch(Optional.ofNullable(contractor));
        checkValidClientRequestdateFrom(Optional.ofNullable(dates));
    }

    public void checkValidClientRequestdateFrom(Optional<String> dates) {
        if (dates.isPresent()) {
            if (!checkValidApiInputDateFormat(dates.get(), validPatternDateTimeFormat, validNamesOfDates)) {
                throwDatesApiException();
            }
        }
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
                throw new ApiRequestException("Max length for " + field + " search is :" + maxFieldSize);
            }
        }
    }

    private void throwDatesApiException() {
        throw new ApiRequestException(
            "'dates' should be in one of following format: " +
            "'lastWeekNextWeek', 'lastMonthNextMonth', 'lastMonthNext3Months'" +
            " 'yyyy-MM-dd,yyy-MM-dd' in example: '2021-09-01,2021-12-01'"
        );
    }

    public List<LocalDate> getDatesFromApiQuery(String dates) {
        LocalDate startDate = null;
        LocalDate endDate = null;

        if (getValidNamesOfDates().contains(dates)) { // dates given in name i.e. lastWeekNextWeek
            switch (dates) {
                case "lastWeekNextWeek":
                    {
                        startDate = LocalDate.now().minusDays(7);
                        endDate = LocalDate.now().plusDays(7);
                    }
                case "lastMonthNext3Months":
                    {
                        startDate = LocalDate.now().minusMonths(1);
                        endDate = LocalDate.now().plusMonths(1);
                    }
                default:
                    { // lastMonthNextMonth
                        startDate = LocalDate.now().minusDays(7);
                        endDate = LocalDate.now().plusMonths(1);
                    }
            }
        } else { // expected dates format in: '2021-09-01,2021-12-01'
            List<String> splitDatesList = splitDates(dates, splitStringInApiDates);
            String startDateInput = splitDatesList.get(0);
            String endDateInput = splitDatesList.get(1);
            startDate = LocalDate.parse(startDateInput, DateTimeFormatter.ofPattern(validPatternDateTimeFormat));
            endDate = LocalDate.parse(endDateInput, DateTimeFormatter.ofPattern(validPatternDateTimeFormat));
            //            endDate = LocalDate.from(validPatternDateTimeFormat.parse(endDateInput));
        }
        return new ArrayList<>(List.of(startDate, endDate));
    }

    public boolean checkValidApiInputDateFormat(String dates, String validPatternDateTimeFormat, List<String> validNamesOfDates) {
        if (validNamesOfDates.contains(dates)) {
            return true;
        } else {
            if (!dates.contains(splitStringInApiDates)) {
                return false;
            }
            List<String> splitDatesList = splitDates(dates, splitStringInApiDates);
            String startDateInput = splitDatesList.get(0);
            String endDateInput = splitDatesList.get(1);

            if (
                checkValidDateFormat(startDateInput, validPatternDateTimeFormat) &&
                checkValidDateFormat(endDateInput, validPatternDateTimeFormat)
            ) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean checkValidDateFormat(String date, String validPatternDateTimeFormat) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(validPatternDateTimeFormat);
        try {
            LocalDate.from(dateFormatter.parse(date));
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    private List<String> splitDates(String dates, String splitString) throws IllegalArgumentException {
        String[] splitDates = dates.split(splitString);
        if (splitDates.length != 2) {
            throwIllegalArgumentExceptionBecauseOfWrongDateFormat(dates);
        }
        String startDateInput = splitDates[0];
        String endDateInput = splitDates[1];
        return new ArrayList<String>(Arrays.asList(startDateInput, endDateInput));
    }

    private void throwIllegalArgumentExceptionBecauseOfWrongDateFormat(String dates) {
        throw new IllegalArgumentException("expected dates in format: '2021-09-01,2021-12-01' - given: " + dates);
    }

    public String getSplitStringInApiDates() {
        return splitStringInApiDates;
    }

    public List<String> getValidNamesOfDates() {
        return validNamesOfDates;
    }

    public String getValidPatternDateTimeFormat() {
        return validPatternDateTimeFormat;
    }
}
