package com.sitebuilder.aero.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sitebuilder.aero.model.User;
import com.sitebuilder.aero.model.UserLogin;
import com.sitebuilder.aero.service.UserService;
import com.sitebuilder.aero.transfer.UserLoginStruct;

/**
 * @author pbonansea
 *
 */
@RestController
@RequestMapping("/user")  
public class UserResource {

    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @Transactional
    public @ResponseBody UserLogin login(@RequestBody final UserLoginStruct userLogin, 
            HttpServletResponse  response) {
        
        if (userLogin.getUserName().equals("")) {
            throw new IllegalArgumentException("User name should not be null");
        }

        if (userLogin.getUserPwd().equals("")) {
            throw new IllegalArgumentException("User password should not be null");
        }

        User user = userService.login(userLogin.getUserName(), userLogin.getUserPwd());
                
        response.setHeader("X-Auth-Token", user.getToken());
        
        return new UserLogin(user.getToken(), user);
        
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @Transactional
    public @ResponseBody User save(@RequestBody final User user) {
                
        User userCreated = this.userService.save(user);
        
        return userCreated;
        
    }
    
    
}
