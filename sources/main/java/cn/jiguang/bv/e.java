package cn.jiguang.bv;

import cn.jiguang.internal.JNAction;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f2606a = new AtomicBoolean(false);

    public static String a(String str) {
        return null;
    }

    public static boolean b() {
        cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        try {
            String a7 = cn.jiguang.ba.a.a(cn.jiguang.bz.d.a());
            long f6 = cn.jiguang.d.a.f(cn.jiguang.bz.d.a());
            int d6 = d();
            if (!JNAction.isNativeLibraryLoaded) {
                cn.jiguang.bb.f.c("JSM", "no loaded");
                a6.h(3061);
                return false;
            }
            JNAction.i(a7, f6, d6);
            a6.h(3060);
            cn.jiguang.bb.f.c("JSM", "init suc");
            return true;
        } catch (Throwable th) {
            a6.h(3062);
            cn.jiguang.bb.f.l("JSM", "init  err: " + th.getMessage());
            return false;
        }
    }

    public static void a() {
        cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        try {
            a6.h(3052);
            if (!f2606a.compareAndSet(false, true)) {
                cn.jiguang.bb.f.c("JSM", "loaded, skip");
                return;
            }
            boolean d6 = d.d();
            cn.jiguang.bb.f.c("JSM", "usage: " + d6);
            if (d6) {
                cn.jiguang.bb.f.c("JSM", "dy load on");
                c.a().a(a.f2579g);
                return;
            }
            cn.jiguang.bb.f.c("JSM", "load static");
            try {
                JNAction.load();
                b();
                a6.h(3055);
            } catch (Throwable th) {
                a6.h(3056);
                cn.jiguang.bb.f.l("JSM", "static load err: " + th.getMessage());
            }
        } catch (Throwable th2) {
            cn.jiguang.bw.a.a().h(3063);
            cn.jiguang.bb.f.l("JSM", "load so err: " + th2.getMessage());
        }
    }

    public static boolean b(String str) {
        return false;
    }

    public static String c() {
        try {
            return !JNAction.isNativeLibraryLoaded ? "" : JNAction.v();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(String str, long j6, int i6, String str2) {
        try {
            if (JNAction.isNativeLibraryLoaded) {
                JNAction.s(str, j6, i6, str2);
            }
        } catch (Throwable unused) {
        }
    }

    private static int d() {
        cn.jiguang.ba.c.d();
        return 1;
    }

    public static boolean a(File file, String str) {
        return false;
    }

    public static boolean a(String str, String str2) {
        return false;
    }
}
