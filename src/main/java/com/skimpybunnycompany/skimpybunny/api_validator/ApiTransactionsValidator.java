package com.skimpybunnycompany.skimpybunny.api_validator;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface ApiTransactionsValidator {
    public List<String> getAvailableSortColumnNames();

    public void checkValidClientRequest(String title, int size, String sort, String direction, String category, String contractor);

    public void checkValidClientRequestTitleSearch(Optional<String> title);

    public void checkValidClientRequestSortColumnName(String sortColumn, List<String> validColumnsNames);

    public void checkUserIsLoggedIn();

    public void checkValidClientRequestSize(int size);

    public void checkValidClientRequestSortDirection(String direction);
}
