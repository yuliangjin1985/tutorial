package com.yuliang.tutorial.basic.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BasicNet {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.le-soft.com/CheckSMSBalance");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setDoOutput(true);

        String data = "{\"userName\": \"sdfs\",\"password\": \"kjkj\"}";

        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(data.getBytes());
        outputStream.flush();

        if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpURLConnection.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (httpURLConnection.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        httpURLConnection.disconnect();
    }
}

