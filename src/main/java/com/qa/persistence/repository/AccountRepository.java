package com.qa.persistence.repository;

public interface AccountRepository {
	final String SUCCESS = "Operation succeeded";
	final String FAILURE = "Operation failure ";

	String getAllAccounts();

	String createAccount(String account);

	String deleteAccount(int accountNumber);

	String updateAccount(int accountNumber, String account);

}
