package com.iweb.view;

import com.iweb.App;
import com.iweb.controller.EmployeeController;
import com.iweb.pojo.Announcement;
import com.iweb.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

/**
 * @author k
 * @date 2023/6/12 16:55
 */
public class EmployeeView {
    private static Scanner sc = new Scanner(System.in);
    /**普通员工页面*/
    public static void employeeView(){
        System.out.println("---------------------");
        System.out.println("欢迎来到普通员工界面");
        System.out.println("请输入操作序号：");
        System.out.println("1.查看自身信息");
        System.out.println("2.更改基础信息");
        System.out.println("3.更改密码");
        System.out.println("4.查看公告");
        System.out.println("5.删除账号");
        System.out.println("6.退出");

        String inputKey = sc.nextLine();
        EmployeeController.employeeController(inputKey);
    }
    public static void showInformationView() {
        System.out.println(App.currentEmployee.printEmployee());
        if (App.currentEmployee.getIsManager()){
            EmployeeManageView.employeeManageView();
        }
        employeeView();
    }

    public static void changeBasicInformationView(){
        System.out.println("请输入新的姓名：");
        String newName = sc.nextLine();
        System.out.println("请输入新的性别：");
        String newSex = sc.nextLine();
        System.out.println("请输入新的手机号：");
        String newPhoneNumber = sc.nextLine();
        System.out.println("请输入新的身份证：");
        String newIdNumber = sc.nextLine();
        EmployeeService.changeBasicInformation(newName,newSex,newPhoneNumber,newIdNumber);
        System.out.println("用户信息已更改");
        showInformationView();
    }

    public static void changePasswordView() {
        System.out.println("请输入旧密码：");
        String oldPassword = sc.nextLine();
        if (oldPassword.equals(App.currentEmployee.getEPassword())){
            System.out.println("请输入新密码：");
            String newPassword = sc.nextLine();
            System.out.println("请确认新密码：");
            String confirmPassword = sc.nextLine();
            if (newPassword.equals(confirmPassword)){
                EmployeeService.changePassword(newPassword);
                System.out.println("密码已更改");
                employeeView();
            }
        }
        System.out.println("输入密码和原有密码不一致,请重新输入:");
        changePasswordView();
    }

    public static void deleteEmployeeView() {
        System.out.println("是否确认删除当前账户？（y/n）");
        String confirm =sc.nextLine();
        if (confirm.equals("y")){
            EmployeeService.deleteEmployee();
            System.out.println("账户已删除...");
            MainView.mainView();
        }else if (confirm.equals("n")){
            System.out.println("确认指令,未进行删除操作");
        }else {
            System.out.println("指令有误,已退回删除操作");
        }
        employeeView();
    }
}
