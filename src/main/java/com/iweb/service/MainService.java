package com.iweb.service;

import com.iweb.App;
import com.iweb.pojo.Employee;
import com.iweb.view.MainView;

import java.util.List;

/**
 * @author k
 * @date 2023/6/12 14:51
 */
public class MainService {
    /**
     * 登录
     */
    public static boolean login(Integer inputEid, String inputPassword) {
        //获取用户集合
        List<Employee> employeeList = MainView.employeeDao.searchAllEmployee();
        for (Employee employee:employeeList) {
            if (employee.getEId().equals(inputEid)){
                if (employee.getEPassword().equals(inputPassword)){
                    System.out.println("账号密码正确,即将进入下一界面。。。");
                    App.currentEmployee=employee;
                    return true;
                }
            }
        }
        return false;
    }
    public static Boolean register(Integer inputEid,String inputPassword,String inputName){
        Employee employee = new Employee();
        employee.setEId(inputEid);
        employee.setEPassword(inputPassword);
        employee.setEName(inputName);
        return MainView.employeeDao.addEmployee(employee);
    }
}
