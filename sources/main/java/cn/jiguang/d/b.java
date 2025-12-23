package cn.jiguang.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bb.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Long f2902a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Long f2903b;

    public static long a(Context context, long j6) {
        return (j6 + c(context)) / 1000;
    }

    public static long b(Context context) {
        return a(context, System.currentTimeMillis());
    }

    public static boolean a(Context context) {
        String str;
        if (((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.B())).longValue() <= 0) {
            str = "isValidRegistered uid <= 0";
        } else {
            if (!TextUtils.isEmpty((String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.C()))) {
                return true;
            }
            str = "isValidRegistered regId is empty";
        }
        f.a("SpHelper", str);
        return false;
    }

    public static void b(Context context, long j6) {
        if (j6 > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            f2902a = Long.valueOf(j6);
            f2903b = Long.valueOf(currentTimeMillis);
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.I().a((cn.jiguang.e.a<Long>) Long.valueOf(j6)), cn.jiguang.e.a.H().a((cn.jiguang.e.a<Long>) Long.valueOf(currentTimeMillis))});
        }
    }

    public static long c(Context context) {
        if (f2902a != null && f2903b != null) {
            return f2902a.longValue() - f2903b.longValue();
        }
        Long l6 = (Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.H());
        long longValue = l6.longValue();
        Long l7 = (Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.I());
        long longValue2 = l7.longValue();
        if (longValue == 0 || longValue2 == 0) {
            return 0L;
        }
        f2902a = l7;
        f2903b = l6;
        return longValue2 - longValue;
    }
}
