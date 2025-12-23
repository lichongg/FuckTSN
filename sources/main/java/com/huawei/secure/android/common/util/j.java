package com.huawei.secure.android.common.util;

import android.app.Activity;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35280a = "ScreenUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f35281b = 524288;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements PrivilegedAction {

        /* renamed from: a, reason: collision with root package name */
        Method f35282a;

        @Override // java.security.PrivilegedAction
        public Object run() {
            Method method = this.f35282a;
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return null;
        }

        public a(Method method) {
            this.f35282a = method;
        }
    }

    private static void a(Activity activity, int i6) {
        if (activity == null || activity.isFinishing()) {
            e.l("", "activity is null");
        } else {
            activity.getWindow().addFlags(i6);
        }
    }

    private static void b(Activity activity, int i6) {
        if (activity == null || activity.isFinishing()) {
            e.l("", "activity is null");
        } else {
            activity.getWindow().clearFlags(i6);
        }
    }

    public static void c(Activity activity) {
        a(activity, 8192);
    }

    public static void d(Activity activity) {
        b(activity, 8192);
    }

    public static void e(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            Window window = activity.getWindow();
            Method declaredMethod = Class.forName("android.view.Window").getDeclaredMethod("addPrivateFlags", Integer.TYPE);
            AccessController.doPrivileged(new a(declaredMethod));
            declaredMethod.invoke(window, 524288);
        } catch (ClassNotFoundException unused) {
            e.l(f35280a, "hideOverlayWindows ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            e.l(f35280a, "hideOverlayWindows IllegalAccessException");
        } catch (NoSuchMethodException unused3) {
            e.l(f35280a, "hideOverlayWindows NoSuchMethodException");
        } catch (InvocationTargetException unused4) {
            e.l(f35280a, "hideOverlayWindows InvocationTargetException");
        }
    }
}
