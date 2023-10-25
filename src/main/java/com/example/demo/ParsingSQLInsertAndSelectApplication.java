package com.example.demo;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.jsqlparser.JSQLParserException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ParsingSQLInsertAndSelectApplication {

//    public String parse(String jsonLine) {
//        JsonElement jelement = new JsonParser().parse(jsonLine);
//        JsonObject  jobject = jelement.getAsJsonObject();
//        jobject = jobject.getAsJsonObject("types");
//        JsonArray jarray = jobject.getAsJsonArray("typeId");
//        jobject = jarray.get(0).getAsJsonObject();
//        String result = jobject.get("translatedText").getAsString();
//        return result;
//    }



    public static void main(String[] args) throws JSQLParserException, ParseException {
        SpringApplication.run(ParsingSQLInsertAndSelectApplication.class, args);

        String jsonString = "{\"adapterId\":\"68ebde59-c7a4-4dc0-b40e-c7af3ed6f913\",\"clientId\":7," +
                "\"monitoringSystemId\":\"c7538031-b730-4933-ac12-f7be57718c1f\",\"createAllWithTheSameName\":false," +
                "\"types\":" +
                    "[{\"create\":true,\"allEntities\":false,\"allParams\":false,\"typeId\":1,\"entityIds\":[561117],\"paramIds\":[]}," +
                    "{\"create\":false,\"allEntities\":false,\"allParams\":false,\"typeId\":10,\"entityIds\":[],\"paramIds\":[]}" +
                    ",{\"create\":true,\"allEntities\":false,\"allParams\":false,\"typeId\":2,\"entityIds\":[561211],\"paramIds\":[]}," +
                    "{\"create\":false,\"allEntities\":false,\"allParams\":false,\"typeId\":13,\"entityIds\":[],\"paramIds\":[]}," +
                    "{\"create\":false,\"allEntities\":true,\"allParams\":false,\"typeId\":5,\"paramIds\":[]}," +
                    "{\"create\":true,\"allEntities\":false,\"allParams\":false,\"typeId\":3,\"entityIds\":[578096,578102,578113,578114],\"paramIds\":[]}," +
                    "{\"create\":false,\"allEntities\":true,\"allParams\":false,\"typeId\":11,\"paramIds\":[]}," +
                    "{\"create\":true,\"allEntities\":true,\"allParams\":false,\"typeId\":4,\"paramIds\":[]}]," +
                "\"addMetricsAsProperties\":true,\"owner\":{\"clientId\":7,\"name\":\"тест_автосоздание_2023-10-24--13-13\"," +
                "\"elementId\":560}}";
        JsonParser parser = new JsonParser();
        System.out.println(parser.parse(jsonString));

        JSONObject json = (JSONObject)new JSONParser().parse(jsonString);

        System.out.println("owner=" + json.get("owner"));

        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();



        String myPageName = jsonObject.getAsJsonObject("owner").get("name").getAsString();  //.getAsMyString()

        System.out.println(myPageName);





































    }
}
