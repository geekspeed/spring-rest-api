package com.sitebuilder.aero.service;

import com.sitebuilder.aero.exception.AuthenticationException;
import com.sitebuilder.aero.model.User;

/**
 * @author pbonansea
 *
 */
public interface UserService {

    User login(String userName, String userPwd) throws AuthenticationException;
 
    User save(User user);
    
}
