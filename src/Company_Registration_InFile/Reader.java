package Company_Registration_InFile;

import javax.swing.*;
/**
 * Created by user on 27.11.18.
 */
public class Reader {

    void reply(String reply){
        JOptionPane.showMessageDialog(null, reply);
    }

    String responseMainMenu;
    void mainMenu(String request){
        responseMainMenu = JOptionPane.showInputDialog(request);
    }
    String addCompanyName;
    void addCompany(){
        addCompanyName = JOptionPane.showInputDialog("Set the name of a company you want to Create");
    }
    String deleteCompanyName;
    void deleteCompany(){
        deleteCompanyName = JOptionPane.showInputDialog("Set the name of a company you want to Delete");
    }

    String responseSubMenu1;
    void subMenu1(String request){

        responseSubMenu1 = JOptionPane.showInputDialog(request);
    }
    String addDepartmentName;
    void addDepartment(){
        addDepartmentName = JOptionPane.showInputDialog("Set the name of a department you want to Create");
    }
    String deleteDepartmentName;
    void deleteDepartment(){
        deleteDepartmentName = JOptionPane.showInputDialog("Set the name of a department you want to Delete");
    }

    String responseSubMenu2;
    void subMenu2(String request){

        responseSubMenu2 = JOptionPane.showInputDialog(request);
    }
    String addWorkerName;
    void addWorker(){
        addWorkerName = JOptionPane.showInputDialog("Set the name of a worker you want to Hire");
    }
    String deleteWorkerName;
    void deleteWorker(){
        deleteWorkerName = JOptionPane.showInputDialog("Set the name of a worker you want to Fire");
    }
}
