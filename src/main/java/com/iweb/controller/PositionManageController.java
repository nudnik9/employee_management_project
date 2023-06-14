package com.iweb.controller;

import com.iweb.view.ManagerView;
import com.iweb.view.PositionManageView;

/**
 * @author k
 * @date 2023/6/13 12:35
 */
public class PositionManageController {
    public static void positionManageController(String inputKey){
        switch (inputKey) {
            case "1":
                System.out.println("即将跳转到添加部门界面");
                PositionManageView.addPositionView();
                break;
            case "2":
                System.out.println("即将跳转到查询所有部门界面");
                PositionManageView.searchAllPositionView();
                break;
            case "3":
                System.out.println("即将跳转到根据名称查询部门界面");
                PositionManageView.searchPositionByNameView();
                break;
            case "4":
                System.out.println("即将跳转到修改部门界面");
                PositionManageView.updatePositionView();
                break;
            case "5":
                System.out.println("即将跳转到删除部门界面");
                PositionManageView.deletePosition();
                break;
            case "6":
                System.out.println("正在退出部门管理");
                ManagerView.managerView();
                break;
            default:
                System.out.println("输入有误，请重新输入");
                PositionManageView.positionManageView();
        }
    }
}
