package com.skimpybunnycompany.skimpybunny.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Transactions", schema = "app_db")
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
}
