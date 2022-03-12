package com.guusto.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guusto.tx.entity.client_dtls;


public interface clientRepository extends  JpaRepository<client_dtls,Integer> {

	public client_dtls getByClientId(Integer clientId);

}
