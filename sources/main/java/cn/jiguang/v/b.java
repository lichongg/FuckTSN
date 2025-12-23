package cn.jiguang.v;

import android.text.TextUtils;
import cn.jiguang.bz.w;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static long f3297a = 1;

    public static long a() {
        long j6 = f3297a + 1;
        f3297a = j6;
        if (j6 >= 2147483647L) {
            f3297a = 1L;
        }
        return f3297a;
    }

    public static byte[] a(long j6, String str) {
        cn.jiguang.w.a aVar = new cn.jiguang.w.a(20480);
        aVar.a(0);
        aVar.a(j6);
        if (str != null && !TextUtils.isEmpty(str)) {
            aVar.a(w.j(str));
        }
        return aVar.a();
    }
}
