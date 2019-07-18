package com.qa.rest;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.qa.exceptions.AccountNotFoundException;
import com.qa.persistence.domain.Account;
import com.qa.service.AccountService;

@Path("/account")
public class AccountController {

	@Inject
	private AccountService service;

	@GET
	@Path("/getAll")
	public String getAllAccounts() {
		return this.service.getAllAccounts();
	}
	
	@POST
	@Path("/createAcc")
	public String createAccount(String account) {
		return this.service.createAccount(account);
	};
	
	@POST
	@Path("/delAcc") 
	public String deleteAccount(int accountId) throws AccountNotFoundException {
		return this.deleteAccount(accountId);
	};

	@POST
	@Path("/updAcc")
	public String updateAccount(int accountId, String account) throws AccountNotFoundException{
		return this.service.updateAccount(accountId, account);
	};

	@GET
	@Path("/findAcc")
	public List<Account> findAccountsByFirstName(String firstName) {
		return this.service.findAccountsByFirstName(firstName);
	}

}

