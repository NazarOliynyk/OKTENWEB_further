package IO_CollectionHandling;

import java.util.ArrayList;
import java.io.*;
/**
 * Created by user on 28.11.18.
 */
public class HandleCollectionOfWorkers {
    public static void main(String[] args) {
        BufferedReader bf = null;
        String line;
        String line1 =null;

        try {
                bf = new BufferedReader(new FileReader("StuffOfWorkers.txt"));
            while((line=bf.readLine())!=null){
               // System.out.println(line);
                line1+=line;
            }
        }catch (IOException e){
            System.out.println("Error: "+e);
        }finally {
            try {
                bf.close();
            }catch (IOException e1){
                System.out.println("Error: "+e1);
            }
        }

        System.out.println(line1);
    }

}
