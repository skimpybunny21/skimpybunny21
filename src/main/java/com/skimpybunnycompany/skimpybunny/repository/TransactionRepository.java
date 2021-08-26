package com.skimpybunnycompany.skimpybunny.repository;

import com.skimpybunnycompany.skimpybunny.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {}
