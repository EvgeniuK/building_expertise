package com.example.tms.building_expertise.controllers;

import com.example.tms.building_expertise.domain_db.Role;
import com.example.tms.building_expertise.domain_db.User;
import com.example.tms.building_expertise.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/user")
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }


    @GetMapping("/user/{id}")
    public String userListDetalis(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userList-edit";

    }

}
