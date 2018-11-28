package IO_CollectionHandling;

import java.util.ArrayList;
import java.io.*;
/**
 * Created by user on 28.11.18.
 */
public class TryIO {
    public static void main(String[] args) {
        ArrayList<Worker> workers =
                new ArrayList<Worker>();

        workers.add(new Worker(87, "Zacharia", 899.99));
        workers.add(new Worker(12, "Shean", 1432.02));
        workers.add(new Worker(6, "Aaron", 2002.33));
        workers.add(new Worker(3, "Lucy", 2555.22));
        workers.add(new Worker(37, "Molly", 787.15));
        workers.add(new Worker(61, "Jan", 2432.00));
        workers.add(new Worker(14, "Richard", 3005.02));

        BufferedReader bf = null;
        String line = null;

        try{
            File file = new File("StuffOfWorkers.txt");
            if(file.exists())
                file.createNewFile();
            //filling a file with a few simple lines
            PrintWriter pw = new PrintWriter(file);

            //pw.println("Everything is working");
            //pw.println("Hello world");

            // fillinf a file with a Collection
            for(Worker w: workers)
                pw.println(w);

            pw.close();

            // instatiating a variable to read from a file
            bf = new BufferedReader(new FileReader("StuffOfWorkers.txt"));

            while((line=bf.readLine())!=null){
                System.out.println(line);
            }

        }catch(IOException e){
            System.out.println("Error: "+e);
            e.printStackTrace(System.out);
        }finally{
            try {
                bf.close();
            } catch (IOException e1) {
                System.out.println("Error: "+e1);
                e1.printStackTrace(System.out);
            }
        }


    }
}
