package com.bytedance.sdk.openadsdk.az;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    private static j f27627j;

    public interface j {
        void j(String str, String str2, Throwable th);
    }

    public static void j(j jVar) {
        f27627j = jVar;
    }

    public static boolean j() {
        return f27627j != null;
    }

    public static void j(String str, String str2, Throwable th) {
        if (f27627j == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        f27627j.j(str, str2, th);
    }
}
