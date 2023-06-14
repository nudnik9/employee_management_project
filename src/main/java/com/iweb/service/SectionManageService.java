package com.iweb.service;

import com.iweb.DAO.SectionImpl;
import com.iweb.pojo.Section;
import com.iweb.view.MainView;

import java.util.List;

/**
 * @author k
 * @date 2023/6/13 11:45
 */
public class SectionManageService {
    public static void addSection(String newSectionName) {
        Section section = new Section(newSectionName);
        MainView.sectionDao.addSection(section);
    }

    public static void searchAllSection() {
        List<Section> sectionList = MainView.sectionDao.searchAllSection();
        for (Section section:sectionList) {
            System.out.println(section.printSection());
        }
    }

    public static void searchSectionByName(String inputSectionName) {
        List<Section> sectionList = MainView.sectionDao.searchSectionBySectionName(inputSectionName);
        if (sectionList!=null) {
            for (Section section : sectionList) {
                System.out.println(section.printSection());
            }
        }
        else {
            System.out.println("无");
        }
    }

    public static void updateSection(Integer inputId,String newSectionName) {
        SectionImpl s = (SectionImpl)MainView.sectionDao;
        Section section = s.searchSectionBySid(inputId);
        if (section==null){
            System.out.println("没有该部门");
            return;
        }
        section.setSName(newSectionName);
        MainView.sectionDao.updateSection(section);
    }

    public static void deleteSection(Integer inputId) {
        SectionImpl s = (SectionImpl)MainView.sectionDao;
        Section section = s.searchSectionBySid(inputId);
        if (section==null){
            System.out.println("没有该部门");
            return;
        }
        MainView.sectionDao.deleteSection(section);
    }
}
