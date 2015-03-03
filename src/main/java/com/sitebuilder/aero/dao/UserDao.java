package com.sitebuilder.aero.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.sitebuilder.aero.model.User;
import com.sitebuilder.aero.repository.UserRepository;

/**
 * @author pbonansea
 *
 */
@Component
public class UserDao {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MongoOperations mongoOperations;
    
    public User save(final User user) {
        
        return this.userRepository.save(user);
        
    }
    
    public User findByUserName(final String userName) {
        
        return this.mongoOperations.findOne(Query.query(Criteria.where("userName").is(userName)), 
                User.class);
        
    }
    
}
