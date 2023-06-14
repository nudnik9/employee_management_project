package com.iweb.service;

import com.iweb.DAO.PositionImpl;
import com.iweb.pojo.Position;
import com.iweb.view.MainView;

import java.util.List;

/**
 * @author k
 * @date 2023/6/13 12:35
 */
public class PositionManageService {
    public static void addPosition(String newPositionName) {
        Position position = new Position(newPositionName);
        MainView.positionDao.addPosition(position);
    }

    public static void searchAllPosition() {
        List<Position> positionList = MainView.positionDao.searchAllPosition();
        for (Position position : positionList) {
            System.out.println(position.printPosition());
        }
    }

    public static void searchPositionByName(String inputPositionName) {
        List<Position> positionList = MainView.positionDao.searchPositionByPositionName(inputPositionName);
        if (positionList != null) {
            for (Position position : positionList) {
                System.out.println(position.printPosition());
            }
        }else {
            System.out.println("无");
        }
    }

    public static void updatePosition(Integer inputId, String newPositionName) {
        PositionImpl p = (PositionImpl) MainView.positionDao;
        Position position = p.searchPositionNameByPid(inputId);
        if (position==null){
            System.out.println("没有该职位");
            return;
        }
        position.setPName(newPositionName);
        MainView.positionDao.updatePosition(position);
    }

    public static void deletePosition(Integer inputId) {
        PositionImpl p = (PositionImpl) MainView.positionDao;
        Position position = p.searchPositionNameByPid(inputId);
        if (position==null){
            System.out.println("没有该职位");
            return;
        }
        MainView.positionDao.deletePosition(position);
    }
}
