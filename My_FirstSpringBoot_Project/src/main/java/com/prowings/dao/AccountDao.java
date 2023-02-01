package com.prowings.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prowings.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account,Integer>  {

	

	

	

}
