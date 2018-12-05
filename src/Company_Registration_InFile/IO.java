package Company_Registration_InFile;

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.ArrayList;

public class IO {
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

    public static void writeCompanies (File file, TreeSet<Company> companies) {


        try {
            PrintWriter pw = new PrintWriter(file);
            int c = 1;
            for (Company company : companies) {

                pw.println("c" + c + "(" + company.getName() + ")");
                int d = 1;
                for (Department department : company.getDepartments()) {

                    pw.println("d" + c + d + "(" + department.getName() + ")");
                    int w = 1;
                    for (Worker worker : department.getWorkers()) {

                        pw.println("wn" + c + d + w + "(" + worker.getName() + ")" + " " + "wq" + c + d + w + "(" + worker.getQualification() + ")");
                        w++;
                    }
                    d++;
                }
                c++;
            }
            pw.close();
        }catch (FileNotFoundException e){
            r.reply("Error file not found!");
        }
    }

    public static void deleteAll(File file){
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        }catch (FileNotFoundException e){
            r.reply("Error from deleteAll!");
        }
    }

    public static TreeSet<Company> readCompanies(File file) {
        String line ;
        String string ="";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));

            while ((line = bf.readLine()) != null) {
                string += line + " ";
            }

            bf.close();
        }catch (IOException e){
            r.reply("Error Input/output!");
        }

        String[] strings = string.split(" ");


        ArrayList<String> companyNames = new ArrayList<>();
        ArrayList<String> departmentNames = new ArrayList<>();
        ArrayList<String> workerNames = new ArrayList<>();
        ArrayList<String> workerQualif = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].startsWith("c")){
                companyNames.add(strings[i]);
            }else if (strings[i].startsWith("d")){
                departmentNames.add(strings[i]);
            }else if (strings[i].startsWith("wn")){
                workerNames.add(strings[i]);
            }else if (strings[i].startsWith("wq")){
                workerQualif.add(strings[i]);
            }
        }

        TreeSet<Company> companies1 = new TreeSet<>();
        int c=1;
        for (String comp : companyNames) {
            Company company = new Company();
            company.setName(comp.substring(comp.indexOf("(") + 1, comp.indexOf(")")));
            TreeSet<Department> departmentsTree = new TreeSet<>();
            int d=1;
            for(String dep: departmentNames){



                if((Character.digit( dep.charAt(1), 10)== c)&&(Character.digit( dep.charAt(2), 10)== d)){


                    Department department = new Department();
                    department.setName(dep.substring(dep.indexOf("(") + 1, dep.indexOf(")")));

                    ArrayList<Worker> workers = new ArrayList<>();
                    int w=1;
                    for (int i=0; i<workerNames.size(); i++) {
                        if((Character.digit( workerNames.get(i).charAt(2), 10)== c)&&(Character.digit( workerNames.get(i).charAt(3), 10)== d)) {
                            Worker worker = new Worker();
                            worker.setName(workerNames.get(i).substring(workerNames.get(i).indexOf("(") + 1, workerNames.get(i).indexOf(")")));

                            worker.setQualification(Integer.parseInt(workerQualif.get(i).substring(workerQualif.get(i).indexOf("(") + 1, workerQualif.get(i).indexOf(")"))));
                            workers.add(worker);
                            department.setWorkers(workers);
                        }
                        w++;
                    }
                    departmentsTree.add(department);


                }
                d++;
            }
            company.setDepartments(departmentsTree);
            c++;
            companies1.add(company);

        }

        return companies1;
    }



    public static void main(String[] args) {


    }
}
