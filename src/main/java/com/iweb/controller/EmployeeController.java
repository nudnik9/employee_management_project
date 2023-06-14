package com.iweb.controller;

import com.iweb.App;
import com.iweb.view.AnnouncementManageView;
import com.iweb.view.EmployeeView;
import com.iweb.view.MainView;
import com.iweb.view.EmployeeManageView;

/**
 * @author k
 * @date 2023/6/12 19:45
 */
public class EmployeeController {
    public static void employeeController(String inputKey) {
        switch (inputKey) {
            case "1":
                //查看自身信息
                System.out.println("当前账户信息如下：");
                EmployeeView.showInformationView();
                break;
            case "2":
                //更改基础信息
                System.out.println("即将跳转到更改基础信息页面...");
                EmployeeView.changeBasicInformationView();
                break;
            case "3":
                //更改密码
                System.out.println("即将进入更改密码界面...");
                EmployeeView.changePasswordView();
                break;
            case "4":
                System.out.println("查看公告");
                AnnouncementManageView.searchAnnouncementView();
                break;
            case "5":
                System.out.println("删除账号");
                EmployeeView.deleteEmployeeView();
                break;
            case "6":
                System.out.println("退出当前账号");
                MainView.mainView();
                break;
            default:
                //打印提示 重新回到主页面
                System.out.println("输入指令有误,请重新输入");
                EmployeeView.employeeView();
        }
    }

}
