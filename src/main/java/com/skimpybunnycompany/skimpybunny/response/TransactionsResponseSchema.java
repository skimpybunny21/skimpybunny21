package com.skimpybunnycompany.skimpybunny.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*purpose of this class is just as schema of /api/transactions response schema description */
@ApiModel(description = "Schema of response for request from GET: /api/transactions", value = "TransactionResponseSchema")
@Getter
@Setter
@ToString
public class TransactionsResponseSchema {

    @ApiModelProperty(value = "total number of returned transactions", position = 1, example = "129")
    private int totalItems;

    @ApiModelProperty(value = "current returned page, 0 - for first page", position = 2, example = "0")
    private int currentPage;

    @ApiModelProperty(value = "total number of pages", position = 3, example = "4")
    private int totalPages;

    @ApiModelProperty(value = "list of returned transactions for current page", position = 4, example = "[...]")
    List<TransactionResponse> transactions;

    @ApiModelProperty(value = "returned value of page param for this query", position = 5, example = "4")
    private int queryPage;

    @ApiModelProperty(value = "returned value of size param for this query", position = 6, example = "30")
    private int querySize;

    @ApiModelProperty(value = "returned value of dates param for this query", position = 7, example = "lastWeekNext3Months")
    private String queryDates;

    @ApiModelProperty(value = "returned value of direction (for sort) param for this query", position = 8, example = "asc")
    private String queryDirection;

    @ApiModelProperty(value = "returned value of name param for this query", position = 9, example = " ")
    private String queryName;

    @ApiModelProperty(value = "returned value of sort param for this query", position = 10, example = "transactionDate")
    private String querySort;

    @ApiModelProperty(value = "returned value of category param for this query", position = 11, example = "home")
    private String queryCategory;

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<TransactionResponse> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionResponse> transactions) {
        this.transactions = transactions;
    }

    public int getQueryPage() {
        return queryPage;
    }

    public void setQueryPage(int queryPage) {
        this.queryPage = queryPage;
    }

    public int getQuerySize() {
        return querySize;
    }

    public void setQuerySize(int querySize) {
        this.querySize = querySize;
    }

    public String getQueryDates() {
        return queryDates;
    }

    public void setQueryDates(String queryDates) {
        this.queryDates = queryDates;
    }

    public String getQueryDirection() {
        return queryDirection;
    }

    public void setQueryDirection(String queryDirection) {
        this.queryDirection = queryDirection;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getQuerySort() {
        return querySort;
    }

    public void setQuerySort(String querySort) {
        this.querySort = querySort;
    }

    public String getQueryCategory() {
        return queryCategory;
    }

    public void setQueryCategory(String queryCategory) {
        this.queryCategory = queryCategory;
    }

    public String getQueryContractor() {
        return queryContractor;
    }

    public void setQueryContractor(String queryContractor) {
        this.queryContractor = queryContractor;
    }

    @ApiModelProperty(value = "returned value of contractor param for this query", position = 12, example = "mediaexpert")
    private String queryContractor;

    public TransactionsResponseSchema() {}
}
