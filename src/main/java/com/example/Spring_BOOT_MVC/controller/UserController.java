package com.example.Spring_BOOT_MVC.controller;

import com.example.Spring_BOOT_MVC.model.User;
import com.example.Spring_BOOT_MVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String Users(ModelMap model) {

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";

    }

    @GetMapping(value = "/{id}")
    public String getUserByID(@PathVariable("id") Long id, Model model) {

        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping(value = "/addUser")
    public String saveUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/editUser")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PutMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
