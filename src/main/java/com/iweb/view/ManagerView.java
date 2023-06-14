package com.iweb.view;

import com.iweb.App;
import com.iweb.controller.ManagerController;

import java.util.Scanner;

/**
 * @author k
 * @date 2023/6/12 16:54
 */
public class ManagerView {
    private static Scanner sc = new Scanner(System.in);

    /**
     * 管理员页面
     */
    public static void managerView() {
        System.out.println("---------------------");
        System.out.println("欢迎来到管理员用户界面，请选择你要进行的操作：");
        System.out.println("1.用户管理");
        System.out.println("2.部门管理");
        System.out.println("3.职位管理");
        System.out.println("4.公告管理");
        System.out.println("5.退出登录");
        String inputKey = sc.nextLine();
        ManagerController.managerController(inputKey);
    }
}
