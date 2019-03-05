package test;

import test.MyLog;

public class VPractive {

    protected void log(String msg) {
        MyLog.log(msg);
    }

    public static void logd(String msg) {
        MyLog.log(msg);
    }

    protected void logInLine(String msg){
        MyLog.logInLine(msg);
    }

}
