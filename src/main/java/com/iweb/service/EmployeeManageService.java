package com.iweb.service;

import com.iweb.DAO.PositionImpl;
import com.iweb.DAO.SectionImpl;
import com.iweb.pojo.Employee;
import com.iweb.pojo.Position;
import com.iweb.pojo.Section;
import com.iweb.util.StringIsNumber;
import com.iweb.view.MainView;

import java.util.List;

/**
 * @author k
 * @date 2023/6/13 9:17
 */
public class EmployeeManageService {

    public static void searchAllEmployee() {
        List<Employee> employeeList = MainView.employeeDao.searchAllEmployee();
        if (employeeList != null) {
            for (Employee e:employeeList) {
                System.out.println(e.printEmployee());
            }
        } else {
            System.out.println("无");
        }
    }

    public static void searchEmployeeByName(String inputName) {
        List<Employee> employeeList = MainView.employeeDao.searchEmployeeByName(inputName);
        if (employeeList != null) {
            for (Employee employee : employeeList) {
                System.out.println(employee.printEmployee());
            }
        } else {
            System.out.println("无");
        }
    }

    public static void searchEmployeeById(Integer inputId) {
        Employee employee = MainView.employeeDao.searchEmployeeById(inputId);
        if (employee == null) {
            System.out.println("无");
        } else {
            System.out.println(employee.printEmployee());
        }
    }

    public static void searchEmployeeByIsManager(String inputKey) {
        if ("true".equals(inputKey)) {
            System.out.println(MainView.employeeDao.searchEmployeeByIsManager(true));
        } else {
            System.out.println(MainView.employeeDao.searchEmployeeByIsManager(false));
        }
    }


    public static void searchEmployeeByIdNumber(String inputIdNumber) {
        List<Employee> employeeList = MainView.employeeDao.searchEmployeeByIdNumber(inputIdNumber);
        if (StringIsNumber.isIdCard(inputIdNumber)) {
            if (employeeList != null) {
                for (Employee employee : employeeList) {
                    System.out.println(employee.printEmployee());
                }
            } else {
                System.out.println("无");
            }
        }
    }

    public static void searchEmployeeBySex(String inputSex) {
        List<Employee> employeeList = MainView.employeeDao.searchEmployeeBySex(inputSex);
        if ("男".equals(inputSex)|| "女".equals(inputSex)){
            if (employeeList != null) {
                for (Employee employee : employeeList) {
                    System.out.println(employee.printEmployee());
                }
            } else {
                System.out.println("无");
            }
        }else {
            System.out.println("输入信息有误");
        }

    }

    public static void searchEmployeeBySection(String inputSection) {
        SectionImpl s = (SectionImpl) MainView.sectionDao;
        Integer inputSectionId = s.searchSectionIdByName(inputSection);
        if (inputSectionId==null){
            System.out.println("该部门不存在");
            return ;
        }
        List<Employee> employeeList = MainView.employeeDao.searchEmployeeBySection(inputSectionId);
        if (employeeList != null) {
            for (Employee employee : employeeList) {
                System.out.println(employee.printEmployee());
            }
        } else {
            System.out.println("无");
        }
    }

    public static void searchEmployeeByPosition(String inputPosition) {
        PositionImpl p = (PositionImpl) MainView.positionDao;
        Integer inputPositionId = p.searchPositionIdByName(inputPosition);
        if (inputPositionId==null){
            System.out.println("该部门不存在");
            return ;
        }
        List<Employee> employeeList = MainView.employeeDao.searchEmployeeBySection(inputPositionId);
        if (employeeList != null) {
            for (Employee employee : employeeList) {
                System.out.println(employee.printEmployee());
            }
        } else {
            System.out.println("无");
        }
    }

    public static void deleteEmployee(Integer inputId) {
        Employee employee = MainView.employeeDao.searchEmployeeById(inputId);
        if (employee==null){
            System.out.println("该员工不存在");
            return;
        }
        MainView.employeeDao.deleteEmployee(employee);
        System.out.println("账户已删除...");
    }

    public static void updateEmployeeBasicInformation(Integer inputId, String newName, String newSex, String newPhoneNumber, String newIdNumber, String newSection, String newPosition) {
        Employee employee = MainView.employeeDao.searchEmployeeById(inputId);
        if (inputId.toString().length()>11){
            System.out.println("输入员工id不能大于11位");
            return;
        }
        if (employee==null){
            System.out.println("没有id为"+inputId+"的员工");
            return;
        }
        if (!"男".equals(newSex)&&!"女".equals(newSex)){
            System.out.println("请输入正确的性别");
            return;
        }
        if (newPhoneNumber.length()!=11){
            System.out.println("手机号应该是11位数字");
            return;
        }else {
            if(!StringIsNumber.isNumber(newPhoneNumber)){
                System.out.println("手机号中应该是纯数字");
                return;
            }
        }
        if (!StringIsNumber.isIdCard(newIdNumber)){
            return;
        }
        employee.setEName(newName);
        employee.setESex(newSex);
        employee.setEPhoneNumber(newPhoneNumber);
        employee.setEIdNumber(newIdNumber);
        PositionImpl p = (PositionImpl) MainView.positionDao;
        SectionImpl s = (SectionImpl) MainView.sectionDao;
        Integer sId =s.searchSectionIdByName(newSection);
        Integer pId =p.searchPositionIdByName(newPosition);
        if (sId==null){
            System.out.println("没有该部门");
            return;
        }
        if (pId==null){
            System.out.println("没有改职位");
            return;
        }
        employee.setSId(sId);
        employee.setPId(pId);
        MainView.employeeDao.updateEmployeeBasicInformation(employee);
    }

    public static void updateEmployeePassword(Integer inputId, String newPassword) {
        Employee employee = MainView.employeeDao.searchEmployeeById(inputId);
        if (employee==null){
            System.out.println("没有该员工");
            return;
        }
        employee.setEPassword(newPassword);
        MainView.employeeDao.updateEmployeePassword(employee);
    }

    public static void updateEmployeeIsManager(Integer inputId) {
        Employee employee = MainView.employeeDao.searchEmployeeById(inputId);
        if (employee==null){
            System.out.println("没有该员工");
            return;
        }
        employee.setIsManager(true);
        MainView.employeeDao.updateEmployeeIsManager(employee);
        System.out.println("已修改");
    }


    public static void addEmployee(Integer inputId, String inputPassword, String newName,
                                   String newSex, String newPhoneNumber, String newIdNumber,
                                   Integer newSection, Integer newPosition, Boolean inputKey) {
        if (inputId.toString().length()>11){
            System.out.println("输入员工id不能大于11位");
            return;
        }
        if (!"男".equals(newSex)&&!"女".equals(newSex)){
            System.out.println("请输入正确的性别");
            return;
        }
        if (newPhoneNumber.length()!=11){
            System.out.println("手机号应该是11位数字");
            return;
        }else {
            if(!StringIsNumber.isNumber(newPhoneNumber)){
                System.out.println("手机号中应该是纯数字");
                return;
            }
        }
        if (!StringIsNumber.isIdCard(newIdNumber)){
            return;
        }
        boolean containSection = false;
        List<Section> sectionList = MainView.sectionDao.searchAllSection();
        for (Section s:sectionList){
            if (newSection.equals(s.getSId())){
                containSection = true;
                break;
            }
        }
        if (!containSection){
            System.out.println("没有该部门");
            return;
        }
        boolean containPosition = false;
        List<Position> positionList = MainView.positionDao.searchAllPosition();
        for (Position p:positionList){
            if (newPosition.equals(p.getPId())){
                containPosition = true;
                break;
            }
        }
        if (!containPosition){
            System.out.println("没有该职位");
            return;
        }
        Employee employee = new Employee(inputId, inputPassword, newName, newSex, newPhoneNumber,
                newIdNumber, newSection, newPosition, inputKey);
        MainView.employeeDao.addEmployee(employee);
    }
}
