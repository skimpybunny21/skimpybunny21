package com.skimpybunnycompany.skimpybunny.repository;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int saveTransaction(Transaction newTransaction) {
        return entityManager
            .createNativeQuery(
                "INSERT INTO app_db.transactions (" +
                "transaction_id, " +
                "user_id, " +
                "name, " +
                "amount, " +
                "transaction_date, " +
                "is_active, " +
                "category, " +
                "contractor) " +
                "values (?,?,?,?,?,?,?,?)"
            )
            .setParameter(1, newTransaction.getTransactionID())
            .setParameter(2, newTransaction.getUser().getId())
            .setParameter(3, newTransaction.getName())
            .setParameter(4, newTransaction.getAmount())
            .setParameter(5, newTransaction.getTransactionDate())
            .setParameter(6, newTransaction.getActive())
            .setParameter(7, newTransaction.getCategory())
            .setParameter(8, newTransaction.getContractor())
            .executeUpdate();
    }

    @Transactional
    public int updateTransaction(Transaction newTransaction) {
        return entityManager
            .createNativeQuery(
                "UPDATE app_db.transactions SET " +
                "name = ?," +
                "amount = ?," +
                "transaction_date = ?, " +
                "is_active = ?," +
                "category = ?, " +
                "contractor = ? " +
                "WHERE transaction_id = ?"
            )
            .setParameter(1, newTransaction.getName())
            .setParameter(2, newTransaction.getAmount())
            .setParameter(3, newTransaction.getTransactionDate())
            .setParameter(4, newTransaction.getActive())
            .setParameter(5, newTransaction.getCategory())
            .setParameter(6, newTransaction.getContractor())
            .setParameter(7, newTransaction.getTransactionID())
            .executeUpdate();
    }
}
