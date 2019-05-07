package main;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class Consumer {

    //HACER EL POST REQUEST
    public static String POSTrequest(String url, String json) throws IOException {
        URL page = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) page.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        String query = json;

        OutputStream os = connection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

        writer.write(query);
        writer.flush();

        InputStream is = connection.getInputStream();
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = is.read(buffer)) != -1) {
            bytes.write(buffer, 0, bytesRead);
        }
        is.close();
        writer.close();
        os.close();
        connection.disconnect();

        return new String(bytes.toByteArray(), "UTF-8");
    }
    
}

