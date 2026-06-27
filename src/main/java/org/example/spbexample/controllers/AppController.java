package org.example.spbexample.controllers;

import org.example.spbexample.beans.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/app")
public class AppController {
    // GET API to fetch all items
    @GetMapping("/items")
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item("A001","Tea");
        itemList.add(item);
        return itemList;
    }
}
