package com.iweb.view;

import com.iweb.controller.EmployeeManageController;
import com.iweb.service.EmployeeManageService;

import java.util.Scanner;

/**
 * @author k
 * @date 2023/6/13 8:37
 */
public class EmployeeManageView {
    private static Scanner sc = new Scanner(System.in);
    public static void employeeManageView(){
        System.out.println("----------用户管理-----------");
        System.out.println("请选择要进行的操作");
        System.out.println("1.查看本人信息");
        System.out.println("2.查看所有员工信息");
        System.out.println("3.根据姓名查询员工信息");
        System.out.println("4.根据员工id查询员工信息");
        System.out.println("5.根据员工是否是管理员查询员工信息");
        System.out.println("6.根据身份证号查询员工信息");
        System.out.println("7.根据性别查询员工信息");
        System.out.println("8.根据部门名称查询员工信息");
        System.out.println("9.根据职位名称查询员工信息");
        System.out.println("10.根据id删除员工");
        System.out.println("11.根据id修改员工基础信息");
        System.out.println("12.根据id修改员工密码");
        System.out.println("13.根据id修改员工是否是管理员");
        System.out.println("14.添加员工");
        System.out.println("15.退出用户管理界面");
        String inputKey=sc.nextLine();
        EmployeeManageController.managerSearchController(inputKey);
    }

    public static void searchAllEmployeeView() {
        System.out.println("以下是所有的员工信息");
        EmployeeManageService.searchAllEmployee();
        EmployeeManageView.employeeManageView();
    }

    public static void searchEmployeeByNameView() {
        System.out.println("请输入姓名：");
        String inputName = sc.nextLine();
        System.out.println("以下是姓名为"+inputName+"的员工信息");
        EmployeeManageService.searchEmployeeByName(inputName);
        EmployeeManageView.employeeManageView();
    }

    public static void searchEmployeeByIdView() {
        System.out.println("请输入id：");
        Integer inputId = Integer.parseInt(sc.nextLine());
        System.out.println("下面是id为"+inputId+"的员工信息");
        EmployeeManageService.searchEmployeeById(inputId);
        EmployeeManageView.employeeManageView();
    }

    public static void searchEmployeeByIsManagerView() {
        System.out.println("请输入true/false已确定查询身份是/不是管理员的员工");
        String  inputKey = sc.nextLine();
        if (inputKey.equals("true")){
            System.out.println("以下是身份是管理员的员工：");
        }else if (inputKey.equals("false")){
            System.out.println("以下是身份不是管理员的员工：");
        }else {
            System.out.println("输入有误");
            EmployeeManageView.employeeManageView();
        }
        EmployeeManageService.searchEmployeeByIsManager(inputKey);
        EmployeeManageView.employeeManageView();
    }

    public static void searchEmployeeByIdNumberView() {
        System.out.println("请输入身份证号：");
        String inputIdNumber = sc.nextLine();
        System.out.println("以下是身份证为"+inputIdNumber+"的员工信息");
        EmployeeManageService.searchEmployeeByIdNumber(inputIdNumber);
        EmployeeManageView.employeeManageView();
    }

    public static void searchEmployeeBySexView() {
        System.out.println("请输入性别：");
        String inputSex = sc.nextLine();
        System.out.println("以下是性别为"+inputSex+"的员工信息");
        EmployeeManageService.searchEmployeeBySex(inputSex);
        EmployeeManageView.employeeManageView();
    }

    public static void searchEmployeeBySectionView() {
        System.out.println("请输入部门名称");
        String inputSection = sc.nextLine();
        System.out.println("以下是所属部门为"+inputSection+"的员工信息");
        EmployeeManageService.searchEmployeeBySection(inputSection);
        EmployeeManageView.employeeManageView();
    }

    public static void searchEmployeeByPositionView() {
        System.out.println("请输入职位名称");
        String inputPosition = sc.nextLine();
        System.out.println("以下是所属职位为"+inputPosition+"的员工信息");
        EmployeeManageService.searchEmployeeByPosition(inputPosition);
        EmployeeManageView.employeeManageView();
    }

    public static void deleteEmployee() {
        System.out.println("请输入要删除的员工id：");
        Integer inputId =(Integer.parseInt(sc.nextLine())); 
        System.out.println("是否确认删除？（y/n）");
        String confirm =sc.nextLine();
        if (confirm.equals("y")){
            EmployeeManageService.deleteEmployee(inputId);
            employeeManageView();
        }else if (confirm.equals("n")){
            System.out.println("确认指令,未进行删除操作");
        }else {
            System.out.println("指令有误,已退回删除操作");
        }
        employeeManageView();
    }

    public static void updateEmployeeInformationView() {
        System.out.println("请输入要修改的员工id：");
        Integer inputId =Integer.parseInt(sc.nextLine());
        System.out.println("请输入基础信息：");
        System.out.println("请输入新的姓名：");
        String newName = sc.nextLine();
        System.out.println("请输入新的性别：");
        String newSex = sc.nextLine();
        System.out.println("请输入新的手机号：");
        String newPhoneNumber = sc.nextLine();
        System.out.println("请输入新的身份证：");
        String newIdNumber = sc.nextLine();
        System.out.println("请输入新的部门：");
        String newSection = sc.nextLine();
        System.out.println("请输入新的职位：");
        String newPosition = sc.nextLine();
        EmployeeManageService.updateEmployeeBasicInformation(inputId,newName,newSex,newPhoneNumber,newIdNumber,newSection,newPosition);
        employeeManageView();

    }

    public static void updateEmployeePasswordView() {
        System.out.println("请输入要修改的员工id：");
        Integer inputId =Integer.parseInt(sc.nextLine());
        System.out.println("请输入新密码：");
        String newPassword = sc.nextLine();
        EmployeeManageService.updateEmployeePassword(inputId,newPassword);
        employeeManageView();

    }

    public static void updateEmployeeIsManager() {
        System.out.println("请输入要修改的员工id：");
        Integer inputId =Integer.parseInt(sc.nextLine());
        System.out.println("请输入y/n以确认是否将其设为管理员");
        String  inputKey = sc.nextLine();
        if (inputKey.equals("y")){
            EmployeeManageService.updateEmployeeIsManager(inputId);
            employeeManageView();
        }else if (inputKey.equals("n")){
            System.out.println("未修改");
        }else {
            System.out.println("输入指令错误，未修改");
        }
        employeeManageView();
    }

    public static void addEmployeeView() {
        System.out.println("请输入员工id：");
        Integer inputId =Integer.parseInt(sc.nextLine());
        System.out.println("请输入员工密码：");
        String inputPassword = sc.nextLine();
        System.out.println("请输入基础信息：");
        System.out.println("请输入姓名：");
        String newName = sc.nextLine();
        System.out.println("请输入性别：");
        String newSex = sc.nextLine();
        System.out.println("请输入手机号：");
        String newPhoneNumber = sc.nextLine();
        System.out.println("请输入身份证：");
        String newIdNumber = sc.nextLine();
        System.out.println("请输入部门编号：");
        Integer newSection = Integer.parseInt(sc.nextLine());
        System.out.println("请输入职位编号：");
        Integer newPosition = Integer.parseInt(sc.nextLine());
        System.out.println("请输入true/false以确认是否将其设为管理员");
        Boolean inputKey = Boolean.parseBoolean(sc.nextLine());
        EmployeeManageService.addEmployee(inputId,inputPassword,newName,newSex,newPhoneNumber,newIdNumber,newSection,newPosition,inputKey);
    }
}
