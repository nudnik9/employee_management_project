package com.iweb;

import com.iweb.pojo.Employee;
import com.iweb.view.MainView;

/**
 * @author k
 */
public class App {
    public static Employee currentEmployee = null;
    public static void main( String[] args )
    {
        MainView.mainView();
    }
}
