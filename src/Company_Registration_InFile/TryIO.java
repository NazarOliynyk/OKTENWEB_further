package Company_Registration_InFile;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;;

public class TryIO {

    public static void writeCompanies(TreeSet<Company> companies){

        int i = 1;
        for (Company company : companies) {
           File file= createFile(company.getName(), i);
            i++;
            writeIntoFile(file, company.getName());
        }


    }

    public static void writeDepartments(Company company){


    }

    public static void writeWorkers(Department department){


    }

    public static File createFile(String name, int i){
        File file = new File(System.getProperty("user.dir") + File.separator + name+i+".txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating a file!");
                e.printStackTrace();
            }
        }
        else {
            file = new File(name+i+".txt");
        }
        return file;
    }

    public static void writeIntoFile(File file, String name){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true); // allows to add new info to file
            fileOutputStream.write(name.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeWorkerIntoFile(File file, String name, int qualification){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true); // allows to add new info to file
            fileOutputStream.write((name+" "+qualification).getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Worker readWorkerFromFile(File file){
        Worker worker = new Worker();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[fileInputStream.available()]; // gives the size of a byte array
            fileInputStream.read(bytes);
            String string = new String(bytes);
            String[] s = string.split(" ");
            worker.setName(s[0]);
            worker.setQualification(Integer.parseInt(s[1]));
            fileInputStream.close();
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return worker;
    }

    public static Department readDepartmentFromFile(File file){
        Department department = new Department();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[fileInputStream.available()]; // gives the size of a byte array
            fileInputStream.read(bytes);
            String string = new String(bytes);
            department.setName(string);
            department.setWorkers(new ArrayList<>());
            fileInputStream.close();
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return department;
    }

    public static void main(String[] args) {
        int i =562154;
        File file = new File(System.getProperty("user.dir") + File.separator + "Company"+i+".txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating a file!");
                e.printStackTrace();
            }
        }
        else {
            file = new File("CompaniesIO.txt");
        }

        System.out.println(file.getName());


    }
}
