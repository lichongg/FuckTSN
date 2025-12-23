package cn.jpush.android.helper;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static long f3687a = 1;

    public static long a() {
        long j6 = f3687a + 1;
        f3687a = j6;
        if (j6 >= 2147483647L) {
            f3687a = 1L;
        }
        return f3687a;
    }
}
