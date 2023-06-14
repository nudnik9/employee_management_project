package com.iweb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 * @author k
 * @date 2023/6/14 11:08
 */
public class StringIsNumber {
    /**判断一个字符串中是否全是数字
     * @param string 要确认的字符串
     * @return 返回是否是全数字
     */
    public static Boolean isNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**判断输入是否符合身份证规范
     * @param inputIdNumber 要验证的信息
     * @return 返回是否符合身份证规范
     */
    public static Boolean isIdCard(String inputIdNumber){
        if (inputIdNumber.length() != 18) {
            System.out.println("输入信息有误，身份证号应为18位");
            return false;
        } else {
            if (Character.isDigit(inputIdNumber.charAt(17)) || inputIdNumber.charAt(17) == 'x') {
                String id = inputIdNumber.substring(0, 17);
                if (!StringIsNumber.isNumber(id)) {
                    System.out.println("身份证格式错误，前十七位应全是数字");
                    return false;
                }
            } else {
                System.out.println("身份证格式错误，第十八位可能是x或数字。");
                return false;
            }
        }
        return true;
    }
}
