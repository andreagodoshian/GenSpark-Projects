package com.example.springbootassignment2.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer> {

}
