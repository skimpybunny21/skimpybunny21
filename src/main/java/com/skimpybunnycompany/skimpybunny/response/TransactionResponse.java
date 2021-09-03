package com.skimpybunnycompany.skimpybunny.response;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionResponse {

    private String id;

    /* uncomment if User object is needed in TransactionResponse to Client,
     * otherwise it's not needed. */
    //    private User user;
    private String name;
    private BigDecimal amount;
    private ZonedDateTime transactionDate;
    private Boolean isActive;
    private String category;
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

    public ZonedDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(ZonedDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
