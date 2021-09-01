package com.skimpybunnycompany.skimpybunny.response;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import com.skimpybunnycompany.skimpybunny.domain.User;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionResponse {

    private String id;
    private User user;
    private BigDecimal amount;
    private Date transactionDate;
    private Boolean isActive;
    private String category;
    private String contractor;

    public TransactionResponse(Transaction t) {
        this.id = t.getTransactionID();
        this.user = t.getUser();
        this.amount = t.getAmount();
        this.transactionDate = t.getTransactionDate();
        this.isActive = t.getActive();
        this.category = t.getCategory();
        this.contractor = t.getContractor();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
