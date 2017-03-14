package com.safinterview.net;

import java.io.IOException;

/**
 * Created by victor on 3/14/2017.
 */
public class DataSender {

    public void getKey() {
        String url = "http://2a1ba6a5.ngrok.io/TestWebService/TestWS?wsdl";
        String query = new URLBuilder(url).append("getKey", "getKey").append("name", "red").getQuery();
        HttpExecutor httpExecutor = new HttpExecutor(url, query);
        try {
            String response = httpExecutor.doGetHttpRequest();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void register(String name, String nationalId, String mobile, String hiddenKey) {

    }
}
