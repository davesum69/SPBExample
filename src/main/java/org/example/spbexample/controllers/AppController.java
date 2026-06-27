package org.example.spbexample.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.spbexample.beans.Item;
import org.example.spbexample.services.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/app")
public class AppController {

    @Autowired
    JsonService jsonService;

    // GET API to fetch all items
    @GetMapping("/items")
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item("A001","Tea");
        itemList.add(item);
        item = new Item("A002","Coffee");
        itemList.add(item);
        item = new Item("A003","Coke");
        itemList.add(item);
        JsonObject jo = jsonService.javaToJson(item);
        //System.out.println("Item Code: " +jo.get("itemCode"));

        Gson gson = new Gson();
        JsonArray jsonArray = gson.toJsonTree(itemList).getAsJsonArray();
        Item targetItem = jsonService.getObjectFromJsonArray(jsonArray,"A002");
        System.out.println("Item Code: " +targetItem.getItemCode()+" - "+targetItem.getItemName());
        return itemList;
    }
}
