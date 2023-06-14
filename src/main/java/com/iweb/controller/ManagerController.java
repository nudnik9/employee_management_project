package com.iweb.controller;

import com.iweb.App;
import com.iweb.view.*;

/**
 * @author k
 * @date 2023/6/12 19:57
 */
public class ManagerController {
    public static void managerController(String inputKey) {
        switch (inputKey){
            case "1":
                System.out.println("即将进入用户管理界面...");
                EmployeeManageView.employeeManageView();
                break;
            case "2":
                System.out.println("即将进入部门管理界面");
                SectionManageView.sectionManageView();
                break;
            case "3":
                System.out.println("即将进入职位管理界面");
                PositionManageView.positionManageView();
                break;
            case "4":
                System.out.println("即将进入公告管理界面");
                AnnouncementManageView.announcementManageView();
                break;
            case "5":
                System.out.println("即将退出登录");
                App.currentEmployee=null;
                MainView.mainView();
                break;
            default:
                System.out.println("输入错误请重新输入");
                ManagerView.managerView();
        }
    }
}
