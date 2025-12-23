package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a5 {

    /* renamed from: e, reason: collision with root package name */
    public static int f5626e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static int f5627f = 2;

    /* renamed from: a, reason: collision with root package name */
    private String f5628a;

    /* renamed from: b, reason: collision with root package name */
    private int f5629b;

    /* renamed from: c, reason: collision with root package name */
    private long f5630c = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    private String f5631d;

    public static a5 b(String str, String str2) {
        return new a5(f5626e, str, str2);
    }

    public static String c(int i6) {
        return i6 == f5627f ? "error" : "info";
    }

    public static String d(List<a5> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<a5> it = list.iterator();
                    while (it.hasNext()) {
                        String h6 = h(it.next());
                        if (!TextUtils.isEmpty(h6)) {
                            jSONArray.put(h6);
                        }
                    }
                    return jSONArray.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static boolean e(a5 a5Var) {
        return (a5Var == null || TextUtils.isEmpty(a5Var.g())) ? false : true;
    }

    public static a5 f(String str, String str2) {
        return new a5(f5627f, str, str2);
    }

    private static String h(a5 a5Var) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("info", a5Var.g());
            jSONObject.put(d.aC, a5Var.j());
            jSONObject.put("timestamp", a5Var.f5630c);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private String j() {
        return this.f5631d;
    }

    public final int a() {
        return this.f5629b;
    }

    public final String g() {
        new JSONObject();
        return this.f5628a;
    }

    public final String i() {
        return c(this.f5629b);
    }

    private a5(int i6, String str, String str2) {
        this.f5628a = str2;
        this.f5629b = i6;
        this.f5631d = str;
    }
}
