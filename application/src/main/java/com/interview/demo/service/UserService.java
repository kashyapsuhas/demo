package com.interview.demo.service;//package com.interview.demo.service;

import com.interview.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Boolean addUser(User user);
    User getUserById(String id);
    Optional<User> getUserByUserName(String username);
    List<User> getAllUsers();
    User updateUser(User user);
    User deleteUser(String id);
}
