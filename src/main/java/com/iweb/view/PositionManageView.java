package com.iweb.view;

import com.iweb.controller.PositionManageController;
import com.iweb.pojo.Position;
import com.iweb.service.PositionManageService;

import java.util.Scanner;

/**
 * @author k
 * @date 2023/6/13 8:38
 */
public class PositionManageView {
    private static Scanner sc = new Scanner(System.in);
    public static void positionManageView(){
        System.out.println("------职位管理--------");
        System.out.println("请选择要进行的操作");
        System.out.println("1.添加职位");
        System.out.println("2.查询所有职位");
        System.out.println("3.根据名称查询职位");
        System.out.println("4.修改职位");
        System.out.println("5.删除职位");
        System.out.println("6.退出职位管理");
        String inputKey = sc.nextLine();
        PositionManageController.positionManageController(inputKey);
    }
    public static void addPositionView() {
        System.out.println("请输入新部门名称：");
        String newPositionName = sc.nextLine();
        PositionManageService.addPosition(newPositionName);
        positionManageView();
    }

    public static void searchAllPositionView() {
        System.out.println("以下是所有部门信息：");
        PositionManageService.searchAllPosition();
        positionManageView();
    }

    public static void searchPositionByNameView() {
        System.out.println("请输入要查询的部门名称：");
        String inputPositionName = sc.nextLine();
        PositionManageService.searchPositionByName(inputPositionName);
        positionManageView();
    }

    public static void updatePositionView() {
        System.out.println("请输入要修改的部门id：");
        Integer inputId = (Integer.parseInt(sc.nextLine()));
        System.out.println("请输入部门新名称：");
        String newPositionName = sc.nextLine();
        PositionManageService.updatePosition(inputId, newPositionName);
        positionManageView();
    }

    public static void deletePosition() {
        System.out.println("请输入要删除的部门id：");
        Integer inputId = (Integer.parseInt(sc.nextLine()));
        PositionManageService.deletePosition(inputId);
        positionManageView();
    }
}
