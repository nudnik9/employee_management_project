package com.iweb.view;

import com.iweb.App;
import com.iweb.DAO.*;
import com.iweb.controller.MainController;
import com.iweb.pojo.Announcement;
import com.iweb.service.MainService;
import com.iweb.util.RandomStringUtil;

import java.util.Scanner;

/**
 * @author k
 * @date 2023/6/12 14:34
 */
public class MainView {
    public static EmployeeDao employeeDao = new EmployeeImpl();
    public static PositionDao positionDao = new PositionImpl();
    public static SectionDao sectionDao = new SectionImpl();
    public static AnnouncementDao announcementDao = new AnnouncementImpl();

    private static Scanner sc = new Scanner(System.in);
    /**首页*/
    public static void mainView(){
        System.out.println("---------------------");
        System.out.println("欢迎来到用户管理系统");
        System.out.println("请输入操作序号：");
        System.out.println("1.登录");
        System.out.println("2.注册");
        String mainInputKey = sc.nextLine();
        MainController.mainController(mainInputKey);
    }
    public static void loginView(){
        System.out.println("请输入账号:");
        Integer inputEid = Integer.parseInt(sc.nextLine());
        System.out.println("请输入密码:");
        String inputPassword = sc.nextLine();
        //获取验证码:如果发现验证码不对 则直接重新登录
        String confirmCode = RandomStringUtil.getRandomStr();
        System.out.println("验证码为:"+confirmCode+",请输入验证码进行验证,验证码不区分大小写");
        String inputConfirmCode = sc.nextLine();
        if(confirmCode.equalsIgnoreCase(inputConfirmCode)){
            //验证码验证通过
            System.out.println("验证码通过,正在验证用户名和密码,请稍后...");
            boolean isLogin = MainService.login(inputEid,inputPassword);
            //如果登录成功,则跳转到下一级页面
            if(isLogin){
                //跳转到下一级页面
                //先判断是否是管理员
                if (App.currentEmployee.getIsManager()){
                    //进入管理员界面
                    ManagerView.managerView();
                }else {
                    //普通员工界面
                    EmployeeView.employeeView();
                }
            }else {
                //否则 返回登录界面
                System.out.println("账号或密码错误，即将返回登录界面。。。");
                mainView();
            }
        }else {
            //直接要求用户重新输入用户名 密码 新的验证码
            System.out.println("验证码输入有误,请重新输入!");
            loginView();
        }
    }
    public static void registerView(){
        System.out.println("请输入用户账号：");
        Integer inputEid = Integer.parseInt(sc.nextLine());
        System.out.println("请输入用户密码：");
        String inputPassword = sc.nextLine();
        System.out.println("请输入真实姓名：");
        String inputName = sc.nextLine();
        if (MainService.register(inputEid,inputPassword,inputName)){
            System.out.println("注册成功，即将返回登录界面");
            mainView();
        }else {
            System.out.println("请重新输入用户账号密码");
            registerView();
        }
    }
}
