package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(value = TxType.SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {
	
	@PersistenceContext(unitName = "primary")
    private EntityManager em;
	@Inject
	private JSONUtil util;
	
	public String getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT A FROM Account A", Account.class);
		System.out.println(query.getResultList());
		return SUCCESS;
	}

	
	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		em.persist(aAccount);
		return "{\"message\": \"movie sucessfully added\"}";
	}

	public Account findAccount(Long id) {
        return em.find(Account.class, id);
    }

	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(int accountNumber) {
		Account toRem = em.find(Account.class, accountNumber);
		em.remove(toRem);
		return SUCCESS;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(int accountNumber, String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		Account existing = em.find(Account.class, accountNumber);
		existing.setId(aAccount.getId());
		existing.setAccountNumber(aAccount.getAccountNumber());
		existing.setFirstName(aAccount.getFirstName());
		existing.setLastName(aAccount.getLastName());
		em.persist(existing);	
		return SUCCESS;
	}
}
