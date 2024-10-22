package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.List;

public class JsonConverter {

    public static String toJSON(Object object) throws JSONException, IllegalAccessException {
        String str = "";
        Class c = object.getClass();
        JSONObject jsonObject = new JSONObject();
        for (Field field : c.getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            String value = String.valueOf(field.get(object));
            jsonObject.put(name, value);
        }
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }


    public static String toJSON(List list ) throws JSONException, IllegalAccessException {
        JSONArray jsonArray = new JSONArray();
        for (Object i : list) {
            String jstr = toJSON(i);
            JSONObject jsonObject = new JSONObject(jstr);
            jsonArray.put(jsonArray);
        }
        return jsonArray.toString();
    }
}