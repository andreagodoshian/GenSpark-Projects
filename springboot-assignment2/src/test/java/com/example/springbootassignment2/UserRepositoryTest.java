package com.example.springbootassignment2;

import com.example.springbootassignment2.user.User;
import com.example.springbootassignment2.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository testRepo;

    @Test
    public void testAddNew(){
        User user1 = new User();
        user1.setEmail("daria@sicksadworld.com");
        user1.setPassword("MysticSpiral");
        user1.setFirstName("Daria");
        user1.setLastName("Morgendorffer");
        User savedUser1 = testRepo.save(user1);

        Assertions.assertNotNull(savedUser1);
        Assertions.assertTrue(savedUser1.getId() > 0);

        User user2 = new User();
        user2.setEmail("jane@sicksadworld.com");
        user2.setPassword("IsItFallYet");
        user2.setFirstName("Jane");
        user2.setLastName("Lane");
        User savedUser2 = testRepo.save(user2);

        Assertions.assertNotNull(savedUser2);
        Assertions.assertTrue(savedUser2.getId() > 0);


    }

    @Test
    public void testListAll() {
        Iterable<User> findAll = testRepo.findAll();

        Assertions.assertNotNull(findAll);

        for(User x:findAll) System.out.println(x);
    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<User> optionalUser = testRepo.findById(userId);
        User user = optionalUser.get();
        user.setPassword("LetsGetPizza");
        testRepo.save(user);

        User updatedUser = testRepo.findById(userId).get();
        Assertions.assertEquals("LetsGetPizza", updatedUser.getPassword());
    }

    @Test
    public void testGet() {
        Integer userId = 2;
        Optional<User> optionalUser = testRepo.findById(userId);

        Assertions.assertNotNull(optionalUser);
    }

    @Test
    public void testDelete() {
        Integer userId = 2;
        testRepo.deleteById(userId);

        Optional<User> optionalUser = testRepo.findById(userId);
        Assertions.assertFalse(optionalUser.isPresent());
    }
}
