package ru.haise.bootmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.haise.bootmvc.services.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UsersController {


    private UserServiceImpl service;

    @Autowired
    public void setItemsService(UserServiceImpl service) {
        this.service = service;
    }


    @GetMapping
    public  String showItems(Model model){
        model.addAttribute("users", service.getAllUsers());
        return "product_views/users";
    }
}
