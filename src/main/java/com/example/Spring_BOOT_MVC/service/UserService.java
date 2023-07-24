package com.example.Spring_BOOT_MVC.service;



import com.example.Spring_BOOT_MVC.model.User;

import java.util.List;

public interface UserService {
    public void add(User user);

    void updateUser( Long id, User user);

    public void deleteUser(Long id);

    public User getUserById(Long id);

    public List<User> getAllUsers();
}
