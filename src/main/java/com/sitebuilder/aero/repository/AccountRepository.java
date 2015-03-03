package com.sitebuilder.aero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sitebuilder.aero.model.Account;

/**
 * @author pbonansea
 *
 */
public interface AccountRepository extends MongoRepository<Account, String> {

}
