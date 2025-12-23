package cn.jpush.android.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<Integer, HashMap<Integer, cn.jpush.android.t.a>> f3772a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<Integer, HashMap<Integer, cn.jpush.android.t.a>> f3773b = new HashMap<>();

    private static long a(Context context) {
        long j6 = 0;
        try {
            String b6 = cn.jpush.android.p.a.b(context);
            if (!TextUtils.isEmpty(b6)) {
                String[] split = b6.split(",");
                long parseLong = Long.parseLong(split[0]);
                int parseInt = Integer.parseInt(split[1]);
                Logger.d("InAppHelper", "checkUnionTopBannerTime, topBanner exposureTime: " + parseLong + ", server exposureTime: " + parseInt);
                long currentTimeMillis = System.currentTimeMillis() - (parseLong + 3000);
                if (currentTimeMillis < 0) {
                    currentTimeMillis = 0;
                }
                long j7 = parseInt;
                if (currentTimeMillis < j7) {
                    j6 = j7 - currentTimeMillis;
                }
                Logger.d("InAppHelper", "checkUnionTopBannerTime, should delay time: " + j6 + ", leftTime: " + currentTimeMillis);
            }
        } catch (Throwable unused) {
        }
        return j6;
    }

    public static long b(Context context, long j6) {
        try {
            long a6 = cn.jpush.android.p.a.a(context);
            Logger.d("InAppHelper", "getIntervalTime lastShowMessageTime=" + a6);
            if (a6 <= 0) {
                return j6;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long abs = Math.abs(currentTimeMillis - a6);
            Logger.d("InAppHelper", "getIntervalTime currentTimeMillis=" + currentTimeMillis);
            Logger.d("InAppHelper", "getIntervalTime diff=" + abs);
            if (abs > j6) {
                Logger.d("InAppHelper", "getIntervalTime return value= 0");
                return 0L;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getIntervalTime return value= ");
            long j7 = j6 - abs;
            sb.append(j7);
            Logger.d("InAppHelper", sb.toString());
            return j7;
        } catch (Throwable unused) {
            Logger.d("InAppHelper", "getIntervalTime return intervalTime= " + j6);
            return j6;
        }
    }

    public static long a(Context context, long j6, boolean z5) {
        String str;
        long max = Math.max(System.currentTimeMillis() - cn.jpush.android.s.a.a(), 0L);
        long max2 = Math.max(j6, 0L);
        long a6 = a(context);
        long j7 = z5 ? max2 > max ? max2 - max : 0L : max2;
        long max3 = Math.max(a6, j7);
        Logger.d("InAppHelper", "getDelayDisplayTime - stayForegroundTime: " + max + ", delayDisTime: " + max2 + ", unionDelayTime: " + a6 + ", foreDelayTime: " + j7 + ", realDelayTime: " + max3);
        if (max3 > 0) {
            str = "notify inapp should delay to show, delay time: " + max3 + ", server delay time: " + max2;
        } else {
            str = "notify inapp display directory, stay foreground time: " + max + ", server delay time: " + max2;
        }
        Logger.d("InAppHelper", str);
        return max3;
    }

    private static cn.jpush.android.t.a b(Context context, cn.jpush.android.d.d dVar, int i6) {
        Float valueOf = Float.valueOf(0.3f);
        boolean c6 = cn.jpush.android.u.b.c(i6);
        if (40 != i6 && !c6) {
            return new cn.jpush.android.t.a().e(-1).f(-1);
        }
        DisplayMetrics a6 = m.a(context);
        cn.jpush.android.t.a b6 = new cn.jpush.android.t.a().a(valueOf).b(valueOf).a(Integer.valueOf((int) (a6.heightPixels * 0.5f))).b(Integer.valueOf((int) (a6.widthPixels * 0.9f))).e(-1).f(Integer.valueOf(c6 ? -2 : m.a(context, 94))).c(Integer.valueOf(dVar.aH == 0 ? 48 : 80)).d(65824).a(Integer.valueOf((int) (a6.heightPixels * 0.5f))).b(Integer.valueOf((int) (a6.widthPixels * 0.9f)));
        Boolean bool = Boolean.TRUE;
        return b6.a(true).a(bool).b(bool).b(true).a(dVar.bb * 1000).b(500.0f).c(500.0f);
    }

    public static cn.jpush.android.t.a a(Context context, int i6) {
        HashMap<Integer, cn.jpush.android.t.a> hashMap;
        HashMap<Integer, HashMap<Integer, cn.jpush.android.t.a>> hashMap2;
        String str;
        int i7 = context.getResources().getConfiguration().orientation;
        Logger.d("InAppHelper", "current orientation state: " + i7 + " type=" + i6);
        if (i7 < 0) {
            str = "[getLayoutConfig] get screen orientation failed, curOrientation: " + i7;
        } else {
            if (i7 == 2) {
                hashMap2 = f3773b;
            } else if (i7 == 1) {
                hashMap2 = f3772a;
            } else {
                hashMap = null;
                Logger.d("InAppHelper", "current map: " + hashMap + " type=" + i6);
                if (hashMap == null && hashMap.size() != 0) {
                    return hashMap.get(Integer.valueOf(i7));
                }
                str = "current is null ";
            }
            hashMap = hashMap2.get(Integer.valueOf(i6));
            Logger.d("InAppHelper", "current map: " + hashMap + " type=" + i6);
            if (hashMap == null) {
            }
            str = "current is null ";
        }
        Logger.d("InAppHelper", str);
        return null;
    }

    private static cn.jpush.android.t.a c(Context context, cn.jpush.android.d.d dVar, int i6) {
        int a6;
        int i7;
        Float valueOf = Float.valueOf(0.3f);
        boolean c6 = cn.jpush.android.u.b.c(i6);
        if (40 != i6 && !c6) {
            return new cn.jpush.android.t.a().e(-1).f(-1);
        }
        int i8 = m.a(context).heightPixels;
        if (c6) {
            a6 = -2;
        } else {
            a6 = m.a(context, 94);
        }
        cn.jpush.android.t.a b6 = new cn.jpush.android.t.a().a(valueOf).b(valueOf).a(Integer.valueOf((int) (r6.heightPixels * 0.5f))).b(Integer.valueOf((int) (r6.widthPixels * 0.9f)));
        if (dVar.aH == 0) {
            i7 = 48;
        } else {
            i7 = 80;
        }
        cn.jpush.android.t.a f6 = b6.c(Integer.valueOf(i7)).d(65824).e(Integer.valueOf(i8)).f(Integer.valueOf(a6));
        Boolean bool = Boolean.TRUE;
        return f6.a(true).a(bool).b(bool).b(true).a(dVar.bb * 1000).b(500.0f).c(500.0f);
    }

    public static void a(Context context, long j6) {
        cn.jpush.android.p.a.a(context, System.currentTimeMillis() + "," + (j6 * 1000));
    }

    public static void a(Context context, cn.jpush.android.d.d dVar, int i6) {
        f3772a.clear();
        f3773b.clear();
        cn.jpush.android.t.a b6 = b(context, dVar, i6);
        HashMap<Integer, cn.jpush.android.t.a> hashMap = new HashMap<>();
        hashMap.put(1, b6);
        f3772a.put(Integer.valueOf(i6), hashMap);
        cn.jpush.android.t.a c6 = c(context, dVar, i6);
        HashMap<Integer, cn.jpush.android.t.a> hashMap2 = new HashMap<>();
        hashMap2.put(2, c6);
        f3773b.put(Integer.valueOf(i6), hashMap2);
    }
}
