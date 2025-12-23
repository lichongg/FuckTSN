package com.autonavi.aps.amapapi.utils;

import java.util.Calendar;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c {
    public static long a(long j6, long j7, int i6) {
        if (i6 <= 0) {
            return j6;
        }
        try {
            return Math.abs(j6 - j7) > ((long) i6) * 31536000000L ? a(j6, j7) : j6;
        } catch (Throwable unused) {
            return j6;
        }
    }

    private static long a(long j6, long j7) {
        long b6 = b(j7) + a(j6);
        long abs = Math.abs(b6 - j7);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(b6));
        int i6 = calendar.get(11);
        if (i6 == 23 && abs >= 82800000) {
            b6 -= 86400000;
        }
        return (i6 != 0 || abs < 82800000) ? b6 : b6 + 86400000;
    }

    private static long b(long j6) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j6));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static long a(long j6) {
        return j6 - b(j6);
    }
}
