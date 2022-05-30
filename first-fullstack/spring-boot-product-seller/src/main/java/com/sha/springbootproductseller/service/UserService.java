package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.Role;
import com.sha.springbootproductseller.model.User;

import java.util.Optional;

// service layer doesn't extend JpaRepository, so need to define!!
// interface encapsulates!!!

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:22
 */
public interface UserService
{
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
