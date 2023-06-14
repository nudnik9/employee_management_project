package com.iweb.util;

import com.iweb.pojo.Employee;
import com.iweb.view.MainView;

import java.util.List;

/**
 * @author k
 * @date 2023/6/12 16:17
 */
public class EidIsExistUtil {
    public static Boolean eidIsExist(Employee employee) {
        List<Employee> employeeList = MainView.employeeDao.searchAllEmployee();
        boolean isExist = false;
        for (Employee e : employeeList) {
            if (e.getEId().equals(employee.getEId())) {
                System.out.println("用户id已存在");
                isExist=true;
            }
        }
        return isExist;
    }
}
