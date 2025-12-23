package cn.jiguang.bx;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.SecureRandom;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f2647a;

    private static long a(long j6) {
        return (j6 + (j6 % 2 == 0 ? 1L : 2L)) % 32767;
    }

    private static long a(Context context, long j6) {
        long j7 = c(context).getLong("next_rid", j6);
        if (j7 == j6) {
            return j7;
        }
        long a6 = a(j7);
        c(context).edit().putLong("next_rid", a6).apply();
        return a6;
    }

    public static synchronized long b(Context context) {
        long a6;
        synchronized (e.class) {
            a6 = a(context, -1L);
            if (a6 == -1) {
                a6 = a(Math.abs(new SecureRandom().nextInt(32767)));
                c(context).edit().putLong("next_rid", a6).apply();
            }
        }
        return a6;
    }

    private static SharedPreferences c(Context context) {
        if (f2647a == null) {
            a(context);
        }
        return f2647a;
    }

    public static void a(Context context) {
        f2647a = context.getSharedPreferences("cn.jpush.preferences.support.rid", 0);
    }
}
