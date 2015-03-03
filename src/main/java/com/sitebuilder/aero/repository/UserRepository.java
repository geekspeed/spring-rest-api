package com.sitebuilder.aero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sitebuilder.aero.model.User;

/**
 * @author pbonansea
 *
 */
public interface UserRepository extends MongoRepository<User, String> {

}
