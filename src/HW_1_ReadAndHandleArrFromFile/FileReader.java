package HW_1_ReadAndHandleArrFromFile;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by user on 29.11.18.
 */
public class FileReader {
    public static void main(String[] args) {

        File file = new File("dataOfPersons.txt");

        String[][] data = new String[9][3];
        String [] words1 = new String[9];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);

            String string = new String(bytes);
            //System.out.println(string);
            words1 = string.split(" ");
            fileInputStream.close();

            for (int i=0; i<data.length; i++) {
                for (int j=0; j<data[i].length; j++){
                    //data[i][j] = string.split(" ");
                    //data[i][j] ="fjhs";
                }
            }
            String words= null;
            for (String word: string.split(" ")){
                words+=word;
                //System.out.println(word);
            }

            //System.out.println(words);
           // System.out.println(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1){
            e1.printStackTrace();
        }

        for (int i=0; i<data.length; i++) {
            for (int j=0; j<data[i].length; j++){
                //System.out.println(data[i][j]);

            }
        }
        // System.out.println(words);
        //System.out.println(string);

        System.out.println("1----------------------------------");

        for (int i=0; i<words1.length; i++){
            System.out.println(words1[i]);
        }
        System.out.println("words1.length- "+words1.length);
        System.out.println("2----------------------------------");
       System.out.println("words1[1]- "+words1[1]);
        System.out.println("words1[2]- "+words1[2]);
        System.out.println("words1[4]- "+words1[4]);

        String line;

        BufferedReader readFromFile ;

        ArrayList<String> lines = new ArrayList<>();
        try{

            readFromFile = new BufferedReader(new java.io.FileReader("dataOfPersons.txt"));
            while ((line = readFromFile.readLine()) != null) {
                lines.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(lines.get(1));
        System.out.println("3----------------------------------");
        for (String s : lines) {
            System.out.println(s);
        }
        System.out.println("4----------------------------------");
        System.out.println(lines.get(1));

        String []words2;
        words2 = spliteLine(lines.get(6));
        System.out.println("5----------------------------------");
        for (String s : words2) {
            System.out.println(s);
        }


    }
    private static String[] spliteLine(String line){
        String [] words;
        words = line.split(" ");
        return words;
    }
}
