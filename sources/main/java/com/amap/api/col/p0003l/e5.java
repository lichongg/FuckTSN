package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e5 {

    /* renamed from: a, reason: collision with root package name */
    private p4 f5994a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, e5> f5995a = new HashMap();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f5996a;

        /* renamed from: b, reason: collision with root package name */
        private String f5997b;

        /* renamed from: c, reason: collision with root package name */
        private String f5998c;

        private static b a(JSONObject jSONObject) {
            try {
                return new b(jSONObject.optString("sdkVersion"), jSONObject.optString("cpuType"), jSONObject.optString("content"));
            } catch (Throwable unused) {
                return null;
            }
        }

        public static JSONArray e(List<b> list) {
            if (list == null) {
                return new JSONArray();
            }
            JSONArray jSONArray = new JSONArray();
            for (b bVar : list) {
                if (bVar != null && !TextUtils.isEmpty(bVar.f5998c)) {
                    jSONArray.put(bVar.f());
                }
            }
            return jSONArray;
        }

        private JSONObject f() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdkVersion", this.f5996a);
                jSONObject.put("cpuType", this.f5997b);
                jSONObject.put("content", this.f5998c);
                return jSONObject;
            } catch (Throwable unused) {
                return new JSONObject();
            }
        }

        public b(String str, String str2, String str3) {
            this.f5996a = str;
            this.f5997b = str2;
            this.f5998c = str3;
        }

        public static List<b> d(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    arrayList.add(a(jSONArray.getJSONObject(i6)));
                }
                return arrayList;
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }

        public final boolean g(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                str = this.f5996a;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f5997b;
            }
            if (this.f5996a.equals(str) && this.f5997b.equals(str2)) {
                return true;
            }
            return false;
        }
    }

    public final String c(Context context, String str, String str2, String str3) {
        p4 p4Var;
        if (context != null && (p4Var = this.f5994a) != null && !TextUtils.isEmpty(p4Var.a())) {
            List<b> d6 = b.d(b(context, this.f5994a.a(), str3));
            if (d6.size() == 0) {
                return "";
            }
            for (int i6 = 0; i6 < d6.size(); i6++) {
                b bVar = d6.get(i6);
                if (bVar.g(str, str2)) {
                    return bVar.f5998c;
                }
            }
        }
        return null;
    }

    public static e5 a(p4 p4Var) {
        if (p4Var == null || TextUtils.isEmpty(p4Var.a())) {
            return null;
        }
        if (a.f5995a.get(p4Var.a()) == null) {
            a.f5995a.put(p4Var.a(), new e5(p4Var));
        }
        return a.f5995a.get(p4Var.a());
    }

    private static String b(Context context, String str, String str2) {
        return e(context, "C7ADB20F22F238708BA5EE26D0401DB9" + m4.d(str), "ik".concat(String.valueOf(str2)));
    }

    private static String e(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str2)) ? "" : q4.g(e4.e(q4.y(context.getSharedPreferences(str, 0).getString(str2, ""))));
    }

    private static void f(Context context, String str, String str2, String str3) {
        if (str3 == null || TextUtils.isEmpty(str)) {
            return;
        }
        g(context, "C7ADB20F22F238708BA5EE26D0401DB9" + m4.d(str), "ik".concat(String.valueOf(str2)), str3);
    }

    private static void g(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        String E = q4.E(e4.c(q4.o(str3)));
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, E);
        edit.commit();
    }

    public final void d(Context context, String str, String str2, String str3, String str4) {
        p4 p4Var;
        if (context == null || (p4Var = this.f5994a) == null || TextUtils.isEmpty(p4Var.a())) {
            return;
        }
        List<b> d6 = b.d(b(context, this.f5994a.a(), str3));
        for (int i6 = 0; i6 < d6.size(); i6++) {
            b bVar = d6.get(i6);
            if (bVar.g(str, str2)) {
                bVar.f5998c = str4;
                f(context, this.f5994a.a(), str3, b.e(d6).toString());
                return;
            }
        }
        d6.add(new b(str, str2, str4));
        f(context, this.f5994a.a(), str3, b.e(d6).toString());
    }

    private e5(p4 p4Var) {
        this.f5994a = p4Var;
    }
}
