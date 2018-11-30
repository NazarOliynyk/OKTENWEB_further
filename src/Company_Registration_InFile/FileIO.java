package Company_Registration_InFile;

/**
 * Created by user on 30.11.18.
 */
import java.io.*;
import java.util.TreeSet;

public class FileIO {

   static Reader r = new Reader();

    public static File createFile() {

    File file = new File(System.getProperty("user.dir") + File.separator + "CompaniesIO.txt");

        if(!file.exists()) {
        try {
            file.createNewFile();
            } catch (IOException e) {
                r.reply("Error creating a file!");
                e.printStackTrace();
            }
        }
        else {
            file = new File("CompaniesIO.txt");
        }
        return file;
    }

    public static void printIntoFile(File file, TreeSet<Company> companies){

        if(companies==null){
            companies=new TreeSet<>();
        }
        try{
       // ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

            for (Company company : companies) {
                for (Department department : company.getDepartments()) {
                    for (Worker worker : department.getWorkers()) {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                        objectOutputStream.writeObject(worker);
                        objectOutputStream.close();
                    }
                }
            }
       // objectOutputStream.close();

            }catch (IOException e) {
            r.reply("Error writing companies into a file!");
            e.printStackTrace();
            }

    }

    public static TreeSet<Company> readFromFile(File file){

        TreeSet<Company> companies = new TreeSet<>();

        try {
            //ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

            try {
                for (Company company : companies) {
                    for (Department department : company.getDepartments()) {
                        for (Worker worker : department.getWorkers()) {
                            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                            //worker = new Worker();
                            worker = (Worker)objectInputStream.readObject();
                            department = new Department();
                            department.getWorkers().add(worker);
                            company = new Company();
                            company.getDepartments().add(department);
                            companies.add(company);
                            objectInputStream.close();
                        }
                    }
                }

            }catch (ClassNotFoundException e){
                r.reply("Error class not found");
                e.printStackTrace();
            }

           // objectInputStream.close();

            } catch (IOException e){
                r.reply("Error reading from a file");
                e.printStackTrace();
            }
        return companies;
    }


}
