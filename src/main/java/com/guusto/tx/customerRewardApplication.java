package com.guusto.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.tx.dto.buygiftRequest;
import com.guusto.tx.dto.buygiftResponse;
import com.guusto.tx.service.buygiftService;

@SpringBootApplication

public class customerRewardApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(customerRewardApplication.class, args);
	}

}
