package com.guusto.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.tx.dto.buygiftRequest;
import com.guusto.tx.dto.buygiftResponse;
import com.guusto.tx.service.buygiftService;

@RestController

public class customerRewardController {
	@Autowired
	private buygiftService service;

	@PostMapping("/guusto-service/buy-gift")
	public buygiftResponse buygift(@RequestBody buygiftRequest request){
		return service.buygift(request);
	}

}
