package com.skimpybunnycompany.skimpybunny.response;

import static tech.jhipster.config.JHipsterDefaults.ApiDocs.description;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Transaction model in returned list of transactions", value = "TransactionResponse")
@Getter
@Setter
@ToString
public class TransactionResponse {

    @ApiModelProperty(value = "Unique guid", position = 1, example = "7aaee0e2-6884-4fd7-ba63-21d76723dce2")
    private String id;

    /* uncomment if User object is needed in TransactionResponse to Client,
     * otherwise it's not needed. */
    //    private User user;
    @ApiModelProperty(value = "Name for transaction", position = 2, example = "purchase of a washing machine")
    private String name;

    @ApiModelProperty(value = "Amount for transaction", position = 3, example = "1199.99")
    private BigDecimal amount;

    @ApiModelProperty(value = "transaction date", position = 2, example = "2021-09-01")
    private LocalDate transactionDate;

    @ApiModelProperty(value = "is transaction shown in calculations (future feature)", position = 2, example = "true")
    private Boolean isActive;

    @ApiModelProperty(value = "category for transaction", position = 2, example = "home")
    private String category;

    @ApiModelProperty(value = "contractor for transaction", position = 2, example = "MediaExpert")
    private String contractor;

    public TransactionResponse(Transaction t) {
        this.id = t.getTransactionID();

        /* uncomment if User object is needed in TransactionResponse to Client,
         * otherwise it's not needed. */
        //        this.user = t.getUser();
        this.name = t.getName();
        this.amount = t.getAmount();
        this.transactionDate = t.getTransactionDate();
        this.isActive = t.getActive();
        this.category = t.getCategory();
        this.contractor = t.getContractor();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /* uncomment if User object is needed in TransactionResponse to Client,
     * otherwise it's not needed. */
    //    public User getUser() {
    //        return user;
    //    }
    //
    //    public void setUser(User user) {
    //        this.user = user;
    //    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
