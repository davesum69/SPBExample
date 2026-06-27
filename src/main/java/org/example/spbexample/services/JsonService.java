package org.example.spbexample.services;

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
}
