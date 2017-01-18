package com.String.util;

/**
 * Created for
 * Created by w_yusys2 on 2017/1/16.
 */
public class StringUtil {
        public static void replaceSpace(){
            String s = "Filesystem            Size  Used Avail Use% Mounted on";
            System.out.println("1" + s.replaceAll(" +"," ") + "2");
            System.out.println("1" + s.replace(" +"," ") + "2");
        }

        public static void main(String[] args){
            new StringUtil().replaceSpace();
        }
}
