package cn.jiguang.bz;

import android.util.Pair;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<Object, Pair<Long, Integer>> f2765a = new HashMap<>();

    public static boolean a(Object obj) {
        return a(obj, 0L);
    }

    public static boolean a(Object obj, long j6) {
        return a(obj, j6, 0);
    }

    public static boolean a(Object obj, long j6, int i6) {
        int i7;
        Pair<Long, Integer> pair;
        if (j6 <= 0) {
            j6 = 3600000;
        }
        if (i6 <= 0) {
            i6 = Integer.MAX_VALUE;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!f2765a.containsKey(obj) || (pair = f2765a.get(obj)) == null) {
                i7 = 0;
            } else {
                long longValue = ((Long) pair.first).longValue();
                i7 = ((Integer) pair.second).intValue();
                long abs = Math.abs(currentTimeMillis - longValue);
                cn.jiguang.bb.f.c("ApiFrequency", "check api frequency, functionName: " + obj + "; callApiInternalTimeLimit: " + j6 + ", diffInternalTime: " + abs + "; callApiTimesLimit： " + i6 + ", currentApiCallTimes: " + i7);
                if (abs <= j6 || i7 >= i6) {
                    return true;
                }
            }
            f2765a.put(obj, new Pair<>(Long.valueOf(currentTimeMillis), Integer.valueOf(i7 + 1)));
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("ApiFrequency", "isFrequency failed: " + th.getMessage());
        }
        return false;
    }
}
