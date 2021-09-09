package com.skimpybunnycompany.skimpybunny.api_validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface ApiTransactionsValidator {
    public List<String> getAvailableSortColumnNames();

    public void checkValidClientRequest(
        String title,
        int size,
        String sort,
        String direction,
        String category,
        String contractor,
        String dateFrom
    );

    public void checkValidClientRequestTitleSearch(Optional<String> title);

    public void checkValidClientRequestSortColumnName(String sortColumn, List<String> validColumnsNames);

    public void checkUserIsLoggedIn();

    public void checkValidClientRequestSize(int size);

    public void checkValidClientRequestSortDirection(String direction);

    public void checkValidClientRequestdateFrom(Optional<String> dateFrom);

    public List<LocalDate> getDatesFromApiQuery(String validedDates);

    public boolean checkValidApiInputDateFormat(String dates, String validPatternDateTimeFormat, List<String> validNamesOfDates);
}
