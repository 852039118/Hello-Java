package com.warren.util;

import sun.misc.BASE64Decoder;

import java.io.IOException;

public class EncodingUtils {
    /**
     *  将字符串按指定格式解码编码。
     * @param str               需要处理的字符串
     * @param charset           原编码格式
     * @param returnCharset     返回编码格式
     * @return                  解码编码后的字符串
     * @throws IOException
     */
    public static String encodingCharset(String str,String charset,String returnCharset ) {
        try {
            // 按原编码拆分为bytes
            byte[] bytes = str.getBytes(charset);
            str = new sun.misc.BASE64Encoder().encode(bytes);

            //BASE64解码
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = decoder.decodeBuffer(str);
            // 再编码为utf-8
            str = new String(b,returnCharset);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 输出结果
            return str;
        }
    }
}
