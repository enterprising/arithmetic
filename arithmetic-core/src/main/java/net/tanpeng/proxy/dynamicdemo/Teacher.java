package net.tanpeng.proxy.dynamicdemo;

/**
 * Created by peng.tan on 2019/4/16.
 */
public class Teacher implements People {

    @Override
    public String work() {
        System.out.println("老师教书育人！");
        return "老师";
    }
}
