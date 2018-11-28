package Lecture1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by user on 28.11.18.
 */
public class IO_Fill_File {

    // Shift + F10  - runs code
    public static void main(String[] args) {

        // serialization :

        File file = new File(System.getProperty("user.dir")+File.separator+"myFile.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // FOS + Enter
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true); // allows to add new info to file
            fileOutputStream.write("oktenweb".getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }


        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[fileInputStream.available()]; // gives the size of a byte array
            fileInputStream.read(bytes);
            String string = new String(bytes);
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
