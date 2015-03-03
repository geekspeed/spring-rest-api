package com.sitebuilder.aero.model;

import lombok.Value;

/**
 * @author pbonansea
 *
 */
@Value
public class UserLogin {
    
    private String token;
    
    private User user;
    
}
