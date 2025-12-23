package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static q1 f33532a;

    private static synchronized q1 a() {
        q1 q1Var;
        synchronized (d.class) {
            try {
                if (f33532a == null) {
                    f33532a = a1.d().c();
                }
                q1Var = f33532a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return q1Var;
    }

    public static void b(int i6, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() != null && z0.b().a()) {
            if (i6 != 1 && i6 != 0) {
                j1.j("hmsSdk", "Data type no longer collects range.type: " + i6);
                return;
            }
            f33532a.b(i6, str, linkedHashMap);
        }
    }

    @Deprecated
    public static void c(Context context, String str, String str2) {
        if (a() != null) {
            f33532a.c(context, str, str2);
        }
    }

    public static void d(int i6, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() != null && z0.b().a()) {
            if (i6 != 1 && i6 != 0) {
                j1.j("hmsSdk", "Data type no longer collects range.type: " + i6);
                return;
            }
            f33532a.f(i6, str, linkedHashMap);
        }
    }

    public static boolean e() {
        return a1.d().b();
    }

    public static void f() {
        if (a() != null && z0.b().a()) {
            f33532a.a(-1);
        }
    }
}
