package Lecture2_StringReflect_ReadFromServer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Server1 {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://lingualeo.com/ru/glossary/learn/dictionary");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            urlConnection.setRequestMethod("GET");
            InputStream answer = urlConnection.getInputStream();
            int size = answer.available();
            byte [] bytes = new byte[size];
            answer.read(bytes);
            String concreateAnswer = new String(bytes);
            System.out.println(concreateAnswer);

            File lingvaLeo = new File(System.getProperty("user.dir")
            +File.separator+"lingvaLeo.html");
            FileOutputStream fileOutputStream = new FileOutputStream(lingvaLeo);
            fileOutputStream.write(bytes);
            fileOutputStream.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){

        }


    }

}
