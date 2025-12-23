package com.jg.ids.l;

import android.content.Context;
import com.jg.ids.i;
import com.jg.ids.k;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class a implements i {

    /* renamed from: a, reason: collision with root package name */
    private static Object f35562a;

    /* renamed from: b, reason: collision with root package name */
    private static Class f35563b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f35564c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f35565d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f35566e;

    static {
        f35562a = null;
        f35563b = null;
        f35564c = null;
        f35565d = null;
        f35566e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f35563b = cls;
            f35562a = cls.newInstance();
        } catch (Throwable th) {
            f35562a = null;
        }
        try {
            f35563b.getMethod("getDefaultUDID", Context.class);
        } catch (Throwable th2) {
        }
        try {
            f35564c = f35563b.getMethod("getOAID", Context.class);
        } catch (Throwable th3) {
            f35564c = null;
        }
        try {
            f35565d = f35563b.getMethod("getVAID", Context.class);
        } catch (Throwable th4) {
            f35565d = null;
        }
        try {
            f35566e = f35563b.getMethod("getAAID", Context.class);
        } catch (Throwable th5) {
            f35566e = null;
        }
    }

    private static String a(Context context, Method method) {
        if (f35562a != null && method != null) {
            try {
                return (String) method.invoke(f35562a, context);
            } catch (Throwable th) {
            }
        }
        return "";
    }

    @Override // com.jg.ids.i
    public final String a(Context context) {
        String a6 = a(context, f35565d);
        k.a().b(a6);
        return a6;
    }

    @Override // com.jg.ids.i
    public final String b(Context context) {
        String a6 = a(context, f35564c);
        k.a().c(a6);
        return a6;
    }

    @Override // com.jg.ids.i
    public final String c(Context context) {
        String a6 = a(context, f35566e);
        k.a().a(a6);
        return a6;
    }

    @Override // com.jg.ids.i
    public final boolean d() {
        return f35562a != null;
    }
}
