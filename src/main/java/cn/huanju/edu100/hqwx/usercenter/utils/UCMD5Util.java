package cn.huanju.edu100.hqwx.usercenter.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-09
 */
public class UCMD5Util {
    static String CHARSET_UTF8 = "UTF-8";
    static Charset UTF8;
    public static char[] hexChar;

    public UCMD5Util() {
    }

    public static String generateMD5(byte[] source) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte[] tmp = md.digest();
            char[] str = new char[32];
            int k = 0;

            for(int i = 0; i < 16; ++i) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            return new String(str);
        } catch (Exception var8) {
            return "";
        }
    }

    public static String generateMD5(String str) {
        return generateMD5(str.getBytes(UTF8));
    }

    static {
        UTF8 = Charset.forName(CHARSET_UTF8);
        hexChar = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }
}
