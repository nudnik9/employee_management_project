package com.iweb.util;

import java.util.Random;

/**
 * @author k
 * @date 2023/6/12 15:30
 */
public class RandomStringUtil {
    public static String getRandomStr() {
        Random r = new Random();
        StringBuilder strPool = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            if (Character.isLetterOrDigit((char) i)) {
                strPool.append((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(strPool.charAt(r.nextInt(strPool.length())));
        }
        return sb.toString();

    }

}
