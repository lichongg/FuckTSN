package com.tsn.chat.utils;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String b() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static String c() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String d() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static String e() {
        return new SimpleDateFormat("yyyyMMddHHmmssms").format(new Date());
    }

    public static String f() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
    }

    public static void g(String[] strArr) {
        PrintStream printStream = System.out;
        c();
        printStream.getClass();
    }
}
