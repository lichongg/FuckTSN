package com.bytedance.msdk.core.tl;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {
    public static long j(long j6) {
        Date date = new Date();
        return j((j6 < 3600000 ? date.getMinutes() <= 30 ? new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 0, 0) : new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 30, 0) : new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 0, 0)).getTime(), j6);
    }

    public static String xt(long j6) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j6));
    }

    private static long j(long j6, long j7) {
        Date date = new Date(j7 + j6);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalEffectiveTime", "old time " + j6 + " new time = " + simpleDateFormat.format(date) + " 毫秒 = " + time);
        return time;
    }
}
