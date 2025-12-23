package cn.jiguang.bu;

import android.os.Looper;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {
    private static boolean a(long j6) {
        return Looper.getMainLooper().getThread().getId() == j6;
    }

    public static boolean a(Thread thread) {
        return a(thread.getId());
    }
}
