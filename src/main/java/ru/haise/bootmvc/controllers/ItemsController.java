package ru.haise.bootmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.haise.bootmvc.services.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private ItemsService itemsService;

    @Autowired
    public void setItemsService(ItemsService itemsService) {
        this.itemsService = itemsService;
    }


    @GetMapping
    public  String showItems(Model model){
        model.addAttribute("items", itemsService.getAll());
        System.out.println(itemsService.findByTitle("Knife"));
        System.out.println(itemsService.findByCostBetween(25,80));
        return "users";
    }
}
