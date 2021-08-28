package com.skimpybunnycompany.skimpybunny.repository;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    @Override
    default List<Transaction> findAll() {
        Transaction t1 = new Transaction("id_1", "user1", new BigDecimal(100), new Date(), true, "mieszkanie", "spoldzielnia");

        Transaction t2 = new Transaction("id_2", "user1", new BigDecimal(50), new Date(), true, "zakupy", "Lidl");

        List<Transaction> returnList = new ArrayList<>();
        returnList.add(t1);
        returnList.add(t2);
        return returnList;
    }
}
