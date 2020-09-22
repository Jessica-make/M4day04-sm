package org.spoto.utils;

/**
 * 字符串工具类
 */
public class StringUtils {

    /**
     * 判断是否全部不为空;
     * @param arr  多个字符串;
     * @return  false或者true;
     */
    public static boolean isAllNotEmpty(String...arr){
        for (String str:arr){
            if (isEmpty(str)){
               return false;
            }
        }
               return true;
    }

    /**
     * 判断是否为空;
     * @param str 字符串;
     * @return  false;
     */

    public static boolean isEmpty(String str){
         return "".equals(str)||str==null;
    }

    /**
     *  判断不是空的;
     * @param str  字符串;
     * @return false;
     */
    public static boolean isNotEmpty(String str){
           return !isEmpty(str);
    }
}
