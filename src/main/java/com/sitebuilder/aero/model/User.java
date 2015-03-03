package com.sitebuilder.aero.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author pbonansea
 *
 */
@Document(collection = "users")
@Data
@EqualsAndHashCode(exclude = { "accounts" })
@ToString(exclude = { "accounts" })
public class User {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String name;
    
    private String lastName;
    
    private String userName;
    
    @JsonIgnore
    private String userPwd;
    
    @JsonIgnore
    private String token;
    
    @JsonIgnore
    @ManyToMany
    private Set<Account> accounts = new HashSet<Account>();

}
