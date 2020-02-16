package com.Lisa;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendHttp {
    public static void callMe() throws Exception{
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        URL urlObj = new URL(url);
        HttpURLConnection conObj = (HttpURLConnection)urlObj.openConnection();
        //optional default is GET
        conObj.setRequestMethod("GET");
        //add request header
        conObj.setRequestProperty("User-Agent","Maxilla/5.0");
        //get response code
        int responseCode = conObj.getResponseCode();
        System.out.println(responseCode);
        //get response data
        BufferedReader reader = new BufferedReader(new InputStreamReader(conObj.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while((inputLine = reader.readLine())!= null){
            response.append(inputLine);
        }
        reader.close();
        System.out.println(response.toString());

        //read JSON response and print
        JSONObject jsonObject = new JSONObject(response.toString());
        System.out.println(jsonObject.getString("title"));





    }
}
