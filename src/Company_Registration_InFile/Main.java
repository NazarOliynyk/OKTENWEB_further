package Company_Registration_InFile;



import java.io.File;
import java.util.*;
import java.util.Random;
/**
 * Created by okten29 on 11/26/18.
 */
public class Main {

    static Reader r = new Reader();

    static FileIO fileIO = new FileIO();

    static File file = fileIO.createFile();

     static TreeSet<Company> companies = fileIO.readFromFile(file);

    //static TreeSet<Company> companies = new TreeSet<>();

    public static TreeSet<Company> addCompany(String name){

        boolean flag=false;
        Company company = new Company();
        TreeSet<Department> departments = new TreeSet<>();

        for (Company company1 : companies) {
            if(company1.getName().equals(name)){
                flag=true;
            }
        }

        if(flag){
            // System.out.println("The company '" + name+"' already exists!");
            r.reply("The company '" + name+"' already exists!");
            return companies;
        }else {
            company.setName(name);
            company.setDepartments(departments);
            companies.add(company);
            fileIO.printIntoFile(file, companies);
        }
        return companies;
    }
    public static TreeSet<Company> removeCompany(String name){

        boolean flag=false;
        Company company = new Company();

        Iterator<Company> iterator = companies.iterator();
        while (iterator.hasNext()){
            Company next = iterator.next();
            if(next.getName().equals(name)){
                iterator.remove();
                flag=true;
                return companies;
            }
        }

        if(!flag){
            //System.out.println("The company '" + name+"' does not exist!");
            r.reply("The company '" + name+"' does not exist!");
            return companies;
        }
        fileIO.printIntoFile(file, companies);
        return companies;
    }

    public static Company selectCompany(String name){

        boolean flag=false;
        Company company = new Company();
        for (Company company1 : companies) {
            if(company1.getName().equals(name)){
                flag=true;
                company=company1;
                return company;
            }
        }
        if(!flag){
            //System.out.println("The company '" + name+"' does not exist!");
            r.reply("The company '" + name+"' does not exist!");
            return null;}
        return company;
    }

    public static Company addDepartment(Company company, String name){

        boolean flag=false;
        Department department = new Department();
        ArrayList<Worker> workers = new ArrayList<>();
        TreeSet<Department> departments = company.getDepartments();
        for (Department department1 : departments) {
            if(department1.getName().equals(name)){
                flag=true;
            }
        }
        if(flag){
           // System.out.println("The department '" + name+"' already exists!");
            r.reply("The department '" + name+"' already exists!");
            return company;
        }else {
            department.setName(name);
            department.setWorkers(workers);
            departments.add(department);
            companies.add(company);
            fileIO.printIntoFile(file, companies);
        }
        return company;
    }

    public static Company removeDepartment(Company company, String name){

        boolean flag=false;
        TreeSet<Department> departments = company.getDepartments();

        Iterator<Department> iterator = departments.iterator();
        while (iterator.hasNext()){
            Department next = iterator.next();
            if (next.getName().equals(name)){
                iterator.remove();
                company.setDepartments(departments);
                flag=true;
                return company;
            }
        }

        if(!flag){
            //System.out.println("The department " + name+" does not exist!");
            r.reply("The department '" + name+"' does not exist!");
            return null;
        }
        fileIO.printIntoFile(file, companies);
        return company;
    }


    public static Department selectDepartment(Company company, String name){

        boolean flag=false;
        Department department = new Department();
        TreeSet<Department> departments = company.getDepartments();
        for (Department department1 : departments) {
            if(department1.getName().equals(name)){
                department= department1;
                flag=true;
                return department;
            }
        }
        if(!flag){
            //System.out.println("The department '" + name+"' does not exist!");
            r.reply("The department '" + name+"' does not exist!");
            return null;}
        return department;
    }

    public static Department addWorker(Company company, Department department, String name){

        Random random = new Random ();
        Worker worker = new Worker();
        ArrayList<Worker> workers = department.getWorkers();
        TreeSet<Department> departments = company.getDepartments();
        worker.setName(name);
        worker.setQualification(random.nextInt(10));
        workers.add(worker);
        department.setWorkers(workers);
        departments.add(department);
        company.setDepartments(departments);
        companies.add(company);
        fileIO.printIntoFile(file, companies);
        return department;
    }

    public static Worker removeWorker(Company company, Department department, String name){

        boolean flag=false;
        Worker worker = new Worker();
        ArrayList<Worker> workers = department.getWorkers();
        TreeSet<Department> departments = company.getDepartments();
        for (Worker worker1 : workers) {
            if (worker1.getName().equals(name)){
                flag=true;
                worker = worker1;
                workers.remove(worker1);
                department.setWorkers(workers);
                departments.add(department);
                company.setDepartments(departments);
                companies.add(company);
                return worker;
            }
        }
        if(!flag){
            System.out.println("The worker '"+name+"' does not exist in department '"+department.getName()+"' of company '"+company.getName()+"'");
            r.reply("The worker '"+name+"' does not exist in department '"+department.getName()+"' of company '"+company.getName()+"'");
            return worker;
        }
        fileIO.printIntoFile(file, companies);
        return worker;
    }

    public static void printGoodWorkers(Department department){
        String reply = "There are workers with qualification above-average: \n";
        for (Worker worker : department.getWorkers()) {
            if(worker.getQualification()>=6){
                reply+= worker.toString();
            }
        }
        // System.out.println(reply);
        r.reply(reply);
    }

    public static void printBadWorkers(Department department){
        String reply = "There are workers with qualification below-average: \n";
        for (Worker worker : department.getWorkers()) {
            if(worker.getQualification()<=5){
                reply+= worker.toString();
            }
        }
        //System.out.println(reply);
        r.reply(reply);
    }

    static String getRequestMainMenu(TreeSet<Company> companies) {
        String list = "There are following companies: \n";
        String response = null;
        if (companies.isEmpty()) {
            list += "...empty set...";
        } else {

            int i = 1;
            for (Company company1 : companies) {
                list += i + ".  '" + company1.getName() + "'\n";
                i++;
            }
        }
        //.out.println(list);
        response= "Select the option: \n" +
                "                   \n" +
                "- press A - create and add a new company \n" +
                "                   \n" +
                "- press D - remove a company \n" +
                "                   \n" +
                "- Select the name of a company from a list below to fill the stuff: \n" +
                "                   \n" +
                list + "\n" +
                "                   \n" +
                "- press Cancel to exit \n" +
                "                   \n";

        return response;
    }

    public static boolean mainMenu(TreeSet<Company> companies){
        Company company ;

        String request = getRequestMainMenu(companies);

        while (true) {
            r.mainMenu(request);
            if (r.responseMainMenu == null) {
                return false;
            } else if (r.responseMainMenu.equals("A")) {
                r.addCompany();
                String addCompanyName = r.addCompanyName;
                companies = addCompany(addCompanyName);
                request = getRequestMainMenu(companies);
                System.out.println(companies);
            } else if (r.responseMainMenu.equals("D")){
                r.deleteCompany();
                String deleteCompanyName = r.deleteCompanyName;
                companies = removeCompany(deleteCompanyName);
                request = getRequestMainMenu(companies);
            }
            else {
                String selectCompanyName = r.responseMainMenu;
                company = selectCompany(selectCompanyName);
                System.out.println(company);
                if(company==null){
                    r.reply("Add a company!");
                }else {
                    subMenu1(company);
                }
            }

        }
    }


    static String getRequestSubMenu1(Company company) {

        String list = "There are following departments in company: '"+company.getName()+"'\n";
        String response = null;
        if (company.getDepartments().isEmpty()) {
            list += "...empty set...";
        } else {

            int i = 1;
            for (Department department1 : company.getDepartments()) {
                list += i + ".  '" + department1.getName() + "'\n";
                i++;
            }
        }

        response= "Select the option: \n" +
                "                   \n" +
                "- press A - create and add a new department \n" +
                "                   \n" +
                "- press D - remove a department \n" +
                "                   \n" +
                "- Select the name of a department from a list below to fill the stuff: \n" +
                "                   \n" +
                list + "\n" +
                "                   \n" +
                "- press Cancel to exit \n" +
                "                   \n";

        return response;
    }

    public static boolean subMenu1(Company company){
        Department department;

        String request = getRequestSubMenu1(company);

        while (true) {
            r.subMenu1(request);
            if (r.responseSubMenu1 == null) {
                return false;
            } else if (r.responseSubMenu1.equals("A")) {
                r.addDepartment();
                String addDepartmentName = r.addDepartmentName;
                company = addDepartment(company, addDepartmentName);
                request = getRequestSubMenu1(company);
                System.out.println(companies);
            } else if (r.responseSubMenu1.equals("D")){
                r.deleteDepartment();
                String deleteDepartmentName = r.deleteDepartmentName;
                company = removeDepartment(company, deleteDepartmentName);
                request = getRequestSubMenu1(company);
            }
            else {
                String selectDepartmentName = r.responseSubMenu1;
                department = selectDepartment(company, selectDepartmentName);
                System.out.println(company);
                if(department==null){
                    r.reply("Ad a department!");
                }
                else {
                    subMenu2(company, department);
                }
            }

        }
    }

    static String getRequestSubMenu2(Department department) {

        String list = "There are following workers in department: '"+department.getName()+"'\n";
        String response = null;
        if (department.getWorkers().isEmpty()) {
            list += "...empty set...";
        } else {

            int i = 1;
            for (Worker worker1 : department.getWorkers()) {
                list += i + ".  '" + worker1.getName() + "'\n";
                i++;
            }
        }

        response= "Select the option: \n" +
                "                   \n" +
                "- press A - create and hire a new worker \n" +
                "                   \n" +
                "- press D - fire a worker \n" +
                "                   \n" +
                "- press G - print the list of good workers \n" +
                "                   \n" +
                "- press B - print the list of good workers \n" +
                "                   \n" +
                " The whole list of workers: \n" +
                "                   \n" +
                list + "\n" +
                "                   \n" +
                "- press Cancel to exit \n" +
                "                   \n";

        return response;
    }

    public static boolean subMenu2(Company company, Department department){
        Worker worker;
        Worker workerFired;

        String request = getRequestSubMenu2(department);

        while (true) {
            r.subMenu2(request);
            if (r.responseSubMenu2 == null) {
                return false;
            } else if (r.responseSubMenu2.equals("A")) {
                r.addWorker();
                String addWorkerName = r.addWorkerName;
                department = addWorker(company, department, addWorkerName);
                request = getRequestSubMenu2(department);
                System.out.println(companies);
            } else if (r.responseSubMenu2.equals("D")){
                r.deleteWorker();
                String deleteWorkerName = r.deleteWorkerName;
                workerFired = removeWorker(company, department, deleteWorkerName);
                request = getRequestSubMenu2(department);
            }
            else if (r.responseSubMenu2.equals("G")){
                printGoodWorkers(department);
            }
            else if (r.responseSubMenu2.equals("B")){
                printBadWorkers(department);
            }else {
                r.reply("Select from letters on the menu!");
            }

        }
    }

    public static void main(String[] args) {

        mainMenu(companies);
    }
}

