package com.example.springbootassignment2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User get(Integer id) throws Exception {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) return result.get();
        else throw new Exception("Couldn't find user!");
    }


}
