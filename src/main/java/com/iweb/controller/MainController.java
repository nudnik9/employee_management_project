package com.iweb.controller;

import com.iweb.view.MainView;

/**
 * @author k
 * @date 2023/6/12 14:33
 */
public class MainController {
    public static void mainController(String mainInputKey) {
        switch (mainInputKey){
            case "1":
//                跳转到登录页面
                System.out.println("即将跳转到登录页面...");
                MainView.loginView();
                break;
            case "2":
//                跳转到注册页面
                System.out.println("即将跳转到注册页面...");
                MainView.registerView();
                break;
            default:
                //打印提示 重新回到主页面
                System.out.println("输入指令有误,请重新输入");
                MainView.mainView();
        }
    }
}
