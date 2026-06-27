package org.example.spbexample.services;

import org.example.spbexample.beans.Item;
import org.springframework.stereotype.Service;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.Gson;

@Service
public class JsonService {
    public String convertJsonToString(JsonObject jsonObject){
        // 1. String to JSON Object
        //JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

// 2. JSON Object to String
        String outputString = new Gson().toJson(jsonObject);
        return outputString;
    }
    public String convertJsonToString(JsonArray jsonArray){
        // Convert JSON Array to String
        String outputString = new Gson().toJson(jsonArray);
        return outputString;
    }
    public JsonObject convertStringToJson(String json){
        // 1. String to JSON Object
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

// 2. JSON Object to String
        //String outputString = new Gson().toJson(jsonObject);
        return jsonObject;
    }

    public JsonObject javaToJson(Item item){

        Gson gson = new Gson();
        //JsonArray jsonArray = gson.toJsonTree(itemList).getAsJsonArray();
        //String output = jsonService.convertJsonToString(jsonArray);
        JsonObject jsonObject = gson.toJsonTree(item).getAsJsonObject();
        //String output = convertJsonToString(jsonObject);
        //System.out.println("Output: " + output);
        return jsonObject;
    }

    public Item getObjectFromJsonArray(JsonArray jsonArray, String value) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            if (jsonObject.get("itemCode").getAsString().equals(value)) {
                Gson gson = new Gson();
                Item item = gson.fromJson(jsonObject, Item.class);
                return item;
            }
        }
        return null;
    }

}
