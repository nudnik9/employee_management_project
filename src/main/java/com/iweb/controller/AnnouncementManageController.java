package com.iweb.controller;

import com.iweb.App;
import com.iweb.view.AnnouncementManageView;
import com.iweb.view.EmployeeView;
import com.iweb.view.ManagerView;

/**
 * @author k
 * @date 2023/6/13 12:50
 */
public class AnnouncementManageController {

    public static void announcementManageController(String inputKey) {
        switch (inputKey){
            case "1":
                //添加公告
                System.out.println("即将跳转到添加公告界面");
                AnnouncementManageView.addAnnouncementView();
                break;
            case "2":
                //修改公告
                System.out.println("即将跳转到修改公告界面");
                AnnouncementManageView.updateAnnouncementView();
                break;
            case "3":
                //查询公告
                System.out.println("即将跳转到查询公告界面");
                AnnouncementManageView.searchAnnouncementView();
                break;
            case "4":
                //退出公告管理
                System.out.println("正在退出...");
                ManagerView.managerView();
                break;
            default:
                System.out.println("指令有误，请重输：");
                AnnouncementManageView.announcementManageView();
        }
    }

    public static void searchAnnouncementController(String inputKey) {
        switch(inputKey) {
            case "1":
                //查询所有公告
                System.out.println("查询所有公告");
                AnnouncementManageView.searchAllAnnouncementView();
                break;
            case "2":
                //根据输入标题,查询公告
                System.out.println("根据输入标题查询公告");
                AnnouncementManageView.searchAnnouncementByHeadlineView();
                break;
            case "3":
                //根据输入内容,查询公告
                System.out.println("根据输入内容查询公告");
                AnnouncementManageView.searchAnnouncementByContentView();
                break;
            case "4":
                System.out.println("正在退出公告查询界面...");
                if (App.currentEmployee.getIsManager()) {
                    AnnouncementManageView.announcementManageView();
                }
                EmployeeView.employeeView();
                break;
            default:
                //打印提示
                System.out.println("输入指令有误,请重新输入");
                AnnouncementManageView.searchAnnouncementView();
        }
    }
}
