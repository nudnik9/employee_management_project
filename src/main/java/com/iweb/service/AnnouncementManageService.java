package com.iweb.service;

import com.iweb.pojo.Announcement;
import com.iweb.view.MainView;
import com.iweb.view.ManagerView;

import java.util.List;

/**
 * @author k
 * @date 2023/6/13 13:06
 */
public class AnnouncementManageService {
    public static void searchAllAnnouncement() {
        List<Announcement> announcementList = MainView.announcementDao.searchAllAnnouncement();
        for (Announcement announcement : announcementList) {
            announcement.printAnnouncement();
        }
    }

    public static void searchAnnouncementByHeadline(String inputHeadline) {
        List<Announcement> announcementList = MainView.announcementDao.searchAnnouncementByHeadline(inputHeadline);
        if (announcementList==null){
            System.out.println("没有该公告");
            return;
        }
        for (Announcement announcement : announcementList) {
            announcement.printAnnouncement();
        }
    }

    public static void searchAnnouncementByContent(String inputContent) {
        List<Announcement> announcementList = MainView.announcementDao.searchAnnouncementByContent(inputContent);
        if (announcementList==null){
            System.out.println("没有该公告");
            return;
        }
        for (Announcement announcement : announcementList) {
            announcement.printAnnouncement();
        }
    }

    public static void addAnnouncement(String inputHeadline, String inputContent) {
        Announcement announcement = new Announcement(inputHeadline,inputContent);
        MainView.announcementDao.addAnnouncement(announcement);
    }

    public static void updateAnnouncement(Integer inputId,String inputHeadline,String inputContent){
        Announcement announcement = MainView.announcementDao.searchAnnouncementById(inputId);
        if (announcement==null){
            System.out.println("没有该公告");
            return;
        }
        announcement.setAHeadline(inputHeadline);
        announcement.setAContent(inputContent);
        MainView.announcementDao.updateAnnouncement(announcement);
    }
}
