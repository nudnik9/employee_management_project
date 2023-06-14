package com.iweb.controller;

import com.iweb.view.EmployeeView;
import com.iweb.view.EmployeeManageView;
import com.iweb.view.ManagerView;

/**
 * @author k
 * @date 2023/6/13 8:50
 */
public class EmployeeManageController {
    public static void managerSearchController(String inputKey) {
        switch (inputKey){
            case "1":
                //查看本人信息
                System.out.println("当前用户信息为:");
                EmployeeView.showInformationView();
                break;
            case "2":
                //查看所有员工信息
                System.out.println("即将进入查询所有员工信息界面");
                EmployeeManageView.searchAllEmployeeView();
                break;
            case "3":
                //根据姓名查询员工信息
                System.out.println("即将进入根据员工姓名查询员工信息界面");
                EmployeeManageView.searchEmployeeByNameView();
                break;
            case "4":
                //根据员工id查询员工信息
                System.out.println("即将进入根据员工id查询员工信息界面");
                EmployeeManageView.searchEmployeeByIdView();
                break;
            case "5":
                //根据员工是否是管理员查询员工信息
                System.out.println("即将进入根据员工是否是管理员查询员工信息界面");
                EmployeeManageView.searchEmployeeByIsManagerView();
                break;
            case "6":
                //根据身份证号查询员工信息
                System.out.println("即将进入根据身份证号查询员工信息界面");
                EmployeeManageView.searchEmployeeByIdNumberView();
                break;
            case "7":
                //根据性别查询员工信息
                System.out.println("即将进入根据性别查询员工信息界面");
                EmployeeManageView.searchEmployeeBySexView();
                break;
            case "8":
                //根据部门名称查询员工信息
                System.out.println("即将进入根据部门名字查询员工信息界面");
                EmployeeManageView.searchEmployeeBySectionView();
                break;
            case "9":
                //根据职位名称查询员工信息
                System.out.println("即将进入根据职位名字查询员工信息界面");
                EmployeeManageView.searchEmployeeByPositionView();
                break;
            case "10":
                //根据id删除员工
                System.out.println("根据id删除员工：");
                EmployeeManageView.deleteEmployee();
                break;
            case "11":
                //根据id修改员工基础信息
                System.out.println("根据id修改员工基础信息");
                EmployeeManageView.updateEmployeeInformationView();
                break;
            case "12":
                //根据id修改员工密码
                System.out.println("根据id修改员工密码");
                EmployeeManageView.updateEmployeePasswordView();
                break;
            case "13":
                //根据id修改员工是否是管理员
                System.out.println("根据id修改员工是否是管理员");
                EmployeeManageView.updateEmployeeIsManager();
                break;
            case "14":
                System.out.println("添加员工：");
                EmployeeManageView.addEmployeeView();
                break;
            case "15":
                //退出查询界面
                System.out.println("正在退出用户管理界面...");
                ManagerView.managerView();
                break;
            default:
                System.out.println("输入错误，请重新输入");
                EmployeeManageView.employeeManageView();
        }
    }
}
