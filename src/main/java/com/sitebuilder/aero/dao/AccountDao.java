package com.sitebuilder.aero.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sitebuilder.aero.model.Account;
import com.sitebuilder.aero.repository.AccountRepository;

/**
 * @author pbonansea
 *
 */
@Component
public class AccountDao {

    @Autowired
    private AccountRepository accountRepository;
    
    public Account findById(final String id) {
        
        return this.accountRepository.findOne(id);
        
    }
    
    
}
