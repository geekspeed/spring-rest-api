package com.sitebuilder.aero.service;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.encoder.ByteArrayUtil;

import com.sitebuilder.aero.dao.AccountDao;
import com.sitebuilder.aero.dao.UserDao;
import com.sitebuilder.aero.exception.AuthenticationException;
import com.sitebuilder.aero.model.Account;
import com.sitebuilder.aero.model.User;

/**
 * @author pbonansea
 *
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private AccountDao accountDao;
    
    @Override
    public User login(final String userName, final String userPwd) throws AuthenticationException {
        
        User user = this.userDao.findByUserName(userName);
        
        if (user == null 
                || !encryptPassword(userPwd).equals(user.getUserPwd())) {
            throw new AuthenticationException("User name or password incorrect");
        }

        String token = UUID.randomUUID().toString();        
        user.setToken(token);
        
        this.userDao.save(user);
                
        return user;
    
    }

    @Override
    public User save(User user) {
                
        if (this.userDao.findByUserName(user.getUserName()) == null) {

            user.setUserPwd(encryptPassword("12345"));        

            Account account = this.accountDao.findById("54e5e1c364a71bdee7701816");
            
            if (account != null) {
                // account.getUsers().add(user);
                user.getAccounts().add(account);            
            }

            return this.userDao.save(user);
            
        }
        
        return null;
 
    }

    /**
     * Method that encrypt the user password using the algorithm MD5.
     *
     * @param password User password
     * @return String Encrypt password
     */
    private String encryptPassword(final String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes(Charset.forName("UTF-8")));

            byte[] byteData = md.digest();

            return ByteArrayUtil.toHexString(byteData);

        } catch (NoSuchAlgorithmException | NullPointerException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    
}
