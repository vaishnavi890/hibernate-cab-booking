package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.UserNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.User;
import com.vaishnavi.hibernate.cab.booking.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepositoryImpl userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User deleteUser(int id) {
        return userRepository.deleteById(id);
    }

    public User retrieveUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        return user.get();
    }

    public List<User> retrieveUsers() {
        return userRepository.findAll();
    }


    public User getUserById(int userId) {
        return null;
    }

    public List<User> getAllUsers() {
        return List.of();
    }
}


