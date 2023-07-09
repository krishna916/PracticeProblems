package com.krishnamurti;

public class Util {

    public static void convertToJavaArray(String s) {
        s = s.replace("[", "{").replace("]", "}");
        System.out.println(s);
    }

}
