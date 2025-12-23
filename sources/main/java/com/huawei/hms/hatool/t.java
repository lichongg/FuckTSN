package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class t {

    /* renamed from: c, reason: collision with root package name */
    private static t f33643c;

    /* renamed from: a, reason: collision with root package name */
    private Context f33644a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f33645b = new Object();

    public static t a() {
        if (f33643c == null) {
            g();
        }
        return f33643c;
    }

    private JSONObject b(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                j1.e("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    private static synchronized void g() {
        synchronized (t.class) {
            if (f33643c == null) {
                f33643c = new t();
            }
        }
    }

    public void c(Context context) {
        synchronized (this.f33645b) {
            try {
                if (this.f33644a == null) {
                    this.f33644a = context;
                    o.a().b(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            o.a().d(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            j1.m("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }

    private t() {
    }

    public void d(String str, int i6) {
        o.a().c(str, i6);
    }

    public void e(String str, int i6, String str2, LinkedHashMap<String, String> linkedHashMap) {
        o.a().d(str, i6, str2, b(linkedHashMap));
    }

    public void h(String str, int i6, String str2, LinkedHashMap<String, String> linkedHashMap) {
        o.a().e(str, i6, str2, b(linkedHashMap), System.currentTimeMillis());
    }
}
