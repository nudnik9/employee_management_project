package com.iweb.controller;

import com.iweb.view.EmployeeManageView;
import com.iweb.view.ManagerView;
import com.iweb.view.SectionManageView;

/**
 * @author k
 * @date 2023/6/13 10:18
 */
public class SectionManageController {
    public static void sectionManageController(String inputKey) {
        switch (inputKey) {
            case "1":
                System.out.println("即将跳转到添加部门界面");
                SectionManageView.addSectionView();
                break;
            case "2":
                System.out.println("即将跳转到查询所有部门界面");
                SectionManageView.searchAllSectionView();
                break;
            case "3":
                System.out.println("即将跳转到根据名称查询部门界面");
                SectionManageView.searchSectionByNameView();
                break;
            case "4":
                System.out.println("即将跳转到修改部门界面");
                SectionManageView.updateSectionView();
                break;
            case "5":
                System.out.println("即将跳转到删除部门界面");
                SectionManageView.deleteSection();
                break;
            case "6":
                System.out.println("正在退出部门管理");
                ManagerView.managerView();
                break;
            default:
                System.out.println("输入有误，请重新输入");
                SectionManageView.sectionManageView();
        }
    }
}
