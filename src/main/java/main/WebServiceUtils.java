package main;

import com.google.gson.Gson;

public class WebServiceUtils {

    public static<T> String toJsonByObject(T object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
