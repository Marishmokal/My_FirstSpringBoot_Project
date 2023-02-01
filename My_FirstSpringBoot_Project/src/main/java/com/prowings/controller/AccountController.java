package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.exception.InvalidAccountException;
import com.prowings.model.Account;
import com.prowings.model.SavingAccount;
import com.prowings.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/account")
	public String createAccounts(@RequestBody Account account) {
		accountService.createAccounts(account);
		return "Account created";

	}

	@GetMapping("/account")
	public List<Account> getAllAccount() {

		return accountService.getAllAccount();
	}

	@GetMapping("/account/{id}")
	public SavingAccount getAccountById(@PathVariable("id") int account) {
		return accountService.getAccountById(account);
		
	}

	@PutMapping("/account/{id}")
	public ResponseEntity<String> updateAccount(@RequestBody Account account) {
		try {
			accountService.updateAccount(account);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/account/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable("id") int account) {
		try {
			accountService.deleteAccount(account);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
