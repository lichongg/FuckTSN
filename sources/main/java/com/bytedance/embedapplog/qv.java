package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.tk;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes3.dex */
final class qv implements tk {
    private static Method cw;

    /* renamed from: j, reason: collision with root package name */
    private static Object f24039j;
    private static Class<?> xt;

    static boolean j() {
        return (xt == null || f24039j == null || cw == null) ? false : true;
    }

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            xt = cls;
            f24039j = cls.newInstance();
            cw = xt.getMethod("getOAID", Context.class);
        } catch (Exception e6) {
            uc.j("Api#static reflect exception! " + e6.getMessage());
        }
    }

    @Override // com.bytedance.embedapplog.tk
    public boolean j(Context context) {
        return j();
    }

    @Override // com.bytedance.embedapplog.tk
    public tk.j xt(Context context) {
        try {
            tk.j jVar = new tk.j();
            jVar.xt = j(context, cw);
            return jVar;
        } catch (Exception e6) {
            uc.j(e6);
            return null;
        }
    }

    qv() {
    }

    private static String j(Context context, Method method) {
        Object obj = f24039j;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
