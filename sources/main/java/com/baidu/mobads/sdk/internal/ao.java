package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10612a = "PluginLoader";

    /* renamed from: b, reason: collision with root package name */
    private static ClassLoader f10613b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();
    }

    public static void a(double d6, an.b bVar, a aVar) {
        u uVar = (u) c.a().a(c.a.f10833a).a();
        if (uVar != null) {
            uVar.startLoadRemotePhp(d6, bVar);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public static void b(int i6) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.b(i6);
        }
    }

    public static Activity c() {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            return vVar.c();
        }
        return null;
    }

    public static boolean d() {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            return vVar.d();
        }
        return false;
    }

    public static boolean e() {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            return vVar.e();
        }
        return false;
    }

    public static boolean f() {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            return vVar.f();
        }
        az.c().e("未能初始化小说sdk，请检查小说包和广告sdk是否匹配");
        return false;
    }

    public static void g() {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.g();
        }
    }

    public static void h() {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.a();
        }
    }

    public static void b() {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.b();
        }
    }

    public static boolean a() {
        return cn.f10907d.booleanValue();
    }

    public static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        u uVar;
        if (!a()) {
            return classLoader;
        }
        if (f10613b == null && (uVar = (u) c.a().a(c.a.f10833a).a()) != null) {
            f10613b = uVar.getClassLoaderFromJar(str, str2, str3, classLoader);
        }
        return f10613b;
    }

    public static void b(int i6, int i7) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.a(i6, i7);
        }
    }

    public static void a(Context context, String str, String str2) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.a(context, str, str2);
        }
    }

    public static void a(w wVar) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.a(wVar);
        }
    }

    public static void a(int i6) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.a(i6);
        }
    }

    public static void a(int i6, boolean z5) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.a(i6, z5);
        }
    }

    public static View a(Context context) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            return vVar.a(context);
        }
        return null;
    }

    public static void a(Context context, String str) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.a(context, str);
        }
    }

    public static void a(boolean z5) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.a(z5);
        }
    }

    public static void a(int i6, int i7) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.b(i6, i7);
        }
    }

    public static void a(boolean z5, int i6, int i7, int i8) {
        v vVar = (v) c.a().a(c.a.f10834b).a();
        if (vVar != null) {
            vVar.a(z5, i6, i7, i8);
        }
    }
}
