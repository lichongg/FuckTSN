package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.acse.ottn.l3;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35698a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";

    /* renamed from: b, reason: collision with root package name */
    private final String f35699b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";

    /* renamed from: c, reason: collision with root package name */
    private final String f35700c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";

    /* renamed from: d, reason: collision with root package name */
    private final String f35701d = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";

    /* renamed from: e, reason: collision with root package name */
    private final String f35702e = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject, 0);
            a(jSONObject, 1);
            c(jSONObject, 2);
            d(jSONObject, 3);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private void b(JSONObject jSONObject, int i6) {
        try {
            Object a6 = dh.a(new String(c.a(f35698a.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
            if (a6 != null) {
                a(a6, jSONObject, i6);
            }
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject, int i6) {
        Object a6;
        Object a7;
        try {
            if (Build.VERSION.SDK_INT < 29 || (a6 = dh.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(c.a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) == null || (a7 = dh.a("android.util.Singleton", a6, l3.f4736f, new Object[0])) == null) {
                return;
            }
            a(a7, jSONObject, i6);
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject, int i6) {
        Object a6;
        try {
            Object a7 = dh.a(new String(c.a(f35698a.getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
            if (a7 == null || (a6 = dh.a(a7.getClass(), a7, "mInstrumentation")) == null) {
                return;
            }
            a(a6, jSONObject, i6);
        } catch (Exception unused) {
        }
    }

    private void a(JSONObject jSONObject, int i6) {
        Object a6;
        Object a7;
        try {
            String str = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2));
            String str2 = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2));
            if (Build.VERSION.SDK_INT >= 26) {
                a6 = dh.a(str, "IActivityManagerSingleton");
            } else {
                a6 = dh.a(str2, "gDefault");
            }
            if (a6 == null || (a7 = dh.a("android.util.Singleton", a6, l3.f4736f, new Object[0])) == null) {
                return;
            }
            a(a7, jSONObject, i6);
        } catch (Exception unused) {
        }
    }

    private boolean a(Object obj, JSONObject jSONObject, int i6) {
        if (jSONObject == null) {
            return false;
        }
        try {
            boolean isProxyClass = Proxy.isProxyClass(obj.getClass());
            String name = obj.getClass().getName();
            if (isProxyClass) {
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                jSONObject.put(sb.toString(), isProxyClass ? 1 : 0);
                jSONObject.put(i6 + "-c", name);
                return isProxyClass;
            }
            if (i6 == 3 && !name.contains("Instrumentation")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i6);
                jSONObject.put(sb2.toString(), isProxyClass ? 1 : 0);
                jSONObject.put(i6 + "-c", name);
            }
            return isProxyClass;
        } catch (Exception unused) {
            return false;
        }
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            PackageManager packageManager = context.getPackageManager();
            Object a6 = dh.a(packageManager.getClass(), packageManager, "mPM");
            if (a6 == null) {
                return null;
            }
            if (a(a6, jSONObject, 0)) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
