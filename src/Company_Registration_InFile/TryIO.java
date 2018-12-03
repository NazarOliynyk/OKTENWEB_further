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
        int i = 1;
        for (Department department : company.getDepartments()) {
            File file= createFile(department.getName(), i);
            i++;
            writeIntoFile(file, department.getName());
        }

    }

    public static void writeWorkers(Department department){


    }

    public static File createFile(String name, int i){
        File file = new File(System.getProperty("user.dir") + File.separator +"#"+ name+i+".txt");
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

    public static void writeWorkerIntoFile(File file, Worker worker){
        try{

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(worker);
            objectOutputStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
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

        TreeSet<Company> companies = new TreeSet<>();
        companies.add(new Company("alfa"));
        companies.add(new Company("beta"));

        writeCompanies(companies);

    }
}
