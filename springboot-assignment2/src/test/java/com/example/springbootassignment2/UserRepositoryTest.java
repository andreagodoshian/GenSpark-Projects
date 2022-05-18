package com.example.springbootassignment2;

import com.example.springbootassignment2.user.User;
import com.example.springbootassignment2.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository testRepo;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("daria@sicksadworld.com");
        user.setPassword("MysticSpiral");
        user.setFirstName("Daria");
        user.setLastName("Morgendorffer");

        User savedUser = testRepo.save(user);
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getId() > 0);

    }
}
