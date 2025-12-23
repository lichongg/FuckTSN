package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes7.dex */
public class OpenIdHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f51588a = "OpenIdHelper";

    /* renamed from: b, reason: collision with root package name */
    private static Method f51589b;

    public static String a(Context context) {
        b a6 = b.a();
        return a6.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), a6.f51597a);
    }

    public static void a(boolean z5) {
        b.a();
        b.a(z5);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (f51589b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null);
                f51589b = method;
                method.setAccessible(true);
            }
            context = (Context) f51589b.invoke(null, null);
        } catch (Exception e6) {
            e6.toString();
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }

    public static String b(Context context) {
        b a6 = b.a();
        return a6.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), a6.f51598b);
    }

    public static String c(Context context) {
        b a6 = b.a();
        return a6.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), a6.f51600d);
    }

    public static String d(Context context) {
        b a6 = b.a();
        return a6.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), a6.f51599c);
    }
}
