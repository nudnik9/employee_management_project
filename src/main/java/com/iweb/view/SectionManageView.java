package com.iweb.view;

import com.iweb.controller.SectionManageController;
import com.iweb.service.SectionManageService;

import java.util.Scanner;

/**
 * @author k
 * @date 2023/6/13 8:37
 */
public class SectionManageView {
    private static Scanner sc = new Scanner(System.in);

    public static void sectionManageView() {
        System.out.println("-------部门管理-------");
        System.out.println("请选择要进行的操作");
        System.out.println("1.添加部门");
        System.out.println("2.查询所有部门");
        System.out.println("3.根据名称查询部门");
        System.out.println("4.修改部门");
        System.out.println("5.删除部门");
        System.out.println("6.退出部门管理");
        String inputKey = sc.nextLine();
        SectionManageController.sectionManageController(inputKey);
    }

    public static void addSectionView() {
        System.out.println("请输入新部门名称：");
        String newSectionName = sc.nextLine();
        SectionManageService.addSection(newSectionName);
        sectionManageView();
    }

    public static void searchAllSectionView() {
        System.out.println("以下是所有部门信息：");
        SectionManageService.searchAllSection();
        sectionManageView();
    }

    public static void searchSectionByNameView() {
        System.out.println("请输入要查询的部门名称：");
        String inputSectionName = sc.nextLine();
        SectionManageService.searchSectionByName(inputSectionName);
        sectionManageView();
    }

    public static void updateSectionView() {
        System.out.println("请输入要修改的部门id：");
        Integer inputId = (Integer.parseInt(sc.nextLine()));
        System.out.println("请输入部门新名称：");
        String newSectionName = sc.nextLine();
        SectionManageService.updateSection(inputId, newSectionName);
        sectionManageView();
    }

    public static void deleteSection() {
        System.out.println("请输入要删除的部门id：");
        Integer inputId = (Integer.parseInt(sc.nextLine()));
        SectionManageService.deleteSection(inputId);
        sectionManageView();
    }
}
