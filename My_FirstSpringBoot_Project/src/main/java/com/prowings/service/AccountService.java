package com.prowings.service;

import java.util.List;

import com.prowings.model.Account;
import com.prowings.model.SavingAccount;

public interface AccountService {

	public void createAccounts(Account account);

	public List<Account> getAllAccount();

	//public Account getAccountById(int account);
	SavingAccount getAccountById(int account);

	public void updateAccount(Account account);

	public void deleteAccount(int account);

	





	


}
