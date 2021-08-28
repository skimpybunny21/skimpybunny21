package com.skimpybunnycompany.skimpybunny.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "transactions", schema = "app_db")
public class Transaction {

    @Id
    @Size(max = 100)
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "transaction_id", nullable = false)
    private String transactionID;

    @Size(max = 100)
    @Column(name = "user_id")
    private String userID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;

    @NotNull
    @Column(name = "transaction_date")
    private Date transactionDate;

    @NotNull
    @Column(name = "is_active")
    private Boolean isActive;

    @NotNull
    @Size(max = 200)
    @Column(name = "category")
    private String category;

    @NotNull
    @Size(max = 200)
    @Column(name = "contractor")
    private String contractor;

    public Transaction(
        String transactionID,
        String userID,
        BigDecimal amount,
        Date transactionDate,
        boolean isActive,
        String category,
        String contractor
    ) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.user = null;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isActive = isActive;
        this.category = category;
        this.contractor = contractor;
    }

    public Transaction() {}

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
