package com.guusto.tx.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.guusto.tx.entity.transaction_dtls;
public interface transactionRepository extends  JpaRepository<transaction_dtls,Integer> {

}
