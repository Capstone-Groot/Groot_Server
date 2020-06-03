package com.groot.demo.util;

public class ResourceManger {

    private static int index = 0;

    public static int getIndex(){
        return index++;
    }
}
