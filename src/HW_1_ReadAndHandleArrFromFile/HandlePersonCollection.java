package HW_1_ReadAndHandleArrFromFile;

import java.io.*;
import java.util.ArrayList;
/**
 * Created by user on 29.11.18.
 */
public class HandlePersonCollection {

    private static String[] spliteLine(String line){
        String [] words;
        words = line.split(" ");
        return words;
    }

    private static ArrayList<String> getLines(String fileName){

        ArrayList<String> lines = new ArrayList<>();

        String line;

        BufferedReader readFromFile;

        try{

            readFromFile = new BufferedReader(new java.io.FileReader(fileName));
            while ((line = readFromFile.readLine()) != null) {
                lines.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return lines;
    }

    private static ArrayList<Person> getPersons(ArrayList<String> lines){
        ArrayList<Person> persons = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            Person person = new Person();
            person.setId(Integer.parseInt(spliteLine(lines.get(i))[0]));
            person.setName(spliteLine(lines.get(i))[1]);
            person.setSalary(Double.parseDouble(spliteLine(lines.get(i))[2]));
            persons.add(person);

        }
        return persons;
    }

    public static void main(String[] args) {

        ArrayList<Person> persons = getPersons(getLines("dataOfPersons.txt"));

        for (Person person : persons) {
            System.out.println(person);
        }


    }
}
