package com.iweb.service;

import com.iweb.App;
import com.iweb.DAO.EmployeeImpl;
import com.iweb.pojo.Employee;
import com.iweb.view.MainView;

import java.util.Scanner;

/**
 * @author k
 * @date 2023/6/12 19:56
 */
public class EmployeeService {
    public static void changeBasicInformation(String newName,String newSex,String newPhoneNumber,String newIdNumber){
        App.currentEmployee.setEName(newName);
        App.currentEmployee.setESex(newSex);
        App.currentEmployee.setEPhoneNumber(newPhoneNumber);
        App.currentEmployee.setEIdNumber(newIdNumber);
        MainView.employeeDao.updateEmployeeBasicInformation(App.currentEmployee);
    }
    public static void changePassword(String newPassword){
        App.currentEmployee.setEPassword(newPassword);
        MainView.employeeDao.updateEmployeePassword(App.currentEmployee);
    }

    public static void deleteEmployee() {
        MainView.employeeDao.deleteEmployee(App.currentEmployee);
    }


}
