package com.qa;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class App {

	public static void main(String[] args) {
		JSONUtil json = new JSONUtil();
		Account test = new Account(1, "adc123", "Scoot", "Pacino");
//		System.out.println(json.getJSONForObject(test));
		
		AccountMapRepository amr = new AccountMapRepository();
		System.out.println(amr.createAccount(json.getJSONForObject(test)));
		amr.getAccountFirstName("Scoot");
		
		
		
	}

}
