package com.prowings.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.prowings.dao.AccountDao;
import com.prowings.model.Account;
import com.prowings.model.SavingAccount;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDao dao;
	@Autowired
	DozerBeanMapper mapper;

	@Override
	public void createAccounts(Account account) {
		dao.save(account);
		
	}

	@Override
	public List<Account> getAllAccount() {
		
		return dao.findAll();
	}

//	@Override
//	public Account getAccountById(int account) {
//		
//		return dao.findById(account).get();
//	}

	public SavingAccount getAccountById(int account)
	{
	
		Account acc=dao.findById(account).get();
		System.out.println(acc);
		SavingAccount sav=new SavingAccount();
		mapper.map(acc,sav);
		System.out.println(sav);
		return sav;
		
		
		
	}
	
	@Override
	public void updateAccount(Account account) {
		Account acc=dao.findById(account.getAccountNo()).orElseThrow(null);
		dao.save(account);
		
	}

	@Override
	public void deleteAccount(int account) {
		try {
			dao.deleteById(account);
		}catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
		}
		
	


	

	


	

	

	

}
