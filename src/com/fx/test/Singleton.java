package com.fx.test;

/**
 * Created by susunsheng on 2017/12/8.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
public class Singleton {
    public    static Singleton singleton = new Singleton();
    public static Map m;
    static{
        m = new HashMap();
        System.out.println("static");
    }
    private Singleton(){
        initM();
        System.out.println("Singleton");
    }
    public static void initM(){
        if(null == m){
            System.out.println("m 为空");
            m = new HashMap();
        }
        m.put("1", "郑");
        m.put("2", "陈");
    }
    public static Singleton getInstance(){
        return singleton;
    }
}