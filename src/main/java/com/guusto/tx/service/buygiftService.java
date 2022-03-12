package com.guusto.tx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.guusto.tx.dto.balanceResponse;
import com.guusto.tx.dto.buygiftRequest;
import com.guusto.tx.dto.buygiftResponse;
import com.guusto.tx.dto.orderDetails;
import com.guusto.tx.entity.client_dtls;
import com.guusto.tx.entity.transaction_dtls;
import com.guusto.tx.repository.clientRepository;
import com.guusto.tx.repository.transactionRepository;

@Service
public class buygiftService {

	@Autowired
	private transactionRepository tranRepo;
	@Autowired
	private clientRepository clientRepo;	
	private RestTemplate restTemplate = new RestTemplate();

	@Transactional//(readOnly = false,isolation = Isolation.READ_UNCOMMITTED,propagation = Propagation.NESTED)
	public buygiftResponse buygift(buygiftRequest request) {
		
		List<transaction_dtls> translist= new ArrayList();		
		client_dtls fetchclientDtls;		
		Integer clientId =Integer.parseInt(request.getClientId());
		buygiftResponse resp = new buygiftResponse();
		try {
			
			fetchclientDtls= clientRepo.getByClientId(clientId);
			 if(fetchclientDtls == null) {
				 resp.setStatus("NOT A GUUSTO CLIENT");
					return resp;
			 }
		}catch(Exception e) {
			resp.setStatus("NOT A GUUSTO CLIENT");
			return resp;
		}
		
		List<orderDetails> orderDtls = request.getorderDetails();		
		balanceResponse obj=  restTemplate.getForObject("http://localhost:8081/guusto-service/custBalance/"+request.getClientId()+"/", balanceResponse.class);
		double bal = obj.getBalance();
		double remindBalance = 0.0;
		boolean isAvailBalance = true;
		
		for (int i = 0; i < orderDtls.size(); i++) {
			orderDetails orderdtl = orderDtls.get(i);
			if ((Double.parseDouble(orderdtl.getAmount()) * (Integer.parseInt(orderdtl.getQuantity())) > bal)) {
				isAvailBalance = false;
				break;
			} else {
				remindBalance = (bal - (Double.parseDouble(orderdtl.getAmount()) * (Integer.parseInt(orderdtl.getQuantity()))));
				bal = remindBalance;	
				transaction_dtls tranDtl = new transaction_dtls();
				tranDtl.setClientId(clientId);
				tranDtl.setGift(Integer.parseInt(orderdtl.getQuantity()));
				tranDtl.setAmount(Double.parseDouble(orderdtl.getAmount()));
				tranDtl.setBalance(remindBalance);
				tranDtl.setRemindbalance(remindBalance);
			    tranDtl.setGift(Integer.parseInt(orderdtl.getQuantity()));
			    translist.add(tranDtl);
			}
		}
		if(isAvailBalance) {
			tranRepo.saveAll(translist);
			fetchclientDtls.setBalance(bal);
			fetchclientDtls.setClientId(clientId);
			clientRepo.save(fetchclientDtls);			
			
		}
		if(!isAvailBalance) {
			resp.setStatus("No Sufficent balance to purchase the gift card");
			return resp;
		}
		resp.setStatus("SUCCESS");
		return resp;
			
		}
}
