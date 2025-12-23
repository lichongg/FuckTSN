package com.bxkj.student.common.utils;

import com.baidu.mobads.sdk.internal.cm;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class h {
    private static String d(int peiSuSecond) {
        StringBuilder sb;
        String str;
        int i6 = peiSuSecond % 3600;
        int i7 = i6 / 60;
        if (i7 > 9) {
            sb = new StringBuilder();
            sb.append(i7);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i7);
        }
        String sb2 = sb.toString();
        int i8 = i6 % 60;
        if (i8 > 9) {
            str = i8 + "";
        } else {
            str = "0" + i8;
        }
        return sb2 + "'" + str + "\"";
    }

    public static String e(int recordingTime) {
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        int i6 = recordingTime / 3600;
        if (i6 > 9) {
            sb = new StringBuilder();
            sb.append(i6);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i6);
        }
        String sb3 = sb.toString();
        int i7 = recordingTime % 3600;
        int i8 = i7 / 60;
        if (i8 > 9) {
            sb2 = new StringBuilder();
            sb2.append(i8);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(i8);
        }
        String sb4 = sb2.toString();
        int i9 = i7 % 60;
        if (i9 > 9) {
            str = i9 + "";
        } else {
            str = "0" + i9;
        }
        return sb3 + ":" + sb4 + ":" + str;
    }

    public static String f() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String a(double distance, double time) {
        double d6 = distance / 1000.0d;
        double d7 = time / 3600.0d;
        if (d6 > 0.0d) {
            return new DecimalFormat("0.00").format(d6 / d7);
        }
        return cm.f10901d;
    }

    public static String b(double distance, int time) {
        double round = Math.round((distance / 1000.0d) * 100.0d) / 100.0d;
        if (round > 0.0d) {
            return d((int) (time / round));
        }
        return "0'0\"";
    }

    public static String c(double distance) {
        double round = Math.round((distance / 1000.0d) * 100.0d) / 100.0d;
        if (round > 0.0d) {
            return String.valueOf(round);
        }
        return "0.00";
    }
}
