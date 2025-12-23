package com.bytedance.j.xt;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.j.xt.up.i;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static Context f24180a = null;

    /* renamed from: b, reason: collision with root package name */
    private static long f24181b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static String f24182c = "default";

    /* renamed from: d, reason: collision with root package name */
    private static boolean f24183d;

    /* renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static com.bytedance.j.xt.up.c f24184e;

    /* renamed from: h, reason: collision with root package name */
    private static volatile ConcurrentHashMap<Integer, String> f24187h;

    /* renamed from: j, reason: collision with root package name */
    private static volatile int f24189j;

    /* renamed from: k, reason: collision with root package name */
    private static volatile String f24190k;

    /* renamed from: f, reason: collision with root package name */
    private static i f24185f = new i();

    /* renamed from: g, reason: collision with root package name */
    private static g f24186g = new g();

    /* renamed from: i, reason: collision with root package name */
    private static com.bytedance.j.xt.up.g f24188i = null;

    public static String a() {
        return f24182c;
    }

    public static com.bytedance.j.xt.up.g b() {
        if (f24188i == null) {
            synchronized (e.class) {
                f24188i = new com.bytedance.j.xt.up.g(f24180a);
            }
        }
        return f24188i;
    }

    public static ConcurrentHashMap<Integer, String> c() {
        return f24187h;
    }

    public static com.bytedance.j.xt.up.c d() {
        return f24184e;
    }

    public static long f() {
        return f24181b;
    }

    public static int g() {
        return f24189j;
    }

    public static String h() {
        return f24190k;
    }

    public static Context i() {
        return f24180a;
    }

    public static boolean j() {
        return f24183d;
    }

    public static i k() {
        return f24185f;
    }

    public static g l() {
        return f24186g;
    }

    static void e(Context context, f fVar) {
        f24181b = System.currentTimeMillis();
        f24180a = context;
        f24184e = new com.bytedance.j.xt.up.c(context, fVar);
    }
}
