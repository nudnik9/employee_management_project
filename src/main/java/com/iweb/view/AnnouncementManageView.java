package com.iweb.view;

import com.iweb.App;
import com.iweb.controller.AnnouncementManageController;
import com.iweb.pojo.Announcement;
import com.iweb.service.AnnouncementManageService;

import java.util.List;
import java.util.Scanner;

/**
 * @author k
 * @date 2023/6/13 8:38
 */
public class AnnouncementManageView {
    private static Scanner sc = new Scanner(System.in);

    public static void announcementManageView() {
        System.out.println("----------公告管理-----------");
        System.out.println("请选择请选择要进行的操作:");
        System.out.println("1.添加公告");
        System.out.println("2.修改公告");
        System.out.println("3.查询公告");
        System.out.println("4.退出公告管理");
        String inputKey = sc.nextLine();
        AnnouncementManageController.announcementManageController(inputKey);
    }


    public static void searchAnnouncementView() {

        System.out.println("---------------------");
        System.out.println("请输入查询公告的方式:");
        System.out.println("1.查询所有公告");
        System.out.println("2.根据输入标题查询公告");
        System.out.println("3.根据输入内容查询公告");
        System.out.println("4.退出公告查询");
        String inputKey = sc.nextLine();
        AnnouncementManageController.searchAnnouncementController(inputKey);

    }

    public static void searchAllAnnouncementView() {
        AnnouncementManageService.searchAllAnnouncement();
        searchAnnouncementView();
    }

    public static void searchAnnouncementByHeadlineView() {
        System.out.println("请输入公告标题:");
        String inputHeadline = sc.nextLine();
        AnnouncementManageService.searchAnnouncementByHeadline(inputHeadline);
        searchAnnouncementView();
    }

    public static void searchAnnouncementByContentView() {
        System.out.println("请输入公告内容:");
        String inputContent = sc.nextLine();
        AnnouncementManageService.searchAnnouncementByContent(inputContent);
        searchAnnouncementView();
    }

    public static void addAnnouncementView() {
        System.out.println("请输入公告标题：");
        String inputHeadline = sc.nextLine();
        System.out.println("请输入公告内容:");
        String inputContent = sc.nextLine();
        AnnouncementManageService.addAnnouncement(inputHeadline,inputContent);
        announcementManageView();
    }

    public static void updateAnnouncementView() {
        System.out.println("请输入要修改的公告id：");
        Integer inputId = Integer.parseInt(sc.nextLine());
        System.out.println("输入新标题：");
        String inputHeadline = sc.nextLine();
        System.out.println("输入新内容：");
        String inputContent = sc.nextLine();
        AnnouncementManageService.updateAnnouncement(inputId,inputHeadline,inputContent);
        announcementManageView();
    }
}
