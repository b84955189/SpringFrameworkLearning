package top.lking.aspect;

import java.util.Date;

public class LogAspect {
    public void printLogStart(){
        System.out.println("开始日志记录时间："+new Date().toGMTString());
    }
    public void printLogEnd(){
        System.out.println("结束日志记录时间："+new Date().toGMTString());
    }
}
