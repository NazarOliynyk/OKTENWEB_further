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
            // System.out.println(string);
            bf.close();
        }catch (IOException e){
            r.reply("Error Input/output!");
        }

        String[] strings = string.split(" ");
       // System.out.println(Arrays.toString(strings));

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
//        companyNames.stream().forEach(s -> System.out.println(s));
//        departmentNames.stream().forEach(s -> System.out.println(s));
//        workerNames.stream().forEach(s -> System.out.println(s));
//        workerQualif.stream().forEach(s -> System.out.println(s));

        //System.out.println("--------------------Companies comeback---------------------");
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



    public static void main(String[] args) throws FileNotFoundException, IOException{
        File file = createFile();

        TreeSet<Company> companies = new TreeSet<>();

        Department department1 = new Department();
        department1.setName("department1");
        Department department2 = new Department();
        department2.setName("department2");

        Worker worker1 = new Worker("Ivan", 3);
        Worker worker2 = new Worker("Petro", 6);
        Worker worker3 = new Worker("Vasyl", 8);
        Worker worker4 = new Worker("Mukola", 2);

        ArrayList<Worker> workers1 = new ArrayList<>();
        workers1.add(worker1);
        workers1.add(worker2);
        ArrayList<Worker> workers2 = new ArrayList<>();
        workers2.add(worker3);
        workers2.add(worker4);

        department1.setWorkers(workers1);
        department2.setWorkers(workers2);

        TreeSet<Department> departments = new TreeSet<>();
        departments.add(department1);
        departments.add(department2);

        TreeSet<Department> departments1 = new TreeSet<>();
        Company company1 = new Company();
        Company company2 = new Company();
        company1.setName("alfa");
        company1.setDepartments(departments1);

        company2.setName("beta");
        company2.setDepartments(departments);

        companies.add(company1);
        companies.add(company2);
        companies.stream().forEach(company -> System.out.println(company));


            writeCompanies(file, companies);


        System.out.println("--------------------reading--------------------");
        TreeSet<Company> companies1 = readCompanies(file);

        companies1.stream().forEach(company -> System.out.println(company));
//
//        String line ;
//        String string ="";
//
//        BufferedReader bf = new BufferedReader(new FileReader(file));
//
//        while((line=bf.readLine())!=null){
//           string+=line+" ";
//        }
//        System.out.println(string);
//
//        String[] strings = string.split(" ");
//        System.out.println(Arrays.toString(strings));
//
//        ArrayList<String> companyNames = new ArrayList<>();
//        ArrayList<String> departmentNames = new ArrayList<>();
//        ArrayList<String> workerNames = new ArrayList<>();
//        ArrayList<String> workerQualif = new ArrayList<>();
//
//        for (int i = 0; i < strings.length; i++) {
//            if (strings[i].startsWith("c")){
//                companyNames.add(strings[i]);
//            }else if (strings[i].startsWith("d")){
//                departmentNames.add(strings[i]);
//            }else if (strings[i].startsWith("wn")){
//                workerNames.add(strings[i]);
//            }else if (strings[i].startsWith("wq")){
//                workerQualif.add(strings[i]);
//            }
//        }
//        companyNames.stream().forEach(s -> System.out.println(s));
//        departmentNames.stream().forEach(s -> System.out.println(s));
//        workerNames.stream().forEach(s -> System.out.println(s));
//        workerQualif.stream().forEach(s -> System.out.println(s));
//
//        System.out.println("--------------------Companies comeback---------------------");
//        TreeSet<Company> companies1 = new TreeSet<>();
//        int c=1;
//        for (String comp : companyNames) {
//            Company company = new Company();
//            company.setName(comp.substring(comp.indexOf("(") + 1, comp.indexOf(")")));
//            TreeSet<Department> departmentsTree = new TreeSet<>();
//            int d=1;
//            for(String dep: departmentNames){
//
//
//
//                if((Character.digit( dep.charAt(1), 10)== c)&&(Character.digit( dep.charAt(2), 10)== d)){
//
//
//                        Department department = new Department();
//                        department.setName(dep.substring(dep.indexOf("(") + 1, dep.indexOf(")")));
//
//                        ArrayList<Worker> workers = new ArrayList<>();
//                        int w=1;
//                    for (int i=0; i<workerNames.size(); i++) {
//                        if((Character.digit( workerNames.get(i).charAt(2), 10)== c)&&(Character.digit( workerNames.get(i).charAt(3), 10)== d)) {
//                            Worker worker = new Worker();
//                            worker.setName(workerNames.get(i).substring(workerNames.get(i).indexOf("(") + 1, workerNames.get(i).indexOf(")")));
//
//                            worker.setQualification(Integer.parseInt(workerQualif.get(i).substring(workerQualif.get(i).indexOf("(") + 1, workerQualif.get(i).indexOf(")"))));
//                            workers.add(worker);
//                            department.setWorkers(workers);
//                        }
//                        w++;
//                    }
//                        departmentsTree.add(department);
//
//
//                }
//                d++;
//            }
//            company.setDepartments(departmentsTree);
//            c++;
//            companies1.add(company);
//
//        }
//
//
////        for (int i = 0; i < companyNames.size(); i++) {
////            Company company = new Company();
////            company.setName(companyNames(1).substring(c.indexOf("(") + 1, c.indexOf(")")));
////            companies1.add(company);
////
////        }
//
//        companies1.stream().forEach(company -> System.out.println(company));
//


        // deleteAll(file);

    }
}
